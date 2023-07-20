package com.elyadata.webResumeGenerator.mapper;

import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import com.elyadata.webResumeGenerator.model.Resume;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ResumeMapper extends EntityMapper<ResumeDTO, Resume>{
}
