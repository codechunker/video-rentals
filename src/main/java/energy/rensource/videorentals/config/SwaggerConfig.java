package energy.rensource.videorentals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/videos/*"))
                .apis(RequestHandlerSelectors.basePackage("energy.rensource"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Rensource Video Rentals",
                "Video Rental Application",
                "1.0",
                "Just for Assessment",
                new Contact("Chunks", "codechunkers.medium.com", "codechunkers@gmail.com"),
                "API License",
                "https://codechunkers.medium.com",
                Collections.emptyList()

        );
    }
}
