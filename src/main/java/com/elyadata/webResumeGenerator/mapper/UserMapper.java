package com.elyadata.webResumeGenerator.mapper;

import com.elyadata.webResumeGenerator.dto.UserDTO;
import com.elyadata.webResumeGenerator.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper extends EntityMapper<User, User>{
}