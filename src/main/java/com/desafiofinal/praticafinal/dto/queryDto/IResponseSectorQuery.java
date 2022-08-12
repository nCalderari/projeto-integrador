package com.desafiofinal.praticafinal.dto.queryDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface IResponseSectorQuery {

    IResponseSectorQuery MAPPER = Mappers.getMapper(IResponseSectorQuery.class);

    ResponseSectorQuery mappingResponse(ResponseSectorQuery responseSectorQuery);

//    @Mappings({
//            @Mapping(),
//            @Mapping(),
//            @Mapping()
//    })
}
