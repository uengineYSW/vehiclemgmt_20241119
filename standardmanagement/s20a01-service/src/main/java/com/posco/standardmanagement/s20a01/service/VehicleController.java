package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.vehicle.AddVehicleCommand;
import com.posco.standardmanagement.s20a01.domain.vehicle.Vehicle;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class VehicleController {

    private final VehicleRepositoryService vehicleRepositoryService;

    @Autowired
    public VehicleController(
        VehicleRepositoryService vehicleRepositoryService
    ) {
        this.vehicleRepositoryService = vehicleRepositoryService;
    }

    @GetMapping(path = "/vehicles")
    public ResponseEntity<List<Vehicle>> findAll() {
        return ResponseEntity.ok(vehicleRepositoryService.findAll());
    }

    @PostMapping(path = "/vehicles")
    public ResponseEntity<Vehicle> create(
        @Valid @RequestBody AddVehicleCommand command
    ) {
        return ResponseEntity.ok(vehicleRepositoryService.create(command));
    }
}
