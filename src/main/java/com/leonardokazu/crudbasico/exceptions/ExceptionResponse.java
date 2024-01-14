package com.leonardokazu.crudbasico.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {

    private Date timestamp;
    private String message;
    private String details;
}
