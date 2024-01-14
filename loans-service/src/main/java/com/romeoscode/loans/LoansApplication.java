package com.romeoscode.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = "Romeos-code Loans microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Romeo Jerenyama",
                        email = "romeojerenyama@gmail.com"
                ),
                license = @License(
                        name = "Romeos-code 2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Romeos-code Loans microservice REST API Documentation",
                url = "http://locahost:8082/swagger-ui/index.html"
        )
)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
