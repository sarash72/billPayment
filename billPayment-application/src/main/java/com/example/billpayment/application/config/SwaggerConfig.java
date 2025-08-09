package com.example.billpayment.application.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {


//    @Bean
//    public Docket billApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.billpayment.controller"))
//                .paths(regex("/test.*"))
//                .build();}

        @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("پروژه پرداخت قیوض")
                        .version("1.0.0")
                        .description("این مستندات API پروژه است"));
    }

    @Bean
    public GroupedOpenApi customGroupedOpenApi() {
            return GroupedOpenApi.builder().group("billpayment")
                    .pathsToMatch("/billPayment/**")
                    .packagesToScan("com.example.billpayment.controller")
                    .build();
    }
}
