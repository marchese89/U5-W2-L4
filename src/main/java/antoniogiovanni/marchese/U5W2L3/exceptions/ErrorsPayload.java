package antoniogiovanni.marchese.U5W2L3.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorsPayload { // Questa classe rappresenta il body delle risposte di errore
    private String message;
    private LocalDateTime timestamp;
}
