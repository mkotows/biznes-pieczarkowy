package pl.coderslab.pieczarki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EntityScan("pl.coderslab.pieczarki.model")
//@EnableJpaRepositories("pl.coderslab.pieczarki.repository")
public class PieczarkiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PieczarkiApplication.class, args);


    }

}
