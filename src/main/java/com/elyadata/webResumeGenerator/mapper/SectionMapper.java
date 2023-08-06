package com.elyadata.webResumeGenerator.mapper;

import com.elyadata.webResumeGenerator.dto.SectionDTO;
import com.elyadata.webResumeGenerator.model.Section;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",uses = {SectionTypeMapper.class, ParametersMapper.class})
public interface SectionMapper extends EntityMapper<SectionDTO, Section> {
}
