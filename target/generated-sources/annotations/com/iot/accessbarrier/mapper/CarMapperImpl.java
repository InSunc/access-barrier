package com.iot.accessbarrier.mapper;

import com.iot.accessbarrier.domain.Car;
import com.iot.accessbarrier.dto.CarInfoDto;
import com.iot.accessbarrier.dto.RqCarDTO;
import com.iot.accessbarrier.dto.RqCarDTO2;
import com.iot.accessbarrier.dto.RsCarDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-26T18:26:42+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.2 (N/A)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public Car rqCarDTOtoCar(RqCarDTO rqCarDTO) {
        if ( rqCarDTO == null ) {
            return null;
        }

        Car car = new Car();

        car.setPlateNumber( rqCarDTO.getPlateNumber() );
        car.setBrand( rqCarDTO.getBrand() );
        car.setOwner( rqCarDTO.getOwner() );

        return car;
    }

    @Override
    public Car carInfoDTOtoCar(CarInfoDto carInfoDto) {
        if ( carInfoDto == null ) {
            return null;
        }

        Car car = new Car();

        car.setPlateNumber( carInfoDto.getPlateNumber() );
        car.setBrand( carInfoDto.getBrand() );

        return car;
    }

    @Override
    public RsCarDTO carToRsCarDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        RsCarDTO rsCarDTO = new RsCarDTO();

        rsCarDTO.setId( car.getId() );
        rsCarDTO.setPlateNumber( car.getPlateNumber() );
        rsCarDTO.setBrand( car.getBrand() );
        rsCarDTO.setOwner( car.getOwner() );

        return rsCarDTO;
    }

    @Override
    public Car rqCarDTOtoCar(RqCarDTO2 rqCarDTO) {
        if ( rqCarDTO == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( rqCarDTO.getId() );
        car.setPlateNumber( rqCarDTO.getPlateNumber() );
        car.setBrand( rqCarDTO.getBrand() );
        car.setOwner( rqCarDTO.getOwner() );

        return car;
    }
}
