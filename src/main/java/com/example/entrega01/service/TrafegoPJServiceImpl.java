package com.example.entrega01.service;

import com.example.entrega01.dto.ContratoResponseDTO;
import com.example.entrega01.model.Contrato;
import com.example.entrega01.model.StatusConsumo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("pjService") // Isso avisa ao Spring que esta classe é um componente de serviço [cite: 395]
public class TrafegoPJServiceImpl implements TrafegoService {

    // Lista simulada em memória (Requisito 5 da atividade) [cite: 1131]
    private List<Contrato> bancoEmMemoria = new ArrayList<>();

    public TrafegoPJServiceImpl() {
        // Simulando alguns dados do seu SGP
        bancoEmMemoria.add(new Contrato(1L, "Maria Clara", "mariaclara123", 554.2));
        bancoEmMemoria.add(new Contrato(2L, "Josimar Silva", "josimar031", 351.5));
        bancoEmMemoria.add(new Contrato(3L, "Carlos Victor", "victor_fibra", 8.5)); // Exemplo baixo consumo
    }

    @Override
    public ContratoResponseDTO analisarContrato(Contrato contrato) {
        StatusConsumo status;
        
        // Sua regra de negócio condicional (Requisito 2 da atividade) [cite: 1111]
        if (contrato.getTotalTrafegoGB() < 50.0) {
            status = StatusConsumo.BAIXO_CONSUMO; // Possível ONU/Roteador travado
        } else if (contrato.getTotalTrafegoGB() > 900.0) {
            status = StatusConsumo.ALTO_CONSUMO; // Heavy User
        } else {
            status = StatusConsumo.NORMAL;
        }

        return new ContratoResponseDTO(
            //contrato.getId(),
            contrato.getCliente(), 
            //contrato.getLogin(), 
            contrato.getTotalTrafegoGB(), 
            status
        );
    }

    @Override
    public List<ContratoResponseDTO> listarTodos() {
        return bancoEmMemoria.stream()
                .map(this::analisarContrato)
                .collect(Collectors.toList());
    }
}