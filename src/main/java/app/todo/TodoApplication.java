package app.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//My spring boot starter class, this class will start the springboot context and look for all configurations and convensions.
@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) {

        SpringApplication.run(TodoApplication.class, args);
    }

}
