package com.example.entrega01.service;

import com.example.entrega01.dto.ContratoResponseDTO;
import java.util.List;

public interface TrafegoService {
    List<ContratoResponseDTO> listarTodos();
    // NOVO MÉTODO:
    ContratoResponseDTO buscarPorId(Long id);
}