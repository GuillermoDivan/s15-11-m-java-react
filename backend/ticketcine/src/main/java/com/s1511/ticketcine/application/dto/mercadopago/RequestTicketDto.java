package com.s1511.ticketcine.application.dto.mercadopago;
import java.util.List;

public record RequestTicketDto(
        String userId,
        String cinemaName,
        String screenId,
        String movieName,
        List<String> seatsNames,
        Integer amountOfSeats,
        Double unitPrice //Harcodeado desde front. Realista sería una nueva lista en db que
        // tiene que pasar de back a front y viceversa.
) {
}
