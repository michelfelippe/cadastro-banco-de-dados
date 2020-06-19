package br.edu.usj.ads.lpii.cadastrocliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroController {

    @Autowired
    CadastroRepository cadastroRepository;
    
    @GetMapping(value="/")
    public ModelAndView getListar() {
        // listar todas as bebibas
        List<Cadastro> lista = cadastroRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista",lista);
        return modelAndView;
    }
    
    @GetMapping(value="/mostrar/{id}")
    public ModelAndView getMostrar (@PathVariable Long id) {
        // mostrar bebida referente ao id

        Cadastro cadastro = cadastroRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("cadastro",cadastro);
        return modelAndView;
    }

    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        // retorna o formulário para o usuário preencher
        Cadastro cadastro = new Cadastro();
        
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("cadastro",cadastro);

        return modelAndView;
    }

    @PostMapping(value="/cadastrar")
    public ModelAndView postCadastrar(Cadastro cadastro){
        // recebe a bebida preenchida no formulário e mandar gravar no banco
        cadastroRepository.save(cadastro);
        
        ModelAndView modelAndView = new ModelAndView("mostrar");
        modelAndView.addObject("cadastro",cadastro);
                
        return modelAndView;
    }
    
    @GetMapping(value="/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable Long id) {
        // deleta bebiba referente ao id
        cadastroRepository.deleteById(id);

        List<Cadastro> lista = cadastroRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("lista",lista);
                
        return modelAndView;
        
    }
    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        
        Cadastro cadastro = cadastroRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("cadastro",cadastro);
                
        return modelAndView;
        
    }
}