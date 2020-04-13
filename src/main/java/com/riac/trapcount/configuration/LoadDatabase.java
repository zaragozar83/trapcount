package com.riac.trapcount.configuration;

import com.riac.trapcount.repository.RanchRepository;
import com.riac.trapcount.repository.model.RanchEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Log4j2
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init(RanchRepository repository) {
        return args -> Flux.just(
                RanchEntity.builder()
                        .name("Ranch 1")
                        .build(),
                RanchEntity.builder()
                        .name("Ranch 2")
                        .build(),
                RanchEntity.builder()
                        .name("Ranch 3")
                        .build())
                .flatMap(repository::save)
                .subscribe(log::debug);
    }
}
