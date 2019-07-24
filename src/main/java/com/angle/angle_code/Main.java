package com.angle.angle_code;

import com.angle.angle_code.entities.AngleEntity;
import com.angle.angle_code.repositories.AngleEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public final static Logger bootLogger = LoggerFactory.getLogger(MainController.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private AngleEntityRepository angleEntityRepository;

    @Override
    public void run (String... args) {
        bootLogger.info("BOOT LOG POINT: overridden run function from SpringApplication is starting\n| Program start. |");
        angleEntityRepository.save(new AngleEntity("Milley"));
        angleEntityRepository.save(new AngleEntity("Rupert"));

        AngleEntity a1 = new AngleEntity("Keyush");
        System.out.println("Key object made.");

        bootLogger.info("BOOT LOG POINT: save(new AngleEntity(\"RUPERT + MILLEY\") done");
        angleEntityRepository.findAll().forEach(x -> System.out.println(x));
    }
}
