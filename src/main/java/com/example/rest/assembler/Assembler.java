package com.example.rest.assembler;

public interface Assembler<T, R> {
    R assemble(T source);
}
