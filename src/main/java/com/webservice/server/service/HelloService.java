package com.webservice.server.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://webservice.cxf.demo.com/", name = "HelloService")
public interface HelloService {

	@WebMethod
	String sayHello(@WebParam(name = "request") String request);
}
