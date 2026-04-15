package com.example.entrega01.controller;

import com.example.entrega01.dto.ContratoResponseDTO;
import com.example.entrega01.model.Contrato;
import com.example.entrega01.repository.ContratoRepository; // Import necessário
import com.example.entrega01.service.TrafegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus; // Import para o status 201
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trafego")
public class TrafegoController {

    @Autowired
    private ContratoRepository repository; // Injeção necessária para salvar e deletar

    @Autowired
    @Qualifier("pfService")
    private TrafegoService pfService;

    @Autowired
    @Qualifier("pjService")
    private TrafegoService pjService;

    @GetMapping("/pf")
    public List<ContratoResponseDTO> listarPF() {
        return pfService.listarTodos();
    }

    @GetMapping("/pj")
    public List<ContratoResponseDTO> listarPJ() {
        return pjService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoResponseDTO> buscar(@PathVariable Long id) {
        ContratoResponseDTO dto = pfService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    // AGORA FUNCIONAL: Salva de verdade na memória
    @PostMapping
    public ResponseEntity<Contrato> salvar(@RequestBody Contrato contrato) {
        repository.save(contrato); // Chama o repository para guardar o dado
        return ResponseEntity.status(HttpStatus.CREATED).body(contrato);
    }

    // AGORA FUNCIONAL: Deleta de verdade da memória
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        repository.delete(id); // Chama o repository para remover
        return ResponseEntity.noContent().build();
    }
    // Rota para Atualizar Tráfego (PUT): http://localhost:8080/trafego/mestreyoda192
    @PutMapping("/{login}")
    public ResponseEntity<Contrato> atualizar(@PathVariable String login, @RequestBody Double novoTrafego) {
        return repository.buscarPorLogin(login)
                .map(contrato -> {
                    contrato.setTotalTrafegoGB(novoTrafego);
                    return ResponseEntity.ok(contrato);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}