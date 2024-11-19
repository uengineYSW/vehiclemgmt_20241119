package com.posco.assignoperation.s20a01.domain.vehiclePerformance;

import java.util.*;
import lombok.Data;
import java.time.LocalDate;
import com.posco.assignoperation.s20a01.domain.int;
import com.posco.assignoperation.s20a01.domain.int;
import com.posco.assignoperation.s20a01.domain.int;
import com.posco.assignoperation.s20a01.domain.Purpose;


@Data
public class RegisterDrivingLogCommand {

        private String registrationId;
        private String vehicleNumber;
        private Date registrationDate;
        private String purpose;
        private String departure;
        private String departureTime;
        private int accumulatedDistanceBefore;
        private String destination;
        private String arrivalTime;
        private int accumulatedDistanceAfter;
        private int drivingDistance;
        private Purpose purpose;


}
