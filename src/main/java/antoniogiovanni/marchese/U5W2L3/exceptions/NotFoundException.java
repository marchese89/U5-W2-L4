package antoniogiovanni.marchese.U5W2L3.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(UUID id){
        super("Elemento con id "+id+ " non trovato!");
    }
}
