package br.edu.usj.ads.lpii.cadastrocliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nome;
    Integer idade;
    String email;
    String senha;
    
}