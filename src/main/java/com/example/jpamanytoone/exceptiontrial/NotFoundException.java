package com.example.jpamanytoone.exceptiontrial;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(String message)
    {
        super(message);
    }
}
