package com.less.core.mvcconfigurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {
//	@Value("${server.port:8088}")
//	private int port;

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor());
    }

//	/**
//	 * 定制嵌入式servlet规则，等于配置改server.port
//	 */
//	@Bean
//	public WebServerFactoryCustomizer<ConfigurableTomcatWebServerFactory> webServerFactoryCustomizer() {
//		return factory -> factory.setPort(port);
//	}


}
