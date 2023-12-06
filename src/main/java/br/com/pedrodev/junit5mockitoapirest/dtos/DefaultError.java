package br.com.pedrodev.junit5mockitoapirest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefaultError {
    private Integer code;
    private String message;
    private LocalDateTime time;
}
