package com.posco.standardmanagement.s20a01.domain.vehicle;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AddVehicleCommand {

    private String licensePlateNumber;
    private String brand;
    private String model;
    private Integer seatCapacity;
}
