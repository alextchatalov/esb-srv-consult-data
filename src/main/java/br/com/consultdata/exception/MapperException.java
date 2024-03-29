package br.com.consultdata.exception;

import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@FieldNameConstants
public class MapperException extends RuntimeException{

    public MapperException(final String errorMessage) {
        super(errorMessage);
    }
}
