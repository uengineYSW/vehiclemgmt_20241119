package com.posco.assignoperation.s20a01.service;

import com.posco.assignoperation.s20a01.domain.vehiclePerformance.DeletePerformanceCommand;
import com.posco.assignoperation.s20a01.domain.vehiclePerformance.ModifyPerformanceCommand;
import com.posco.assignoperation.s20a01.domain.vehiclePerformance.RegisterDrivingLogCommand;
import com.posco.assignoperation.s20a01.domain.vehiclePerformance.RegisterPerformanceCommand;
import com.posco.assignoperation.s20a01.domain.vehiclePerformance.VehiclePerformance;
import com.posco.assignoperation.s20a01.domain.vehiclePerformance.VehiclePerformanceRepository;
import com.posco.assignoperation.s20a01.domain.vehiclePerformance.mybatis.VehiclePerformanceMapper;
import com.posco.assignoperation.s20a01.domain.vehiclePerformance.mybatis.VehiclePerformanceMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class VehiclePerformanceRepositoryService {

    private final VehiclePerformanceRepository vehiclePerformanceRepository;
    private final VehiclePerformanceMapper vehiclePerformanceMapper;

    @Autowired
    public VehiclePerformanceRepositoryService(
        VehiclePerformanceRepository vehiclePerformanceRepository,
        VehiclePerformanceMapper vehiclePerformanceMapper
    ) {
        this.vehiclePerformanceRepository = vehiclePerformanceRepository;
        this.vehiclePerformanceMapper = vehiclePerformanceMapper;
    }

    public VehiclePerformance create(RegisterPerformanceCommand command) {
        VehiclePerformance vehiclePerformance = new VehiclePerformance();
        vehiclePerformance.setRegistrationId(command.getRegistrationId());
        vehiclePerformance.setVehicleNumber(command.getVehicleNumber());
        vehiclePerformance.setRegistrationDate(command.getRegistrationDate());
        vehiclePerformance.setPurpose(command.getPurpose());
        vehiclePerformance.setDeparture(command.getDeparture());
        vehiclePerformance.setDepartureTime(command.getDepartureTime());
        vehiclePerformance.setAccumulatedDistanceBefore(
            command.getAccumulatedDistanceBefore()
        );
        vehiclePerformance.setDestination(command.getDestination());
        vehiclePerformance.setArrivalTime(command.getArrivalTime());
        vehiclePerformance.setAccumulatedDistanceAfter(
            command.getAccumulatedDistanceAfter()
        );
        vehiclePerformance.setPurpose(command.getPurpose());
        return vehiclePerformanceRepository.save(vehiclePerformance);
    }

    public void delete(String id) {
        VehiclePerformance vehiclePerformance = findById(id);
        vehiclePerformanceRepository.delete(vehiclePerformance);
    }

    public VehiclePerformance save(VehiclePerformance vehiclePerformance) {
        return vehiclePerformanceRepository.save(vehiclePerformance);
    }

    public List<VehiclePerformance> findAll() {
        return vehiclePerformanceRepository.findAll();
    }

    public VehiclePerformance findById(String id) {
        return vehiclePerformanceRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "VehiclePerformance not found"
                )
            );
    }

    //// mybatis
    private VehiclePerformance convertToEntity(
        VehiclePerformanceMybatisEntity mybatisEntity
    ) {
        VehiclePerformance entity = new VehiclePerformance();
        return entity;
    }

    private VehiclePerformanceMybatisEntity convertToMybatisEntity(
        VehiclePerformance entity
    ) {
        VehiclePerformanceMybatisEntity mybatisEntity = new VehiclePerformanceMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<VehiclePerformance> findAllByMapper() {
    //     return mybatisMapper.selectVehiclePerformanceList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public VehiclePerformance findByIdMapper(String id) {
    //     VehiclePerformanceMybatisEntity mybatisEntity = mybatisMapper.selectVehiclePerformance(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "VehiclePerformance not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}
