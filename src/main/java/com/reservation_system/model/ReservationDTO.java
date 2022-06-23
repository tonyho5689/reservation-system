package com.reservation_system.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReservationDTO {

    private Long id;

    @NotNull
    private LocalDate reservationDate;

    @NotNull
    private LocalDate startTime;

    @NotNull
    private LocalDate endTime;

    @NotNull
    private Long user;

}
