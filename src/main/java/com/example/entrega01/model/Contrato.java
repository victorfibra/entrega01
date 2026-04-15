package com.example.entrega01.model;

public class Contrato {
    private Long id;
    private String cliente;
    private String login;
    private Double totalTrafegoGB; // Mudamos de Consumo para Trafego (sem acento)

    // Construtor padrão
    public Contrato() {}

    // Construtor completo
    public Contrato(Long id, String cliente, String login, Double totalTrafegoGB) {
        this.id = id;
        this.cliente = cliente;
        this.login = login;
        this.totalTrafegoGB = totalTrafegoGB;
    }

    // Getters - Essenciais para o Spring "enxergar" os dados
    public Long getId() { return id; } // ADICIONE ESTA LINHA
    public String getCliente() { return cliente; }
    public String getLogin() { return login; }
    public Double getTotalTrafegoGB() { return totalTrafegoGB; }
}