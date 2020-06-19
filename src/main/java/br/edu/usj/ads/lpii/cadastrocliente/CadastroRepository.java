package br.edu.usj.ads.lpii.cadastrocliente;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CadastroRepository extends CrudRepository <Cadastro, Long> {
    List<Cadastro> findAll();
}