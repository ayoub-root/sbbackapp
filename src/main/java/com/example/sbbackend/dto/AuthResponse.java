package com.example.sbbackend.dto;

import lombok.*;
import org.springframework.http.HttpHeaders;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AuthResponse {

    HttpHeaders headers;


}
