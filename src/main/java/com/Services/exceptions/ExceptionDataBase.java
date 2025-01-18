package com.Services.exceptions;

public class ExceptionDataBase extends RuntimeException 
{
  private static final long serialVersionUID = 1L;

  public ExceptionDataBase(String msg)
  {
    super(msg);
  }
}