package br.com.fatecads.fatecads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fatecads.fatecads.service.AlunoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import br.com.fatecads.fatecads.entity.Aluno;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;


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
        return "aluno/listarAlunos";
    }

    //metodo para criar um novo aluno e abrir formulario
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/formularioAluno";
    }
    
    //metodo para excluir um aluno do banco de dados
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        alunoService.deleteById(id);
        return "redirect:/alunos/listar";
    }

    //metodo para editar um aluno do banco de dados
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        return "aluno/formularioAluno"; 
    }
}