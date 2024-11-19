package com.posco.assignoperation.s20a01.service;

import com.posco.assignoperation.s20a01.domain.carAssignment.CancelCarAssignmentCommand;
import com.posco.assignoperation.s20a01.domain.carAssignment.CarAssignment;
import com.posco.assignoperation.s20a01.domain.carAssignment.RequestCarAssignmentCommand;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class CarAssignmentController {

    private final CarAssignmentRepositoryService carAssignmentRepositoryService;

    @Autowired
    public CarAssignmentController(
        CarAssignmentRepositoryService carAssignmentRepositoryService
    ) {
        this.carAssignmentRepositoryService = carAssignmentRepositoryService;
    }

    @GetMapping(path = "/carAssignments")
    public ResponseEntity<List<CarAssignment>> findAll() {
        return ResponseEntity.ok(carAssignmentRepositoryService.findAll());
    }

    @PostMapping(path = "/carAssignments")
    public ResponseEntity<CarAssignment> create(
        @Valid @RequestBody RequestCarAssignmentCommand command
    ) {
        return ResponseEntity.ok(
            carAssignmentRepositoryService.create(command)
        );
    }

    @PostMapping(path = "carAssignments/{Long}/cancelCarAssignment")
    public ResponseEntity<CarAssignment> cancelCarAssignment(
        @PathVariable("id") Long id,
        @Valid @RequestBody CancelCarAssignmentCommand command
    ) {
        CarAssignment carAssignment = carAssignmentRepositoryService.findById(
            id
        );

        // 도메인 포트 메서드 직접 호출
        carAssignment.cancelCarAssignment(command);

        return ResponseEntity.ok(
            carAssignmentRepositoryService.save(carAssignment)
        );
    }
}
