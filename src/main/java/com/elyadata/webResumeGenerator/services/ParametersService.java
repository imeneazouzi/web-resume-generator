package com.elyadata.webResumeGenerator.services;
import com.elyadata.webResumeGenerator.dto.ParametersDTO;
import java.util.List;

public interface ParametersService {
     ParametersDTO addParameters(ParametersDTO parametersDto);
     List<ParametersDTO> findAllParameters();
     void deleteParameters(Long id);
     ParametersDTO updateParameters(ParametersDTO parametersDto);
     ParametersDTO findParametersById(Long id);
}
