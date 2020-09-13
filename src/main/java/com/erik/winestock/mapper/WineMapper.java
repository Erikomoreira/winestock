package com.erik.winestock.mapper;


import com.erik.winestock.dto.WineDTO;
import com.erik.winestock.entity.Wine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WineMapper {

    WineMapper INSTANCE = Mappers.getMapper(WineMapper.class);

    Wine toModel(WineDTO wineDTO);

    WineDTO toDTO(Wine wine);
}