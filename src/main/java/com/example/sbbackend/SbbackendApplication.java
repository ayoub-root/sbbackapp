package com.example.sbbackend;

import com.example.sbbackend.dto.RegisterRequestDto;
import com.example.sbbackend.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.sbbackend.dto.Role.ADMIN;
import static com.example.sbbackend.dto.Role.MANAGER;

@SpringBootApplication
public class SbbackendApplication {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    public static void main(String[] args) {
        SpringApplication.run(SbbackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
     var tt=       RegisterRequestDto.builder()
                    .firstname("user")
                    .lastname("admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            service.register(tt);

    var ff=        RegisterRequestDto.builder()
                    .firstname("user")
                    .lastname("manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
    service.register(ff);



        };
    }
}
