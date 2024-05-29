package com.s1511.ticketcine.application.implementations;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.s1511.ticketcine.application.dto.mercadopago.RequestTicketDto;
import com.s1511.ticketcine.domain.entities.*;
import com.s1511.ticketcine.domain.repository.*;
import com.s1511.ticketcine.domain.services.TicketService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    public final TicketRepository ticketRepository;
    public final UserRepository userRepository;
    public final CinemaRepository cinemaRepository;
    public final ScreenRepository screenRepository;
    public final MovieRepository movieRepository;
    public final SeatRepository seatRepository;

    public String createTicket(RequestTicketDto requestDto){
        User user = userRepository.findByIdAndActive(requestDto.userId(), true)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se puede encontrar el usuario con el id " + requestDto.userId()));

        Screen screen = screenRepository.findByNameAndActive(requestDto.screenName(), true)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se puede encontrar la sala con el nombre " + requestDto.screenName()));

        Cinema cinema = cinemaRepository.findByNameAndActive(requestDto.cinemaName(), true)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se puede encontrar el cine con el nombre " + requestDto.cinemaName()));

        Movie movie = movieRepository.findByTitleAndActive(requestDto.movieName(), true)
                .orElseThrow(() -> new EntityNotFoundException(
                        "No se puede encontrar la película con el nombre " + requestDto.movieName()));

        List<Seat> seatEntityList = new ArrayList<>();
        List<String> seatsList = requestDto.seatsNames();
        for (String seatNumber : seatsList) {
            Seat seat = seatRepository.findBySeatNumberAndReserved(seatNumber, false)
                    .orElseThrow(() -> new EntityNotFoundException(
                            "El asiento " + seatNumber + " no se encuentra disponible."));
            seatEntityList.add(seat);
        }

        Double value = calculateTicketPrice(requestDto.unitPrice(), requestDto.amountOfSeats());

        LocalDateTime functionDate = LocalDateTime.now(); // Reemplazar por function Date real cuando esté.

        Ticket ticket = new Ticket();
        ticket.setUserId(user.getId());
        ticket.setCinemaName(cinema.getName());
        ticket.setScreenName(screen.getName());
        ticket.setSeatsNames(seatEntityList);
        ticket.setMovieName(movie.getTitle());
        ticket.setValue(value);
        ticket.setFunctionDate(functionDate);
        ticket.setActive(false);

        Ticket savedTicket = ticketRepository.save(ticket);
        return savedTicket.getId();
    }

    @Override
    public List<Ticket> getAllTicketsByUserIdAndActive(String userId, Boolean active) {
        List<Ticket> ticketList = ticketRepository.getTicketsByUserIdAndActive(userId, true);
        return null;
    }



    private double calculateTicketPrice(double unitPrice, int unitValue){
        return unitPrice * unitValue;
    }
}


