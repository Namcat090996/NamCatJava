package vn.com.namcat_restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.namcat_restful.entities.*;
import vn.com.namcat_restful.service.DonViService;
import vn.com.namcat_restful.service.LoaiVBService;
import vn.com.namcat_restful.service.VanBanService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class VanBanController {
    
    @Autowired
    VanBanService vanBanService;
    
    @Autowired
    DonViService donViService;
    
    @Autowired
    LoaiVBService loaiVBService;
    
    @Value("${fileupload.path}")
    private String fUploadPath;
    
    @RequestMapping(value = "/admin/vanban")
    public String hienThiVanBanTheoNgay(@ModelAttribute("vanban") VanBanModel objVB, Model model)
    {
        
        //Get list and return page
        List<VanBan> lstVB = vanBanService.timKiemVanBanTheoNgay(objVB.getTuKhoa(), objVB.getLoaiVanBan(), objVB.getDonVi(), objVB.getTuNgay(), objVB.getDenNgay());
        
        //Keep user information which has typed
        model.addAttribute("vanban", objVB);
        
        model.addAttribute("lstVB", lstVB);
        
        return "admin/VanBanCallAPI";
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
    
    //Download file
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
}
