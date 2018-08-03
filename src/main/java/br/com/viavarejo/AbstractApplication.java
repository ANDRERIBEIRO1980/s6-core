package br.com.viavarejo;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.viavarejo.web.filter.CorrelationFilter;
import br.com.viavarejo.web.interceptor.CorrelationInterceptor;

@Configuration
@SpringBootApplication(scanBasePackages = {"br.com.viavarejo"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public abstract class AbstractApplication extends WebMvcConfigurerAdapter {

    @Autowired
    protected CorrelationInterceptor correlationInterceptor;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public FilterRegistrationBean correlationHeaderFilter() {
        final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();

        filterRegBean.setFilter(new CorrelationFilter());

        filterRegBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegBean;
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addExposedHeader("x-correlation-id");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PATCH");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    public static void main(final String[] args) {
        SpringApplication.run(AbstractApplication.class, args);
    }
}
