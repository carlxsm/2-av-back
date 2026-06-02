package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAlunoPorId(long id) {
        alunoRepository.deleteById(id);
    }

    public void atualizarAlunoPorId(Long id, Aluno alunoAtualizado) {

        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

        if (alunoDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados!");
        }

        Aluno alunoParaEditar = alunoDoBancoDeDados.get();


        alunoParaEditar.setNomeCompleto(alunoAtualizado.getNomeCompleto());
        alunoParaEditar.setEmail(alunoAtualizado.getEmail());
        alunoParaEditar.setCpf(alunoAtualizado.getCpf());

        alunoRepository.save(alunoParaEditar);
    }
}
