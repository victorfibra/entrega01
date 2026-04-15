package com.example.entrega01.controller;

import com.example.entrega01.dto.ContratoResponseDTO;
import com.example.entrega01.service.TrafegoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trafego")
public class TrafegoController {

    // Injeção da implementação de Pessoa Física
    @Autowired
    @Qualifier("pfService")
    private TrafegoService pfService;

    // Injeção da implementação de Pessoa Jurídica
    @Autowired
    @Qualifier("pjService")
    private TrafegoService pjService;

    // Rota para testar o POST com Validação (@Valid)
    @PostMapping
    public ResponseEntity<ContratoResponseDTO> criar(@Valid @RequestBody ContratoResponseDTO dto) {
        // Retorna o próprio DTO para confirmar que a validação passou
        return ResponseEntity.ok(dto);
    }

    // Rota: http://localhost:8080/trafego/pf
    @GetMapping("/pf")
    public List<ContratoResponseDTO> getPF() {
        return pfService.listarTodos();
    }

    // Rota: http://localhost:8080/trafego/pj
    @GetMapping("/pj")
    public List<ContratoResponseDTO> getPJ() {
        return pjService.listarTodos();
    }
}