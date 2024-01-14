package com.leonardokazu.crudbasico.entities.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull
                      @NotBlank
                      String email,
                      @NotNull
                      @NotBlank
                      String password,
                      @NotNull
                      @NotBlank
                      String name,
                      @NotNull
                      @NotBlank
                      String phone) {
}
