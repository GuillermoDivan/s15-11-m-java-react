package com.s1511.ticketcine.application.implementations;

import com.s1511.ticketcine.application.dto.seat.MultiSeatDTO;
import com.s1511.ticketcine.domain.entities.User;
import com.s1511.ticketcine.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s1511.ticketcine.application.dto.seat.SeatDTO;
import com.s1511.ticketcine.application.dto.seat.SeatReservationDTO;
import com.s1511.ticketcine.application.mapper.SeatMapper;
import com.s1511.ticketcine.domain.entities.Seat;
import com.s1511.ticketcine.domain.repository.SeatRepository;
import com.s1511.ticketcine.domain.services.SeatService;

import java.time.LocalDateTime;
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
        seat.setReservationTime(LocalDateTime.now()); // Establecer el tiempo de reserva
        seatRepository.save(seat);
        return Optional.of(seat); // Estado del asiento actualizado exitosamente
    }

    @Override
    @Transactional
    public List<Optional<Seat>> reserveMultipleSeats(MultiSeatDTO multiSeatReservationDTO) {
        Optional<User> userOptional = userRepository.findById(multiSeatReservationDTO.userId());

        if (!userOptional.isPresent()) {
            return List.of(); //Usuario no encontrado
        }

        User user = userOptional.get();
        List<Optional<Seat>> reservedSeats = multiSeatReservationDTO.seatIds().stream()
                .map(seatId -> {
                    Optional<Seat> seatOptional = seatRepository.findById(seatId);

                    if (seatOptional.isPresent()) {
                        Seat seat = seatOptional.get();
                        if (seat.getAvailability() == Seat.Availability.AVAILABLE) {
                            seat.setCurrentUser(user);
                            seat.setAvailability(Seat.Availability.OCCUPIED);
                            seat.setReservationTime(LocalDateTime.now()); // Establecer el tiempo de reserva
                            seatRepository.save(seat);
                            return Optional.of(seat);
                        }
                    }
                    return Optional.<Seat>empty();

                }).collect(Collectors.toList());

        return reservedSeats;
    }

    @Override
    public List<Optional<Seat>> releaseSeats(MultiSeatDTO seatReleaseDTO) {
        Optional<User> userOptional = userRepository.findById(seatReleaseDTO.userId());

        if (!userOptional.isPresent()) {
            return List.of(); // Usuario no encontrado o no activo
        }

        User user = userOptional.get();
        List<Optional<Seat>> releasedSeats = seatReleaseDTO.seatIds().stream()
                .map(seatId -> {
                    Optional<Seat> seatOptional = seatRepository.findById(seatId);

                    if (seatOptional.isPresent()) {
                        Seat seat = seatOptional.get();
                        if (seat.getAvailability() == Seat.Availability.OCCUPIED &&
                                seat.getCurrentUser().equals(user)) {
                            seat.setPreviousUser(user);
                            seat.setCurrentUser(null);
                            seat.setAvailability(Seat.Availability.RESERVED);
                            seatRepository.save(seat);
                            return Optional.of(seat);
                        }
                    }
                    return Optional.<Seat>empty();
                }).collect(Collectors.toList());

        return releasedSeats;
    }

}