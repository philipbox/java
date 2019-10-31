package edu.ssafy.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.groupName("Product")
		.apiInfo(info())
		.select()
		.apis(RequestHandlerSelectors.basePackage("edu.ssafy.boot.controller"))
		.paths(PathSelectors.ant("/api/**"))
		.build();
	}
	
	public ApiInfo info() {
		return new ApiInfoBuilder()
				.title("Product Management API")
				.license("SSAFY에서 오늘은 boot를 배웠어용.")
				.version("1같은 0.9랍니다.")
				.build();
	}
}
