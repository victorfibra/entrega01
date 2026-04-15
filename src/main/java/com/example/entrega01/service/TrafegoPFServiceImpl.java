package com.example.entrega01.service;

import com.example.entrega01.dto.ContratoResponseDTO;
import com.example.entrega01.model.Contrato;
import com.example.entrega01.model.StatusConsumo;
import com.example.entrega01.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service("pfService")
public class TrafegoPFServiceImpl implements TrafegoService {

    @Autowired
    private ContratoRepository repository;

    @Override
    public List<ContratoResponseDTO> listarTodos() {
        return repository.findAll().stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    @Override
    public ContratoResponseDTO buscarPorId(Long id) {
        // Busca no repository e se não achar lança o erro que o Jean mostrou
        Contrato contrato = repository.findAll().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                //.orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrato não encontrado na Arco Net"));
        
        return converterParaDTO(contrato);
    }

    // Método auxiliar para não repetir código
    private ContratoResponseDTO converterParaDTO(Contrato contrato) {
        StatusConsumo status = contrato.getTotalTrafegoGB() > 500 ? 
                               StatusConsumo.ALTO_CONSUMO : StatusConsumo.NORMAL;
        if (contrato.getTotalTrafegoGB() < 50) status = StatusConsumo.BAIXO_CONSUMO;

        return new ContratoResponseDTO(contrato.getCliente(), contrato.getTotalTrafegoGB(), status);
    }
}