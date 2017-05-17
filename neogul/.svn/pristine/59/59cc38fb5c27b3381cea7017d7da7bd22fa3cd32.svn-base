package com.joheul.conf;

import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import com.joheul.websocket.logs.DefaultLogService;
import com.joheul.websocket.logs.LogWebSocketHandler;
import com.joheul.websocket.policy.PolicyWebSocketHandler;
import com.joheul.websocket.video.VideoWebSocketHandler;


@Configuration
//@EnableWebMvc
@EnableWebSocket

public class WebConfig extends SpringBootServletInitializer implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(logWebSocketHandler(), "/log").setAllowedOrigins("*");
		registry.addHandler(policyWebSocketHandler(), "/policy", "/echo").setAllowedOrigins("*");
		registry.addHandler(videoWebSocketHandler(), "/video").setAllowedOrigins("*");
	}
	
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebConfig.class);
	}
*/

	/**
     * 웹소켓 버퍼 사이즈 설정
     * 기본 설정은 text, binary 버퍼 크기가 8192 byte 이다
     * @return
     */

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer(){
        
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        
        container.setMaxBinaryMessageBufferSize(8*1024*1024);
        container.setMaxTextMessageBufferSize(2*1024*1024);
        
        return container;
    }



	@Bean
	public WebSocketHandler logWebSocketHandler() {
		return new LogWebSocketHandler(logService());
	}

	@Bean
	public WebSocketHandler policyWebSocketHandler() {
		return new PerConnectionWebSocketHandler(PolicyWebSocketHandler.class);
	}
	
	@Bean
	public WebSocketHandler videoWebSocketHandler() {
		return new VideoWebSocketHandler();
	}

	@Bean
	public DefaultLogService logService() {
		return new DefaultLogService("Did you send \"%s\"?");
	}

	

/*	// Allow serving HTML files through the default Servlet

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
*/
	
}
