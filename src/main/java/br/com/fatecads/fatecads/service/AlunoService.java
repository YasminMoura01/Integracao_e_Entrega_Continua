package br.com.fatecads.fatecads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecads.fatecads.entity.Aluno;
import br.com.fatecads.fatecads.repository.AlunoRepository;

@Service
public class AlunoService {
    
    //Injeção de dependência do repositório de alunos
    @Autowired
    private AlunoRepository alunoRepository;

    //Metodo para salvar um aluno no banco de dados
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    //Metodo para listar todos os alunos do banco de dados
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    //metodo para excluir um aluno do banco de dados
    public void deleteById(Integer id) {
        alunoRepository.deleteById(id);
    }

    //Metodo para buscar um aluno pelo id
    public Aluno findById(Integer id) {
        return alunoRepository.findById(id).orElse(null);
    }
}
