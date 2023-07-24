package com.elyadata.webResumeGenerator.controller;
import com.elyadata.webResumeGenerator.dto.ParametersDTO;
import com.elyadata.webResumeGenerator.services.ParametersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("parameters")
public class ParametersController {
    private final ParametersService parametersService;
    public ParametersController(ParametersService parametersService) {
        this.parametersService = parametersService;
    }
    @GetMapping("")
    public ResponseEntity<List<ParametersDTO>> getAllParameters(){
        return ResponseEntity.ok(parametersService.findAllParameters());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParametersDTO> getParametersById(@PathVariable Long id){
        return ResponseEntity.ok(parametersService.findParametersById(id));
    }
    @PostMapping("/")
    public ResponseEntity<ParametersDTO> addParameters(@RequestBody ParametersDTO parametersDto){
        return  ResponseEntity.ok(parametersService.addParameters(parametersDto));
    }
    @PutMapping
    public ResponseEntity<ParametersDTO> updateParameters(@RequestBody ParametersDTO parametersDto){
        return  ResponseEntity.ok(parametersService.updateParameters(parametersDto));
    }
    @DeleteMapping("/{id}")
    public void deleteParameters(@PathVariable("id") Long id){
        parametersService.deleteParameters(id);
    }
}
