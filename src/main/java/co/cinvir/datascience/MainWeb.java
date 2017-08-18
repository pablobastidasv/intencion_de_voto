package co.cinvir.datascience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.cinvir.datascience")
public class MainWeb {
    
    public static void main(String[] args) {
        SpringApplication.run(MainWeb.class, args);
    }
}
