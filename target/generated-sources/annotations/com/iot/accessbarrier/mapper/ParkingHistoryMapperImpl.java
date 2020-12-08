package com.iot.accessbarrier.mapper;

import com.iot.accessbarrier.domain.ParkingHistory;
import com.iot.accessbarrier.dto.RsParkingHistoryDTO;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-26T18:26:42+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 14.0.2 (N/A)"
)
public class ParkingHistoryMapperImpl implements ParkingHistoryMapper {

    @Override
    public RsParkingHistoryDTO parkingHistoryToRsParkingHistoryDTO(ParkingHistory parkingHistory) {
        if ( parkingHistory == null ) {
            return null;
        }

        RsParkingHistoryDTO rsParkingHistoryDTO = new RsParkingHistoryDTO();

        rsParkingHistoryDTO.setId( parkingHistory.getId() );
        rsParkingHistoryDTO.setDateFrom( parkingHistory.getDateFrom() );
        rsParkingHistoryDTO.setDateTo( parkingHistory.getDateTo() );

        return rsParkingHistoryDTO;
    }
}
