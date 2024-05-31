package com.s1511.ticketcine.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String seatNumber;
    private boolean reserved;
    @ManyToOne
    @JoinColumn(name = "function_details_id", referencedColumnName = "id")
    private FunctionDetails functionDetails;
    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "current_user_id")
    private User currentUser;
    @ManyToOne
    @JoinColumn(name = "previous_user_id")
    private User previousUser;

    private Availability availability;

    public enum Availability {
        AVAILABLE,
        OCCUPIED,
        RESERVED
    }
}