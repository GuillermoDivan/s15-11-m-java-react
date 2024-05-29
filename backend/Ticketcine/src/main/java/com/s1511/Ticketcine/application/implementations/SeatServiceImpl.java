package com.s1511.Ticketcine.application.implementations;

import com.s1511.Ticketcine.application.dto.Seat.SeatDTO;
import com.s1511.Ticketcine.application.dto.Seat.SeatReservationDTO;
import com.s1511.Ticketcine.application.mapper.SeatMapper;
import com.s1511.Ticketcine.domain.entities.Seat;
import com.s1511.Ticketcine.domain.repository.SeatRepository;
import com.s1511.Ticketcine.domain.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    private final SeatMapper seatMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SeatDTO> findAllSeats() {
        List<Seat> seats = seatRepository.findAll();
        return seats.stream()
                .map(seatMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public SeatDTO findSeatById(Long id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        return seatMapper.toDTO(seat);
    }

    @Override
    @Transactional
    public Optional<Seat> seatReservation(Long id, SeatReservationDTO seatReservationDTO) {
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


}
