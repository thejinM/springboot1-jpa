package com.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Services.exceptions.ExceptionRecursoNaoEncontrado;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionManipuladorRecurso 
{
  @ExceptionHandler(ExceptionRecursoNaoEncontrado.class)
  public ResponseEntity<ExceptionErroPadrao> recursoNaoEncontrado(ExceptionRecursoNaoEncontrado e, HttpServletRequest request)
  {
    String erro = "Recurso não encontrado!";
    HttpStatus status = HttpStatus.NOT_FOUND;
    ExceptionErroPadrao erroPadrao = new ExceptionErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(status).body(erroPadrao);
  }
}