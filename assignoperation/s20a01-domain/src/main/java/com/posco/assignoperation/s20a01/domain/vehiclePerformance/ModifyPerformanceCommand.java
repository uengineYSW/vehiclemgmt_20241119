package com.posco.assignoperation.s20a01.domain.vehiclePerformance;

import java.util.*;
import lombok.Data;
import java.time.LocalDate;
import com.posco.assignoperation.s20a01.domain.date;
import com.posco.assignoperation.s20a01.domain.int;
import com.posco.assignoperation.s20a01.domain.int;


@Data
public class ModifyPerformanceCommand {

        private String registrationId;
        private String vehicleNumber;
        private date registrationDate;
        private String purpose;
        private String departure;
        private String departureTime;
        private int accumulatedDistanceBefore;
        private String destination;
        private String arrivalTime;
        private int accumulatedDistanceAfter;


}
