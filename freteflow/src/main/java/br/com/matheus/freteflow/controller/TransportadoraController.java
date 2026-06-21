package br.com.matheus.freteflow.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.matheus.freteflow.entity.Transportadora;
import br.com.matheus.freteflow.service.TransportadoraService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transportadoras")
@RequiredArgsConstructor
public class TransportadoraController {

    private final TransportadoraService service;

    @GetMapping
    public List<Transportadora> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transportadora> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Transportadora criar(@RequestBody Transportadora transportadora) {
        return service.salvar(transportadora);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}