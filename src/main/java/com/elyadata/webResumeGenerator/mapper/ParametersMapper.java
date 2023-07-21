package com.elyadata.webResumeGenerator.mapper;

import com.elyadata.webResumeGenerator.model.Parameters;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ParametersMapper extends EntityMapper<Parameters, Parameters>{
}

