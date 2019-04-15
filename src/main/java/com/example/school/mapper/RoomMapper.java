package com.example.school.mapper;

import com.example.school.dto.RoomDTO;
import com.example.school.entity.Room;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDTO toDTO(Room room);

    List<RoomDTO> toDTOList(List<Room> rooms);

}
