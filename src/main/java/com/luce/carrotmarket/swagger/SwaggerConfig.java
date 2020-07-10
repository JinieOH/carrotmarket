package com.luce.carrotmarket.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private String version;
    private String title;

    @Bean
    public Docket api() {
        version = "v1.0";
        title = "당근마켓 API " + version;

        List<ResponseMessage> responseMessages = new ArrayList<>();
        responseMessages.add(new ResponseMessageBuilder()
                .code(200)
                .message("Connection OK !!")
                .build()
        );

        responseMessages.add(new ResponseMessageBuilder()
                .code(404)
                .message("Not Found !!")
                .build()
        );

        responseMessages.add(new ResponseMessageBuilder()
                .code(500)
                .message("Internal Server Error !!")
                .build()
        );

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.luce.carrotmarket.web"))
                .paths(PathSelectors.ant("/api/order/**"))
                .build()
                .apiInfo(apiInfo(title, version))
                .globalResponseMessage(RequestMethod.GET, responseMessages);
    }

    /*
    @Bean
    public Docket apiV1() {
        version = "v1.0";
        title = "당근 API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.luce.danngn.swagger.api.v1"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfo(title, version));
    }

    @Bean
    public Docket apiV2() {
        version = "v2.0";
        title = "당근 API " + version;

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.luce.danngn.swagger.api.v2"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfo(title, version));
    }
    */

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfo(
                title, "Swagger로 생성한 당근마켓 AP Docs",
                version, null, null, null, null,
                new ArrayList<>());
    }

}
