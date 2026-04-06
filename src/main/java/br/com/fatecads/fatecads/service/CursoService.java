package br.com.fatecads.fatecads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecads.fatecads.entity.Curso;
import br.com.fatecads.fatecads.repository.CursoRepository;

@Service
public class CursoService {
    
    //Injeção de dependência do repositório de cursos
    @Autowired
    private CursoRepository cursoRepository;

    //Metodo para salvar um curso no banco de dados
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    //Metodo para listar todos os cursos do banco de dados
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    //metodo para excluir um curso do banco de dados
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }

    //Metodo para buscar um curso pelo id
    public Curso findById(Integer id) {
        return cursoRepository.findById(id).orElse(null);
    }
}
