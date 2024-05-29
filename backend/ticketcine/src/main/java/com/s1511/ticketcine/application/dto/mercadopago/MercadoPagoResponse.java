package com.s1511.ticketcine.application.dto.mercadopago;

public record MercadoPagoResponse(
        String action,
        Resource data,
        String Type
) {
}