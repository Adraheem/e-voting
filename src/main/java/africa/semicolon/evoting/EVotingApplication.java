package africa.semicolon.evoting;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
@OpenAPIDefinition(
        info = @Info(
                title = "e-Voting API",
                description = "API documentation for e-voting application that allows users to vote for their " +
                        "respective candidates",
                version = "0.1.0"
        ),
        externalDocs = @ExternalDocumentation(
                url = "https://documenter.getpostman.com/view/15097759/2s93CPrCri",
                description = "Postman Documentation"
        )
)
public class EVotingApplication {

    public static void main(String[] args) {
        SpringApplication.run(EVotingApplication.class, args);
    }

}
