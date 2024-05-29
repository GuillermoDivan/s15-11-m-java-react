package com.s1511.Ticketcine.application.dto.mercadopago;

public record MercadoPagoResponse(
        String action, //Aquí reporta creación/procesamiento/cancelación del pago.
        Resource data //Información del pago.
) {
}