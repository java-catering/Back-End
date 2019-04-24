package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig
{
    private ApiInfo metaInfo = new ApiInfo(
            "Catering API",
            "API Documentation for the Catering API",
            "1.0",
            "Terms of Service",
            "Eric",
            "Apache License Version 2.0",
            "https://apache.org/licenses/LICENSE-2.0");

    @Bean
    public Docket userAPI()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("app.api.v1.controllers"))
                .build()
                .apiInfo(metaInfo);
    }
}
