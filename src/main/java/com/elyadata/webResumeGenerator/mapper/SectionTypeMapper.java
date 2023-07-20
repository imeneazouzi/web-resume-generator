package com.elyadata.webResumeGenerator.mapper;

import com.elyadata.webResumeGenerator.dto.SectionTypeDTO;
import com.elyadata.webResumeGenerator.model.SectionType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SectionTypeMapper extends EntityMapper<SectionTypeDTO, SectionType>{
}