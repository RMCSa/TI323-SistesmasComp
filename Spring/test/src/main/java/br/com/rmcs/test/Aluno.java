package br.com.rmcs.test;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Aluno {

    private String ra;
    private String nome;

    
}
