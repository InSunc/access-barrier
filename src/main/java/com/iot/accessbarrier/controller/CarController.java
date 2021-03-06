package com.iot.accessbarrier.controller;

import com.iot.accessbarrier.domain.Car;
import com.iot.accessbarrier.dto.RqCarDTO;
import com.iot.accessbarrier.dto.RqCarDTO2;
import com.iot.accessbarrier.dto.RsCarDTO;
import com.iot.accessbarrier.dto.RsParkingHistoryDTO;
import com.iot.accessbarrier.mapper.CarMapper;
import com.iot.accessbarrier.mapper.ParkingHistoryMapper;
import com.iot.accessbarrier.service.CarService;
import com.iot.accessbarrier.service.ParkingHistoryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final ParkingHistoryService parkingHistoryService;

    @ApiOperation(value = "Save Car info based on the provided json object")
    @PostMapping
    public ResponseEntity<RsCarDTO> save(@RequestBody RqCarDTO2 rqCarDTO) {
        var car = CarMapper.INSTANCE.rqCarDTOtoCar(rqCarDTO);
        var rsCarDTO = CarMapper.INSTANCE.carToRsCarDTO(carService.save(car));
        return ResponseEntity.ok(rsCarDTO);
    }

    @ApiOperation(value = "(Optional) Save Car info based on the provided image")
    @PostMapping("/image-save")
    public ResponseEntity<RsCarDTO> saveBasedOnImage(@RequestParam(value = "image") MultipartFile image) throws IOException {
        var rsCarDTO = CarMapper.INSTANCE.carToRsCarDTO(carService.saveBasedOnImage(image));
        return ResponseEntity.ok(rsCarDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<RsCarDTO>> getAll() {
        var rsCarDTOs = carService.getAll().stream()
                .map(CarMapper.INSTANCE::carToRsCarDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(rsCarDTOs);
    }

    @ApiOperation(value = "Get Car info based on the plateNumber")
    @GetMapping("/{plateNumber}")
    public ResponseEntity<RsCarDTO> getByPlateNumber(@PathVariable String plateNumber) {
        var rsCarDTO = CarMapper.INSTANCE.carToRsCarDTO(carService.getCarByPlateNumber(plateNumber));
        return ResponseEntity.ok(rsCarDTO);
    }

    @GetMapping("/{plateNumber}/parking-histories")
    public ResponseEntity<List<RsParkingHistoryDTO>> getAllParkingHistoriesByPlateNumber(@PathVariable String plateNumber) {
        var parkingHistories = parkingHistoryService.getAllByCarPlateNumber(plateNumber).stream()
                .map(ParkingHistoryMapper.INSTANCE::parkingHistoryToRsParkingHistoryDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(parkingHistories);
    }

}
