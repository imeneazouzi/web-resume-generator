package com.elyadata.webResumeGenerator.services;
import com.elyadata.webResumeGenerator.dto.ParametersDTO;
import java.util.List;

public interface ParametersService {
    public ParametersDTO addParameters(ParametersDTO parametersDto);
    public List<ParametersDTO> findAllParameters();
    public void deleteParameters(Long id);
    public ParametersDTO updateParameters(ParametersDTO parametersDto);
    public ParametersDTO findParametersById(Long id);
}
