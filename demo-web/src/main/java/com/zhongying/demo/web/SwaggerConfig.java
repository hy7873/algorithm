package com.zhongying.demo.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author:chenhao
 * @date:2017/08/04 18:14:56
 * @description:
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

	@Bean
	public Docket api() {
		// 过滤生成链接
		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.regex("/*/.*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("中赢", "", "zy@zhongyinjinrong.com");
		ApiInfo apiInfo = new ApiInfoBuilder().license("").title("  接口").description("demo").contact(contact).version("1.0").build();

		return apiInfo;
	}

}
