package com.example.entrega01.model;

public enum StatusConsumo {
    BAIXO_CONSUMO,    // Alerta: ONU/Roteador pode estar travado
    NORMAL,           // Tráfego dentro da média
    ALTO_CONSUMO      // Heavy User: verificar uso excessivo
}