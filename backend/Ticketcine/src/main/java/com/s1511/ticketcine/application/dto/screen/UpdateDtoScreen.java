package com.s1511.ticketcine.application.dto.screen;
import com.s1511.ticketcine.application.dto.seat.ResponseSeatDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDtoScreen {
    private String id;
    private String name;
    private Boolean active;
}

// TODO. VER SI ES NECESARIO!!