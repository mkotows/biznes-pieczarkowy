package pl.coderslab.pieczarki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PieczarkiApplication {


//    public void addFormatters(FormatterRegistry registry) {
//        registry.addConverter(getTaskConverter());
//    }
//
//    @Bean
//    public TaskConverter getTaskConverter() {
//        return new TaskConverter();
//    }


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(PieczarkiApplication.class, args);


        }


}
