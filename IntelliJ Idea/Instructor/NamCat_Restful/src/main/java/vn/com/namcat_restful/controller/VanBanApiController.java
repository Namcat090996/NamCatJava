package vn.com.namcat_restful.controller;

import jakarta.validation.Valid;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.com.namcat_restful.entities.Message;
import vn.com.namcat_restful.entities.VanBan;
import vn.com.namcat_restful.service.VanBanService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin
@RestController
@RequestMapping("api")
public class VanBanApiController {

    @Autowired
    VanBanService vanBanService;
    
    @GetMapping("/vanban/{id}")
    public ResponseEntity<?> layChiTiet(@PathVariable("id") String id) {
        
        VanBan objVB = vanBanService.layChiTiet(id);
        
        if(objVB != null) {
            return new ResponseEntity<VanBan>(objVB, HttpStatus.OK);
        }
        else {
            Message msg = new Message("notFound", "Khong tim thay chu de co ma: " + id);
            return new ResponseEntity<Message>(msg, HttpStatus.NOT_FOUND);
        }
    }
    
    @Value("${fileupload.path}")
    private String fUploadPath;
    
    public String xuLyUploadFile(MultipartFile fUpload) throws IOException {
        
        String tenFile = fUpload.getOriginalFilename();
        
        String loaiFile = "";
        
        int soTrang = 0;
        
        String duongDan = fUploadPath;
        
        Path directory = Paths.get(duongDan);
        
        if(Files.exists(directory))
        {
            Files.createDirectories(directory);
        }
        
        Path filePath = directory.resolve(tenFile);
        
        fUpload.transferTo(filePath.toFile());
        
        if(tenFile.contains(".") && tenFile.lastIndexOf(".") != 0)
        {
            loaiFile = tenFile.substring(tenFile.lastIndexOf(".") + 1).toLowerCase();
        }
        
        if(tenFile.endsWith(".doc"))
        {
            soTrang = getDOCPageCount(filePath.toFile());
        }
        else if (tenFile.endsWith("docx"))
        {
            soTrang = getDOCXPageCount(filePath.toFile());
        }
        else if (tenFile.endsWith(".pdf"))
        {
            soTrang = getPDFPageCount(filePath.toFile());
        }
        
        return tenFile + "," + loaiFile + "," + soTrang;
    
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
    
    @PostMapping("/themmoi")
    public ResponseEntity<?> themMoi(@Valid @RequestBody VanBan objVB, BindingResult result, @RequestParam("fUpload")MultipartFile fUpload) {
        
        if(result.hasErrors())
        {
        
        }
    
    }

}
