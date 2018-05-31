package com.bpunch.schoolapprest.model.dto.mappers;

public interface IDtoMapper<ENTITY, DTO> {

    DTO mapToDto(ENTITY source);

    ENTITY mapToEntity(DTO source);

}
