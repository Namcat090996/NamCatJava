package vn.com.stanford.stanford_bookstore_sb_je0824.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import vn.com.stanford.stanford_bookstore_sb_je0824.interceptor.AuthorizationInterceptor;

@Configuration
public class AuthorizationConfig  implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/admin/**", "/admin/sach/**");
    }
}