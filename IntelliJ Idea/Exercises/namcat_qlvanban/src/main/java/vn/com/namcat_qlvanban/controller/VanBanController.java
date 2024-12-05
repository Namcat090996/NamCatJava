package vn.com.namcat_qlvanban.controller;

import jakarta.validation.Valid;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat_qlvanban.entities.DonVi;
import vn.com.namcat_qlvanban.entities.LoaiVanBan;
import vn.com.namcat_qlvanban.entities.VanBan;
import vn.com.namcat_qlvanban.entities.VanBanModel;
import vn.com.namcat_qlvanban.service.DonViService;
import vn.com.namcat_qlvanban.service.LoaiVBService;
import vn.com.namcat_qlvanban.service.VanBanService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Controller
public class VanBanController {
    
    @Autowired
    VanBanService vanBanService;
    
    @Autowired
    DonViService donViService;
    
    @Autowired
    LoaiVBService loaiVBService;
    
    @RequestMapping(value = "/admin/vanban")
    public String hienThiVanBanTheoNgay(@ModelAttribute("vanban") VanBanModel objVB, Model model)
    {
        
        //Get list and return page
        List<VanBan> lstVB = vanBanService.timKiemVanBanTheoNgay(objVB.getTuKhoa(), objVB.getLoaiVanBan(), objVB.getDonVi(), objVB.getTuNgay(), objVB.getDenNgay());
        
        //Keep user information which has typed
        model.addAttribute("vanban", objVB);
        
        model.addAttribute("lstVB", lstVB);
        
        return "admin/QuanLyVanBan";
    }
    
    @RequestMapping(value = "/admin/vanban/them")
    public String hienThiThemMoiVB(Model model)
    {
        model.addAttribute("vanban", new VanBan());
        model.addAttribute("maVBCheck", "");
        
        return "admin/VanBanAdd";
    }
    
    @RequestMapping(value = "/admin/vanban/sua/{id}")
    public String hienThiChiTietVB(@PathVariable("id") String maVB, Model model)
    {
        //Get object by id
        VanBan objVB = vanBanService.layChiTiet(maVB);
        
        model.addAttribute("vanban", objVB);
        model.addAttribute("maVBCheck", maVB);
        
        return "admin/VanBanAdd";
    }
    
    @Value("${fileupload.path}")
    private String fUploadPath;

    @RequestMapping(value = "/admin/vanban/themmoiVB", method = RequestMethod.POST)
    public String themMoiHoacSuaVB(@ModelAttribute("vanban") @Valid VanBan objVB, BindingResult result, @RequestParam("idCheck") String idCheck, Model model, @RequestParam("fUpload") MultipartFile fUpload)
    {
        
        if(result.hasErrors())
        {
            model.addAttribute("vanban", objVB);
            model.addAttribute("maVBCheck", idCheck);

            return "admin/VanBanAdd";
        }
        else
        {
            String tenFile = "", loaiFile = "";
            int soTrang = 0;
            boolean isInsert = true;
            
            VanBan objVBCheck = vanBanService.layChiTiet(objVB.getMaVanBan());
            
            if(!idCheck.isEmpty())
            {
                isInsert = false;
                tenFile = objVBCheck.getTenFile();
                loaiFile = objVBCheck.getDinhDang();
                soTrang = objVBCheck.getSoTrang();
            }
            
            boolean ketQua = false;
            
            String duongDan = "";
            
            if(fUpload != null && !fUpload.isEmpty())
            {
                //Get name of file
                tenFile = fUpload.getOriginalFilename();
                
                duongDan = fUploadPath;
                
                try {
                
                    //Get directory with full the path
                    Path directory = Paths.get(duongDan);
                    
                    System.out.println("Duong dan la " + directory);
                    
                    //Check if directory has already existed
                    if(!Files.exists(directory))
                    {
                        Files.createDirectory(directory);
                    }
                    
                    //Create the complete path including directory + filename
                    Path filePath = directory.resolve(tenFile);
                    
                    //Transfer file to the path on server with File type
                    fUpload.transferTo(filePath.toFile());
                    
                    //Get file type
                    if(tenFile.contains(".") && tenFile.lastIndexOf(".") != 0)
                    {
                        loaiFile = tenFile.substring(tenFile.lastIndexOf(".") + 1);
                        loaiFile = loaiFile.toLowerCase();
                    }
                    else
                    {
                        loaiFile = "";
                    }
                    
                    if(tenFile.endsWith(".doc"))
                    {
                        soTrang = getDOCPageCount(filePath.toFile());
                    }
                    else if(tenFile.endsWith("docx"))
                    {
                        soTrang = getDOCXPageCount(filePath.toFile());
                    }
                    else if(tenFile.endsWith(".pdf"))
                    {
                        soTrang = getPDFPageCount(filePath.toFile());
                    }
                    
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                    model.addAttribute("fileError", "Có lỗi xảy ra khi tải lên file");
                    model.addAttribute("vanban", objVB);
                    return "admin/VanBanAdd";
                }
            }
            
            objVB.setTenFile(tenFile);
            objVB.setDinhDang(loaiFile);
            objVB.setSoTrang(soTrang);
            
            if(isInsert)
            {
                if(objVBCheck == null)
                {
                    if(fUpload.isEmpty())
                    {
                        model.addAttribute("upload", "Vui lòng tải lên 01 tệp");
                        model.addAttribute("vanban", objVB);
                        return "admin/VanBanAdd";
                    }
                    objVB.setNgayCapNhat(LocalDate.now());
                    ketQua = vanBanService.themVanBan(objVB);
                }
                else
                {
                    model.addAttribute("duplicatedId", "Mã văn bản này đã tồn tại");
                    model.addAttribute("vanban", objVB);
                    return "admin/VanBanAdd";
                }
            }
            else
            {
                objVB.setNgayCapNhat(LocalDate.now());
                ketQua = vanBanService.suaVanban(objVB);
            }
            
            if(ketQua)
            {
                return "redirect:/admin/vanban";
            }
            
            return "admin/VanBanAdd";
        }
    }
    
    //Get page number of pdf file
    private int getPDFPageCount(File file) throws IOException
    {
        try (PDDocument document = PDDocument.load(file)) {
            return document.getNumberOfPages();
        }
    }
    
    //Get page number of docx file
    private int getDOCXPageCount(File file) throws IOException
    {
        //Create a stream to read file
        try (FileInputStream fileIS = new FileInputStream(file)) {
            
            //Parse docx to XWPDFDocument
            XWPFDocument document = new XWPFDocument(fileIS);
            
            //Get data properties from above document and get page number
            return document.getProperties().getExtendedProperties().getPages();
            
        }
    }
    
    //Get page number of doc file
    private int getDOCPageCount(File file) throws IOException
    {
        //Create a stream to read file
        try (FileInputStream fileIS = new FileInputStream(file)) {
            
            //Parse docx to XWPDFDocument
            HWPFDocument document = new HWPFDocument(fileIS);
            
            //Get data information and get page number
            return document.getSummaryInformation().getPageCount();
        }
    }
    
    @RequestMapping(value = "/admin/vanban/xoa/{id}")
    public String xoaThongTinVB(@PathVariable("id") String maVB, Model model)
    {
        VanBan objVB = vanBanService.layChiTiet(maVB);
        
        boolean ketQua = false;
        
        if(objVB != null)
        {
            try {
                ketQua = vanBanService.xoaVanBan(maVB);
                
                if(ketQua)
                {
                    return "redirect:/admin/vanban";
                }
            }
            catch(DataIntegrityViolationException ex)
            {
                model.addAttribute("deleteFail","Không thể xóa thông tin này");
            }
        }
        
        List<VanBan> lstVB = vanBanService.timKiemVanBan("","","");
        
        model.addAttribute("lstVB", lstVB);
        
        return "admin/QuanLyVanBan";
    }
    
    @ModelAttribute("lstLoaiVB")
    public List<LoaiVanBan> layDanhSachLoaiVB()
    {
        //Get list
        List<LoaiVanBan> lstLoaiVB = loaiVBService.layDSLoaiVB();
        
        //Return result
        return lstLoaiVB;
    }
    
    @ModelAttribute("lstDonVi")
    public List<DonVi> layDanhSachDonVi()
    {
        //Get list
        List<DonVi> lstDonVi = donViService.layDSDonVi();
        
        //Return result
        return lstDonVi;
    }
    
    @RequestMapping(value = "/admin/vanban/files/{fileName}", method = RequestMethod.GET)
    public ResponseEntity<Resource> getFile(@PathVariable("fileName") String fileName) {
        try {
            //Create the complete path including directory + filename
            Path filePath = Paths.get(fUploadPath).resolve(fileName).normalize();
            
            //Change filepath to resource object (web-accessible resource by browser) and covert filepath to valid URL resource
            Resource resource = new UrlResource(filePath.toUri());
            
            //Check if the resource has already existed
            if (resource.exists()) {
                
                //Detects the MIME type of file (pdf, doc, docx ...)
                String contentType = Files.probeContentType(filePath);
                
                String loaiFile = "";
                
                //Get file type
                if(fileName.contains(".") && fileName.lastIndexOf(".") != 0)
                {
                    loaiFile = fileName.substring(fileName.lastIndexOf("."));
                }
                else
                {
                    loaiFile = "";
                }
                
                return ResponseEntity.ok()
                        //Set MIME type of response when it isn't null, when it is null, set it to binary file
                        .contentType(MediaType.parseMediaType(contentType != null ? contentType : "application/octet-stream"))
                        //Set header of response (view in browser, and set name when download)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + "Downloaded file" + loaiFile + "\"")
                        //Set body of file
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) { //When appear any exceptions (file error, invalid file path ...)
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @RestController
    @RequestMapping("/api/admin/vanban")
    public class VanBanController {
        
        @Autowired
        private VanBanService vanBanService;
        
        private static final String fUploadPath = "C:/uploads/";
        
        // API xử lý upload file
        @PostMapping("/upload")
        public ResponseEntity<?> uploadFile(@RequestParam("fUpload") MultipartFile fUpload) {
            List<ErrorDetail> errors = new ArrayList<>();
            String tenFile = "", loaiFile = "";
            int soTrang = 0;
            
            if (fUpload == null || fUpload.isEmpty()) {
                errors.add(new ErrorDetail("fUpload", "Vui lòng tải lên một tệp"));
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            
            try {
                // Lấy tên file
                tenFile = fUpload.getOriginalFilename();
                Path directory = Paths.get(fUploadPath);
                
                // Tạo thư mục nếu chưa tồn tại
                if (!Files.exists(directory)) {
                    Files.createDirectory(directory);
                }
                
                // Lưu file vào thư mục
                Path filePath = directory.resolve(tenFile);
                fUpload.transferTo(filePath.toFile());
                
                // Lấy thông tin định dạng và số trang
                loaiFile = tenFile.substring(tenFile.lastIndexOf(".") + 1).toLowerCase();
                if (tenFile.endsWith(".doc")) {
                    soTrang = getDOCPageCount(filePath.toFile());
                } else if (tenFile.endsWith(".docx")) {
                    soTrang = getDOCXPageCount(filePath.toFile());
                } else if (tenFile.endsWith(".pdf")) {
                    soTrang = getPDFPageCount(filePath.toFile());
                }
                
            } catch (Exception ex) {
                errors.add(new ErrorDetail("fileUpload", "Có lỗi xảy ra khi tải lên file"));
                return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("fileName", tenFile);
            response.put("fileType", loaiFile);
            response.put("numPages", soTrang);
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        
        // API thêm văn bản mới
        @PostMapping("/themmoi")
        public ResponseEntity<?> addVanBan(@Valid @RequestBody VanBan objVB, BindingResult result, @RequestParam("fUpload") MultipartFile fUpload) {
            List<ErrorDetail> errors = new ArrayList<>();
            
            if (result.hasErrors()) {
                for (FieldError fieldError : result.getFieldErrors()) {
                    errors.add(new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage()));
                }
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            
            // Kiểm tra nếu đã tồn tại mã văn bản
            VanBan objVBCheck = vanBanService.layChiTiet(objVB.getMaVanBan());
            if (objVBCheck != null) {
                errors.add(new ErrorDetail("maVanBan", "Mã văn bản này đã tồn tại"));
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            
            // Kiểm tra và xử lý upload file
            if (fUpload.isEmpty()) {
                errors.add(new ErrorDetail("fUpload", "Vui lòng tải lên 01 tệp"));
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            
            // Tiến hành lưu văn bản
            objVB.setNgayCapNhat(LocalDate.now());
            boolean ketQua = vanBanService.themVanBan(objVB);
            if (ketQua) {
                return new ResponseEntity<>(objVB, HttpStatus.CREATED);
            } else {
                errors.add(new ErrorDetail("general", "Không thể thêm văn bản"));
                return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        
        // API cập nhật văn bản
        @PutMapping("/capnhat")
        public ResponseEntity<?> updateVanBan(@Valid @RequestBody VanBan objVB, BindingResult result, @RequestParam("fUpload") MultipartFile fUpload) {
            List<ErrorDetail> errors = new ArrayList<>();
            
            if (result.hasErrors()) {
                for (FieldError fieldError : result.getFieldErrors()) {
                    errors.add(new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage()));
                }
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            
            // Tiến hành cập nhật văn bản
            objVB.setNgayCapNhat(LocalDate.now());
            boolean ketQua = vanBanService.suaVanban(objVB);
            if (ketQua) {
                return new ResponseEntity<>(objVB, HttpStatus.OK);
            } else {
                errors.add(new ErrorDetail("general", "Không thể cập nhật văn bản"));
                return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
    
    
    @RestController
    @RequestMapping("/api/vanban")
    public class VanBanController {
        
        @Value("${fileupload.path}")
        private String fUploadPath;
        
        @Autowired
        private VanBanService vanBanService;
        
        @PostMapping("/upload")
        public ResponseEntity<?> uploadFile(@RequestParam("fUpload") MultipartFile fUpload) {
            if (fUpload.isEmpty()) {
                return new ResponseEntity<>(new Message("fUpload", "Vui lòng tải lên 01 tệp"), HttpStatus.BAD_REQUEST);
            }
            
            String tenFile = fUpload.getOriginalFilename();
            String loaiFile = "";
            int soTrang = 0;
            
            try {
                Path directory = Paths.get(fUploadPath);
                
                if (!Files.exists(directory)) {
                    Files.createDirectories(directory);
                }
                
                Path filePath = directory.resolve(tenFile);
                fUpload.transferTo(filePath.toFile());
                
                if (tenFile.contains(".") && tenFile.lastIndexOf(".") != 0) {
                    loaiFile = tenFile.substring(tenFile.lastIndexOf(".") + 1).toLowerCase();
                }
                
                if (tenFile.endsWith(".doc")) {
                    soTrang = getDOCPageCount(filePath.toFile());
                } else if (tenFile.endsWith(".docx")) {
                    soTrang = getDOCXPageCount(filePath.toFile());
                } else if (tenFile.endsWith(".pdf")) {
                    soTrang = getPDFPageCount(filePath.toFile());
                }
                
                Map<String, Object> fileDetails = new HashMap<>();
                fileDetails.put("tenFile", tenFile);
                fileDetails.put("loaiFile", loaiFile);
                fileDetails.put("soTrang", soTrang);
                
                return new ResponseEntity<>(fileDetails, HttpStatus.OK);
                
            } catch (Exception ex) {
                ex.printStackTrace();
                return new ResponseEntity<>(new Message("fileError", "Có lỗi xảy ra khi tải lên file"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        
        @PostMapping("/them-moi")
        public ResponseEntity<?> themMoiVanBan(@Valid @RequestBody VanBan objVB, BindingResult result) {
            if (result.hasErrors()) {
                List<Message> errors = new ArrayList<>();
                for (FieldError fieldError : result.getFieldErrors()) {
                    errors.add(new Message(fieldError.getField(), fieldError.getDefaultMessage()));
                }
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            
            VanBan existingVanBan = vanBanService.layChiTiet(objVB.getMaVanBan());
            if (existingVanBan != null) {
                return new ResponseEntity<>(new Message("maVanBan", "Mã văn bản này đã tồn tại"), HttpStatus.BAD_REQUEST);
            }
            
            objVB.setNgayCapNhat(LocalDate.now());
            boolean success = vanBanService.themVanBan(objVB);
            
            if (success) {
                return new ResponseEntity<>(objVB, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(new Message("general", "Không thể thêm văn bản"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        
        @PutMapping("/cap-nhat/{id}")
        public ResponseEntity<?> suaVanBan(@PathVariable("id") String id, @Valid @RequestBody VanBan objVB, BindingResult result) {
            if (result.hasErrors()) {
                List<Message> errors = new ArrayList<>();
                for (FieldError fieldError : result.getFieldErrors()) {
                    errors.add(new Message(fieldError.getField(), fieldError.getDefaultMessage()));
                }
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
            
            VanBan existingVanBan = vanBanService.layChiTiet(id);
            if (existingVanBan == null) {
                return new ResponseEntity<>(new Message("maVanBan", "Mã văn bản không tồn tại"), HttpStatus.NOT_FOUND);
            }
            
            objVB.setNgayCapNhat(LocalDate.now());
            boolean success = vanBanService.suaVanban(objVB);
            
            if (success) {
                return new ResponseEntity<>(objVB, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new Message("general", "Không thể cập nhật văn bản"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
