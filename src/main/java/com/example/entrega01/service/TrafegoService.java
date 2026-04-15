package com.example.entrega01.service;

import com.example.entrega01.dto.ContratoResponseDTO;
import com.example.entrega01.model.Contrato;
import java.util.List;

public interface TrafegoService {
    ContratoResponseDTO analisarContrato(Contrato contrato);
    List<ContratoResponseDTO> listarTodos();
}