package com.webservice.server.service.impl;

import com.webservice.server.service.HelloService;
import javax.jws.WebService;
import org.springframework.stereotype.Component;

@Component("helloServiceImpl")
@WebService(targetNamespace = "http://webservice.cxf.demo.com/")
public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String request) {
		return "Hello Word";
	}
}
