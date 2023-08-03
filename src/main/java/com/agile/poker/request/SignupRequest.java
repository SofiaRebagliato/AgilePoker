package com.agile.poker.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;
}
