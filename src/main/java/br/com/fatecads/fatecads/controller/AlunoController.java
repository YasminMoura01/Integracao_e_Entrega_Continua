package br.com.fatecads.fatecads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecads.fatecads.service.AlunoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import br.com.fatecads.fatecads.entity.Aluno;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    //injeção de dependência do serviço de alunos
    @Autowired
    private AlunoService alunoService;

    //metodo para salvar um aluno no banco de dados
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/alunos/listar";
    }
    
    //metodo para listar todos os alunos do banco de dados
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("alunos", alunoService.findAll());
        return "alunos/listarAlunos";
    }
}
