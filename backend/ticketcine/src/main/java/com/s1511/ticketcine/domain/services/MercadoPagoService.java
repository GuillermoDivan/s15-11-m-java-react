package com.s1511.ticketcine.domain.services;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.s1511.ticketcine.application.dto.mercadopago.MercadoPagoResponse;
import com.s1511.ticketcine.application.dto.mercadopago.RequestTicketDto;

public interface MercadoPagoService {
        String createPayment (RequestTicketDto requestTicketDto) throws MPException, MPApiException;
        void processPayment (MercadoPagoResponse mercadoPagoResponse) throws MPException, MPApiException;
}
