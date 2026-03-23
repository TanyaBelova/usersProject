package user.service;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class UsersApplication {

    public static void main(String[] args) {

        var configurableApplicationContext = SpringApplication.run(UsersApplication.class, args);

        Flyway.configure()
                .dataSource(configurableApplicationContext.getBean(DataSource.class))
                .load()
                .migrate();
    }

}
