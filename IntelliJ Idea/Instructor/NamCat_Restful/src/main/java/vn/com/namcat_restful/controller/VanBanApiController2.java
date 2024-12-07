//package vn.com.namcat_restful.controller;
//
//import jakarta.validation.Valid;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import vn.com.namcat_restful.entities.Message;
//import vn.com.namcat_restful.entities.VanBan;
//import vn.com.namcat_restful.service.VanBanService;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("api")
//public class VanBanApiController2 {
//
//    @Autowired
//    VanBanService vanBanService;
//
//    @GetMapping("/vanban/{id}")
//    public ResponseEntity<?> layChiTiet(@PathVariable("id") String id) {
//
//        VanBan objVB = vanBanService.layChiTiet(id);
//
//        if(objVB != null) {
//            return new ResponseEntity<VanBan>(objVB, HttpStatus.OK);
//        }
//        else {
//            Message msg = new Message("notFound", "Khong tim thay chu de co ma: " + id);
//            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Value("${fileupload.path}")
//    private String fUploadPath;
//
//    public String xuLyUploadFile(MultipartFile fUpload) throws IOException {
//
//        String tenFile = fUpload.getOriginalFilename();
//
//        String loaiFile = "";
//
//        int soTrang = 0;
//
//        String duongDan = fUploadPath;
//
//        Path directory = Paths.get(duongDan);
//
//        if(!Files.exists(directory))
//        {
//            Files.createDirectories(directory);
//        }
//
//        Path filePath = directory.resolve(tenFile);
//
//        fUpload.transferTo(filePath.toFile());
//
//        if(tenFile.contains(".") && tenFile.lastIndexOf(".") != 0)
//        {
//            loaiFile = tenFile.substring(tenFile.lastIndexOf(".") + 1).toLowerCase();
//        }
//
//        if(tenFile.endsWith(".doc"))
//        {
//            soTrang = getDOCPageCount(filePath.toFile());
//        }
//        else if (tenFile.endsWith("docx"))
//        {
//            soTrang = getDOCXPageCount(filePath.toFile());
//        }
//        else if (tenFile.endsWith(".pdf"))
//        {
//            soTrang = getPDFPageCount(filePath.toFile());
//        }
//
//        return tenFile + "," + loaiFile + "," + soTrang;
//
//    }
//
//    //Get page number of pdf file
//    private int getPDFPageCount(File file) throws IOException
//    {
//        try (PDDocument document = PDDocument.load(file)) {
//            return document.getNumberOfPages();
//        }
//    }
//
//    //Get page number of docx file
//    private int getDOCXPageCount(File file) throws IOException
//    {
//        //Create a stream to read file
//        try (FileInputStream fileIS = new FileInputStream(file)) {
//
//            //Parse docx to XWPDFDocument
//            XWPFDocument document = new XWPFDocument(fileIS);
//
//            //Get data properties from above document and get page number
//            return document.getProperties().getExtendedProperties().getPages();
//
//        }
//    }
//
//    //Get page number of doc file
//    private int getDOCPageCount(File file) throws IOException
//    {
//        //Create a stream to read file
//        try (FileInputStream fileIS = new FileInputStream(file)) {
//
//            //Parse docx to XWPDFDocument
//            HWPFDocument document = new HWPFDocument(fileIS);
//
//            //Get data information and get page number
//            return document.getSummaryInformation().getPageCount();
//        }
//    }
//
//    @PostMapping(value = "/vanban/themmoi", consumes = {"multipart/form-data"})
//    public ResponseEntity<?> themMoi(@Valid @RequestBody VanBan objVB, BindingResult result, @RequestParam("fUpload") MultipartFile fUpload) {
//
//        List<Message> msg1 = new ArrayList<Message>();
//
//        if(result.hasErrors())
//        {
//            for(FieldError fieldError : result.getFieldErrors())
//            {
//                msg1.add(new Message(fieldError.getField(), fieldError.getDefaultMessage()));
//            }
//
//            return new ResponseEntity<List<Message>>(msg1, HttpStatus.BAD_REQUEST);
//        }
//        else
//        {
//
//            VanBan objVBCheck = vanBanService.layChiTiet(objVB.getMaVanBan());
//
//            if(objVBCheck != null)
//            {
//                msg1.add(new Message("maThem", "Ma van ban nay da ton tai"));
//                return new ResponseEntity<List<Message>>(msg1, HttpStatus.BAD_REQUEST);
//            }
//            else
//            {
//                String tenFile = "", loaiFile = "";
//                int soTrang = 0;
//
//                //Xu ly upload file
//                if(!fUpload.isEmpty())
//                {
//                    try {
//                        String fileUpload = xuLyUploadFile(fUpload);
//
//                        String[] uploadInfo = fileUpload.split(",");
//
//                        tenFile = uploadInfo[0];
//                        loaiFile = uploadInfo[1];
//                        soTrang = Integer.parseInt(uploadInfo[2]);
//                    }
//                    catch (Exception ex) {
//                        msg1.add(new Message("fileThemLoi", "Co loi khi tai len tep" + ex.getMessage()));
//                        return new ResponseEntity<List<Message>>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
//                    }
//                }
//                else
//                {
//                    msg1.add(new Message("fileThemRong", "Vui long tai len 1 tep"));
//                    return new ResponseEntity<List<Message>>(msg1, HttpStatus.BAD_REQUEST);
//                }
//
//                objVB.setTenFile(tenFile);
//                objVB.setDinhDang(loaiFile);
//                objVB.setSoTrang(soTrang);
//                objVB.setNgayCapNhat(LocalDate.now());
//
//                boolean ketQua = vanBanService.themVanBan(objVB);
//
//                if(ketQua)
//                {
//                    return new ResponseEntity<VanBan>(objVB, HttpStatus.CREATED);
//                }
//
//                msg1.add(new Message("themVBLoi", "Khong the them moi van ban"));
//                return new ResponseEntity<List<Message>>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
//
//            }
//        }
//    }
//
//    @PutMapping(value = "/vanban/capnhat/{id}", consumes = {"multipart/form-data"})
//    public ResponseEntity<?> capNhat(@PathVariable("id") String id, @Valid @RequestBody VanBan objVB, BindingResult result, @RequestParam("fUpload") MultipartFile fUpload) {
//
//        List<Message> msg2 = new ArrayList<Message>();
//
//        if(result.hasErrors())
//        {
//            for(FieldError fieldError : result.getFieldErrors())
//            {
//                msg2.add(new Message(fieldError.getField(), fieldError.getDefaultMessage()));
//            }
//
//            return new ResponseEntity<List<Message>>(msg2, HttpStatus.BAD_REQUEST);
//        }
//        else
//        {
//            VanBan objVBCheck = vanBanService.layChiTiet(id);
//            if(objVBCheck == null)
//            {
//                msg2.add(new Message("maCapNhat", "Khong tim thay van ban voi ma " + id));
//                return new ResponseEntity<List<Message>>(msg2, HttpStatus.NOT_FOUND);
//            }
//            else
//            {
//                String tenFile = objVBCheck.getTenFile();
//                String loaiFile = objVBCheck.getDinhDang();
//                int soTrang = objVBCheck.getSoTrang();
//
//                //Xu ly upload file
//                if(!fUpload.isEmpty())
//                {
//                    try {
//                        String fileUpload = xuLyUploadFile(fUpload);
//
//                        String[] uploadInfo = fileUpload.split(",");
//
//                        tenFile = uploadInfo[0];
//                        loaiFile = uploadInfo[1];
//                        soTrang = Integer.parseInt(uploadInfo[2]);
//                    }
//                    catch (Exception ex) {
//                        msg2.add(new Message("fileThemLoi", "Co loi khi tai len tep" + ex.getMessage()));
//                        return new ResponseEntity<List<Message>>(msg2, HttpStatus.INTERNAL_SERVER_ERROR);
//                    }
//                }
//
//                objVB.setTenFile(tenFile);
//                objVB.setDinhDang(loaiFile);
//                objVB.setSoTrang(soTrang);
//                objVB.setNgayCapNhat(LocalDate.now());
//
//                boolean ketQua = vanBanService.suaVanban(objVB);
//
//                if (ketQua) {
//                    return new ResponseEntity<VanBan>(objVB, HttpStatus.OK);
//                } else {
//                    msg2.add(new Message("capNhatVBLoi", "Khong the cap nhat van ban"));
//                    return new ResponseEntity<List<Message>>(msg2, HttpStatus.INTERNAL_SERVER_ERROR);
//                }
//            }
//        }
//    }
//
//    @DeleteMapping("/vanban/xoa/{id}")
//    public ResponseEntity<?> xoa(@PathVariable("id") String id)
//    {
//        List<Message> msg3 = new ArrayList<Message>();
//
//        VanBan objVBCheck = vanBanService.layChiTiet(id);
//
//        if(objVBCheck == null)
//        {
//            msg3.add(new Message("maXoa", "Khong tim thay van ban voi ma " + id));
//            return new ResponseEntity<List<Message>>(msg3, HttpStatus.NOT_FOUND);
//        }
//        else
//        {
//            boolean ketQua = vanBanService.xoaVanBan(id);
//
//            if(ketQua)
//            {
//                msg3.add(new Message("xoaThanhCong", "Xoa thanh cong van ban voi ma " + id));
//                return new ResponseEntity<List<Message>>(msg3, HttpStatus.OK);
//            }
//
//            msg3.add(new Message("xoaLoi", "Khong xoa duoc van ban voi ma " + id));
//            return new ResponseEntity<List<Message>>(msg3, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//}
