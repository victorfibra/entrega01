package com.example.entrega01.service;

import com.example.entrega01.dto.ContratoResponseDTO;
import com.example.entrega01.model.Contrato;
import com.example.entrega01.model.StatusConsumo;
import com.example.entrega01.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("pjService")
public class TrafegoPJServiceImpl implements TrafegoService {

    @Autowired
    private ContratoRepository repository;

    @Override
    public List<ContratoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // ESTE É O MÉTODO QUE ESTÁ FALTANDO E CAUSANDO O ERRO:
    @Override
    public ContratoResponseDTO buscarPorId(Long id) {
        Contrato contrato = repository.findAll().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Contrato PJ não encontrado"));
        
        return converterParaDTO(contrato);
    }

    // Método auxiliar para manter a regra de negócio de PJ (900GB)
    private ContratoResponseDTO converterParaDTO(Contrato contrato) {
        StatusConsumo status = contrato.getTotalTrafegoGB() > 900 ? 
                               StatusConsumo.ALTO_CONSUMO : StatusConsumo.NORMAL;

        return new ContratoResponseDTO(
            contrato.getCliente(),
            contrato.getTotalTrafegoGB(),
            status
        );
    }
}