package br.com.matheus.freteflow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.matheus.freteflow.entity.Transportadora;
import br.com.matheus.freteflow.repository.TransportadoraRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportadoraService {

    private final TransportadoraRepository repository;

    public List<Transportadora> listarTodas() {
        return repository.findAll();
    }

    public Optional<Transportadora> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Transportadora salvar(Transportadora transportadora) {
        return repository.save(transportadora);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}