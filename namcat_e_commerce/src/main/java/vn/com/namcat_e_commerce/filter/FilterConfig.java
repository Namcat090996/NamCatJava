package vn.com.namcat_e_commerce.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    
    //Tạo class cấu hình để đăng ký filter
    @Bean
    public FilterRegistrationBean<AuthorizationFilter> loginFilter() {
        
        FilterRegistrationBean<AuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        
        //Đăng ký AuthorizationFilter
        registrationBean.setFilter(new AuthorizationFilter());
        
        //Cấu hình filter áp dụng cho các URL bắt đầu với /admin/
        registrationBean.addUrlPatterns("/admin/*");
        
        //Đặt độ ưu tiên (tùy chọn)
        registrationBean.setOrder(1);  // Đặt ưu tiên cho filter (nếu cần)
        
        return registrationBean;
    }
}
