package com.posco.standardmanagement.s20a01.service;

import com.posco.standardmanagement.s20a01.domain.vehicle.AddVehicleCommand;
import com.posco.standardmanagement.s20a01.domain.vehicle.Vehicle;
import com.posco.standardmanagement.s20a01.domain.vehicle.VehicleRepository;
import com.posco.standardmanagement.s20a01.domain.vehicle.mybatis.VehicleMapper;
import com.posco.standardmanagement.s20a01.domain.vehicle.mybatis.VehicleMybatisEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class VehicleRepositoryService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleRepositoryService(
        VehicleRepository vehicleRepository,
        VehicleMapper vehicleMapper
    ) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    public Vehicle create(AddVehicleCommand command) {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicensePlateNumber(command.getLicensePlateNumber());
        vehicle.setBrand(command.getBrand());
        vehicle.setModel(command.getModel());
        vehicle.setSeatCapacity(command.getSeatCapacity());
        return vehicleRepository.save(vehicle);
    }

    public Vehicle save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findById(String id) {
        return vehicleRepository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Vehicle not found"
                )
            );
    }

    //// mybatis
    private Vehicle convertToEntity(VehicleMybatisEntity mybatisEntity) {
        Vehicle entity = new Vehicle();
        return entity;
    }

    private VehicleMybatisEntity convertToMybatisEntity(Vehicle entity) {
        VehicleMybatisEntity mybatisEntity = new VehicleMybatisEntity();
        return mybatisEntity;
    }
    // 예시
    // public List<Vehicle> findAllByMapper() {
    //     return mybatisMapper.selectVehicleList().stream()
    //         .map(this::convertToEntity)
    //         .collect(Collectors.toList());
    // }

    // public Vehicle findByIdMapper(String id) {
    //     VehicleMybatisEntity mybatisEntity = mybatisMapper.selectVehicle(id);
    //     if (mybatisEntity == null) {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle not found");
    //     }
    //     return convertToEntity(mybatisEntity);
    // }
}
