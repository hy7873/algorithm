package com.zhongying.demo.web.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(description = "测试")
@Controller
@RequestMapping("/v1/api/test")
public class TestController {

	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);




}
