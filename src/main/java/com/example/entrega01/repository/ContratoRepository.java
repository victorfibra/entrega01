package com.example.entrega01.repository;

import com.example.entrega01.model.Contrato;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContratoRepository {
    private static List<Contrato> contratos = new ArrayList<>();

    public List<Contrato> findAll() {
        return contratos;
    }

    public void save(Contrato contrato) {
        contratos.add(contrato);
    }

    // REQUISITO 5.a: Método de busca customizado
    public Optional<Contrato> buscarPorLogin(String login) {
        return contratos.stream()
                .filter(c -> c.getLogin().equalsIgnoreCase(login))
                .findFirst();
    }

    public void delete(Long id) {
        contratos.removeIf(c -> c.getId().equals(id));
    }
}