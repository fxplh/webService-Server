package com.webservice.server;

import com.webservice.server.service.HelloService;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

	@Bean
	public ServletRegistrationBean cxfServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/cxf/*");// 发布服务名称
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	@Qualifier("helloServiceImpl")
	public Endpoint org(@Qualifier("helloServiceImpl") HelloService helloService) {
		EndpointImpl endpoint = new EndpointImpl(springBus(), helloService);// 绑定要发布的服务
		endpoint.publish("/helloService"); // 显示要发布的名称
		return endpoint;
	}
}
