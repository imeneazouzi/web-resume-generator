package com.elyadata.webResumeGenerator.mapper;

import com.elyadata.webResumeGenerator.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface    SectionMapper extends EntityMapper<Section, Section>{
}