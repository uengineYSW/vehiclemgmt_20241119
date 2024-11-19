package com.posco.standardmanagement.s20a01.domain.vehicle;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Vehicle_table")
@Data
public class Vehicle {

    @Id
    private String licensePlateNumber;

    private String brand;

    private String model;

    private Integer seatCapacity;

    private Double drivingDistance;
}
