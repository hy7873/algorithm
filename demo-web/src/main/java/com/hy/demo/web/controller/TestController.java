package com.hy.demo.web.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(description = "测试")
@Controller
@RequestMapping("/v1/api/test")
public class TestController {

	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);


	@RequestMapping(value = "test1",method = RequestMethod.POST)
	public void test1() {
		System.out.println("test1");
	}


}
