package com.example.entrega01.model;

public class Contrato {
    private Long id;
    private String cliente;
    private String login;
    private Double totalTrafegoGB;

    // 1. CONSTRUTOR COMPLETO (Resolve o erro no Entrega01Application)
    public Contrato(Long id, String cliente, String login, Double totalTrafegoGB) {
        this.id = id;
        this.cliente = cliente;
        this.login = login;
        this.totalTrafegoGB = totalTrafegoGB;
    }

    // 2. CONSTRUTOR VAZIO (Boa prática para frameworks)
    public Contrato() {
    }

    // 3. GETTERS
    public Long getId() { return id; }
    public String getCliente() { return cliente; }
    public String getLogin() { return login; }
    public Double getTotalTrafegoGB() { return totalTrafegoGB; }

    // 4. SETTERS (Resolve o erro undefined no Controller)
    public void setId(Long id) { this.id = id; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public void setLogin(String login) { this.login = login; }
    
    public void setTotalTrafegoGB(Double totalTrafegoGB) {
        this.totalTrafegoGB = totalTrafegoGB;
    }
}