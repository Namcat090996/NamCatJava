package vn.com.namcat_qlvanban;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.com.namcat_qlvanban.entities.VanBan;
import vn.com.namcat_qlvanban.model.VanBanDao;

import java.util.List;

@SpringBootTest
class NamcatQlvanbanApplicationTests {
    
    @Autowired
    VanBanDao vanBanDao;
    
    @Test
    void contextLoads() {
        
        List<VanBan> lstVB = vanBanDao.timKiemVanBang("", "", "");
        
        for(VanBan s : lstVB)
        {
            System.out.println(s + "-");
        }
    }
    
    
    
    
}
