package vn.com.namcat_e_commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class NamcatECommerceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(NamcatECommerceApplication.class, args);
    }
    
}
