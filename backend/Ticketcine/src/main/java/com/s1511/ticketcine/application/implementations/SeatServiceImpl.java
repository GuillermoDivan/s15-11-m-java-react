package com.s1511.ticketcine.application.implementations;

import com.s1511.ticketcine.application.dto.seat.RequestSeatDto;
import com.s1511.ticketcine.application.dto.seat.ResponseSeatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.s1511.ticketcine.application.mapper.SeatMapper;
import com.s1511.ticketcine.domain.entities.Seat;
import com.s1511.ticketcine.domain.repository.SeatRepository;
import com.s1511.ticketcine.domain.services.SeatService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {/*

    private final SeatRepository seatRepository;
    private final SeatMapper seatMapper;

    public List<ResponseSeatDto> findAllSeats() { return null;
       /* List<Seat> seats = seatRepository.findAll();
        return seats.stream()
                .map(seatMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ResponseSeatDto findSeatById(Long id) { return null; /*
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        return seatMapper.toDTO(seat);
    }

    @Transactional
    public Optional<Seat> seatReservation(Long id, RequestSeatDto seatReservationDTO) {
        return null; /*
        Optional<Seat> seatOptional = seatRepository.findById(id);

        if (!seatOptional.isPresent()) {
            return Optional.empty(); // Asiento no encontrado
        }

        Seat seat = seatOptional.get();
        if (seat.isReserved()) {
            return Optional.empty(); // Asiento ya reservado
        }

        seat.setReserved(seatReservationDTO.reserved());
        seatRepository.save(seat);
        return Optional.of(seat); // Asiento reservado exitosamente
    }

*/
}
