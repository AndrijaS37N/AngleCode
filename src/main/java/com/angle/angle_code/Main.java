package com.angle.angle_code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final static Logger bootLogger = LoggerFactory.getLogger(MainController.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run (String... args) {
        bootLogger.info("Overridden run function from SpringApplication is starting\n\n\t| Program start successful. |\n");
    }
}
