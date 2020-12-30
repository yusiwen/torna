package torna.web.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import torna.common.context.SpringContext;
import torna.common.support.HashIdParamResolver;
import torna.common.util.FastjsonUtil;
import torna.web.interceptor.LoginInterceptor;

import java.util.List;

/**
 * @author tanghc
 */
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer, ApplicationContextAware {

    @Value("${torna.front-location:}")
    private String frontLocation;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.setApplicationContext(applicationContext);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] excludes = {
                // 排除前端资源
                "/", "/*.html", "/*.ico", "/static/**",
                // 排除服务端请求
                "/api", "/api/**", "/opendoc/**", "/doc/debug"
        };
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(excludes);
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addExposedHeader("target-response-headers");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String frontRoot;
        if (StringUtils.hasText(frontLocation)) {
            frontRoot = StringUtils.trimTrailingCharacter(frontLocation, '/');
        } else {
            String homeDir = System.getProperty("user.dir");
            frontRoot = homeDir + "/dist";
        }
        log.info("前端资源目录：{}", frontRoot);
        String frontLocation = "file:" + frontRoot;
        registry.addResourceHandler("/index.html").addResourceLocations(frontLocation + "/index.html");
        registry.addResourceHandler("/favicon.ico").addResourceLocations(frontLocation + "/favicon.ico");
        registry.addResourceHandler("/static/**").addResourceLocations(frontLocation + "/static/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new HashIdParamResolver());
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .allowCredentials(true);
//    }



    /**
     * 使用fastjson代替jackson
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonConfigure(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(FastjsonUtil.SERIALIZER_FEATURES);
        // 日期格式化
        fastJsonConfig.setDateFormat(FastjsonUtil.DATE_FORMAT);
        converter.setFastJsonConfig(fastJsonConfig);
        return new HttpMessageConverters(converter);
    }


}
