package com.elyadata.webResumeGenerator.services.impl;
import com.elyadata.webResumeGenerator.dto.ParametersDTO;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.mapper.ParametersMapper;
import com.elyadata.webResumeGenerator.model.Parameters;
import com.elyadata.webResumeGenerator.repo.ParametersRepository;
import com.elyadata.webResumeGenerator.services.ParametersService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParameterServiceImpl implements ParametersService {

    private final ParametersRepository parametersRepository;
    private final ParametersMapper parametersMapper;
    public ParameterServiceImpl (ParametersRepository parametersRepository ,ParametersMapper parametersMapper)
    {
        this. parametersRepository =  parametersRepository;
        this.parametersMapper = parametersMapper;
    }
    @Override
    public ParametersDTO addParameters(ParametersDTO parametersDto) {
        return parametersMapper.toDto(parametersRepository.save(parametersMapper.toEntity(parametersDto)));
    }
    @Override
    public List<ParametersDTO> findAllParameters() {
        return parametersMapper.toDto(parametersRepository.findAll());
    }
    @Override
    public void deleteParameters(Long id){
        parametersRepository.deleteById(id);
    }
    @Override
    public ParametersDTO updateParameters(ParametersDTO parametersDto){
        Parameters existingParameters = parametersRepository.findById(parametersDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Parameter not found with ID: " + parametersDto.getId()));
        existingParameters.setTitle(parametersDto.getTitle());
        existingParameters.setDescription(parametersDto.getDescription());
        existingParameters.setStartDate(parametersDto.getStartDate());
        existingParameters.setEndDate(parametersDto.getEndDate());
        return parametersMapper.toDto(parametersRepository.save(existingParameters));
    }
    @Override
    public ParametersDTO findParametersById(Long id) {
        return parametersMapper.toDto(parametersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("parameterDto with id " + id + " was not found")));
    }
}
