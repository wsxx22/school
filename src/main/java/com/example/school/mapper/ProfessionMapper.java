package com.example.school.mapper;

import com.example.school.dto.ProfessionDTO;
import com.example.school.entity.Profession;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessionMapper {

    ProfessionDTO professionToDTO (Profession profession);

}
