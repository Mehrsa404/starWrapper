package ir.mohaymen.starwrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "ir.mohaymen.starwrapper.client")
public class StarWrapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarWrapperApplication.class, args);
    }

}
