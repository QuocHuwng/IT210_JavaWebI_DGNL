package org.dgnl.config;

import org.dgnl.Entity.Artifact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.dgnl.repository.ArtifactRepository;

import java.time.LocalDate;

@Configuration
public class DataSeeder {

    @Bean
    public org.springframework.boot.CommandLineRunner init(ArtifactRepository repository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                repository.save(new Artifact(null,
                        "Artifact " + i,
                        "VIETNAM",
                        LocalDate.now()));
            }
        };
    }
}