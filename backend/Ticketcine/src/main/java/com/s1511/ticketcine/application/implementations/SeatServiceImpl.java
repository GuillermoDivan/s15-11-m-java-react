package com.s1511.ticketcine.application.implementations;

import com.s1511.ticketcine.application.dto.seat.SeatReleaseRequestDTO;
import com.s1511.ticketcine.domain.entities.User;
import com.s1511.ticketcine.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.application.dto.seat.SeatReservationDTO;
import com.s1511.ticketcine.application.mapper.SeatMapper;
import com.s1511.ticketcine.domain.entities.Seat;
import com.s1511.ticketcine.domain.repository.SeatRepository;
import com.s1511.ticketcine.domain.services.SeatService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final UserRepository userRepository;
    private final SeatMapper seatMapper;
    private static final Logger logger = LoggerFactory.getLogger(SeatServiceImpl.class);

    @Override
    public List<SeatDTO> findAllSeats() {
        List<Seat> seats = seatRepository.findAll();
        return seats.stream()
                .map(seatMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeatDTO findSeatById(String id) {
        Seat seat = seatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
        return seatMapper.toDTO(seat);
    }

    @Override
    public List<SeatDTO> findReservedSeatsByUserId(String userId) {
        List<Seat.Availability> availabilities = Arrays.asList(Seat.Availability.OCCUPIED, Seat.Availability.RESERVED);
        List<Seat> reservedSeats = seatRepository.findByCurrentUser_IdAndAvailability(userId, availabilities);
        return reservedSeats.stream()
                .map(seatMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<Seat> seatReservation(String id, SeatReservationDTO seatReservationDTO) {
        Optional<Seat> seatOptional = seatRepository.findById(id);

        if (!seatOptional.isPresent()) {
            return Optional.empty(); // Asiento no encontrado
        }

        Seat seat = seatOptional.get();
        if (seat.getAvailability() != Seat.Availability.AVAILABLE) {
            return Optional.empty(); // Asiento no disponible para reservar
        }

        Optional<User> userOptional = userRepository.findById(seatReservationDTO.userId());

        if (!userOptional.isPresent()) {
            return Optional.empty(); // Usuario no encontrado o no activo
        }

        User user = userOptional.get();
        seat.setCurrentUser(user);
        seat.setAvailability(Seat.Availability.OCCUPIED); // Actualizar a OCCUPIED al reservar
        seatRepository.save(seat);
        return Optional.of(seat); // Estado del asiento actualizado exitosamente
    }

    @Override
    @Transactional
    public boolean releaseReservedSeats(SeatReleaseRequestDTO seatReleaseRequestDTO) {
        Optional<User> userOptional = userRepository.findById(seatReleaseRequestDTO.userId());

        if (!userOptional.isPresent()) {
            logger.error("Usuario no encontrado o no activo: {}", seatReleaseRequestDTO.userId());
            return false; // Usuario no encontrado o no activo
        }

        User user = userOptional.get();
        List<Seat> seats = seatRepository.findAllById(seatReleaseRequestDTO.seatIds());

        for (Seat seat : seats) {
            if (seat.getCurrentUser().equals(user) && seat.getAvailability() == Seat.Availability.OCCUPIED) {
                logger.info("Liberando asiento: {}, para el usuario: {}", seat.getId(), user.getId());
                seat.setAvailability(Seat.Availability.RESERVED);
                seatRepository.save(seat);
            } else {
                logger.warn("Asiento no puede ser liberado: {}, current user: {}, expected user: {}, availability: {}",
                        seat.getId(), seat.getCurrentUser() != null ? seat.getCurrentUser().getId() : "null", user.getId(), seat.getAvailability());
            }
        }

        return true;

    }



}