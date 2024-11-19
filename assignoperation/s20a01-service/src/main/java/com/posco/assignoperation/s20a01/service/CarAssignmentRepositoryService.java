package com.posco.assignoperation.s20a01.service;

import com.posco.assignoperation.s20a01.domain.carAssignment.CancelCarAssignmentCommand;
import com.posco.assignoperation.s20a01.domain.carAssignment.CarAssignment;
import com.posco.assignoperation.s20a01.domain.carAssignment.CarAssignmentRepository;
import com.posco.assignoperation.s20a01.domain.carAssignment.RequestCarAssignmentCommand;
import com.posco.assignoperation.s20a01.domain.carAssignment.mybatis.CarAssignmentMapper;
import com.posco.assignoperation.s20a01.domain.carAssignment.mybatis.CarAssignmentMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class CarAssignmentRepositoryService {

    private final CarAssignmentRepository carAssignmentRepository;
    private final CarAssignmentMapper carAssignmentMapper;

    @Autowired
    public CarAssignmentRepositoryService(
        CarAssignmentRepository carAssignmentRepository,
        CarAssignmentMapper carAssignmentMapper
    ) {
        this.carAssignmentRepository = carAssignmentRepository;
        this.carAssignmentMapper = carAssignmentMapper;
    }

    public CarAssignment create(RequestCarAssignmentCommand command) {
        CarAssignment carAssignment = new CarAssignment();
        carAssignment.setRequesterName(command.getRequesterName());
        carAssignment.setOrganization(command.getOrganization());
        carAssignment.setEmployeeNumber(command.getEmployeeNumber());
        carAssignment.setOfficeNumber(command.getOfficeNumber());
        carAssignment.setMobileNumber(command.getMobileNumber());
        carAssignment.setRequestDate(command.getRequestDate());
        carAssignment.setApproverInfo(command.getApproverInfo());
        carAssignment.setApproverPosition(command.getApproverPosition());
        carAssignment.setUsageCategory(command.getUsageCategory());
        carAssignment.setUsagePurpose(command.getUsagePurpose());
        carAssignment.setOperationSection(command.getOperationSection());
        carAssignment.setMainDepartment(command.getMainDepartment());
        carAssignment.setNumberOfPassengers(command.getNumberOfPassengers());
        carAssignment.setCarType(command.getCarType());
        carAssignment.setOperationPeriod(command.getOperationPeriod());
        carAssignment.setIncludeDriver(command.getIncludeDriver());
        carAssignment.setRouteSetting(command.getRouteSetting());
        carAssignment.setRemarks(command.getRemarks());
        carAssignment.setPassengerContact(command.getPassengerContact());
        carAssignment.setAttachedDocuments(command.getAttachedDocuments());
        carAssignment.setUsageCategory(command.getUsageCategory());
        carAssignment.setCarType(command.getCarType());
        carAssignment.setMainDepartment(command.getMainDepartment());
        carAssignment.setOperationSection(command.getOperationSection());
        carAssignment.setOperationType(command.getOperationType());
        carAssignment.setIncludeDriver(command.getIncludeDriver());
        carAssignment.setProgressStage(command.getProgressStage());
        return carAssignmentRepository.save(carAssignment);
    }

    public CarAssignment save(CarAssignment carAssignment) {
        return carAssignmentRepository.save(carAssignment);
    }

    public List<CarAssignment> findAll() {
        return carAssignmentRepository.findAll();
    }

    public CarAssignment findById(Long id) {
        return carAssignmentRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "CarAssignment not found"
                )
            );
    }

    //// mybatis
    private CarAssignment convertToEntity(
        CarAssignmentMybatisEntity mybatisEntity
    ) {
        CarAssignment entity = new CarAssignment();
        return entity;
    }

    private CarAssignmentMybatisEntity convertToMybatisEntity(
        CarAssignment entity
    ) {
        CarAssignmentMybatisEntity mybatisEntity = new CarAssignmentMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<CarAssignment> findAllByMapper() {
    //     return mybatisMapper.selectCarAssignmentList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public CarAssignment findByIdMapper(Long id) {
    //     CarAssignmentMybatisEntity mybatisEntity = mybatisMapper.selectCarAssignment(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CarAssignment not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}
