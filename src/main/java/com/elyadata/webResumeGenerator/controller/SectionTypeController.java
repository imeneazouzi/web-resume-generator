package com.elyadata.webResumeGenerator.controller;
import com.elyadata.webResumeGenerator.dto.SectionTypeDTO;
import com.elyadata.webResumeGenerator.services.SectionTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("sectionType")
public class SectionTypeController {
    private final SectionTypeService sectionTypeService;
    public SectionTypeController(SectionTypeService sectionTypeService) {
        this.sectionTypeService = sectionTypeService;
    }
    @GetMapping("")
    public ResponseEntity<List<SectionTypeDTO>> getAllSectionType(){
        return ResponseEntity.ok(sectionTypeService.findAllSectionType());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SectionTypeDTO> getSectionTypeById(@PathVariable Long id){
        return ResponseEntity.ok(sectionTypeService.findSectionTypeById(id));
    }

    @GetMapping("/section/{id}")
    public ResponseEntity<List<SectionTypeDTO>>  getSectionTypeBysectionId(@PathVariable Long sectionId){
        return ResponseEntity.ok(sectionTypeService.findSectionTypesBySectionId(sectionId));
    }




    @PostMapping("/")
    public ResponseEntity<SectionTypeDTO> addSectionType(@RequestBody SectionTypeDTO sectionTypeDto){
        return  ResponseEntity.ok(sectionTypeService.addSectionType(sectionTypeDto));
    }


    @PutMapping("/{id}")
    public ResponseEntity<SectionTypeDTO> updateSectionType(@RequestBody SectionTypeDTO sectionTypeDto){
        return  ResponseEntity.ok(sectionTypeService.updateSectionType(sectionTypeDto));
    }

    @DeleteMapping("/{id}")
    public void deleteSectionType(@PathVariable("id") Long id){
        sectionTypeService.deleteSectionType(id);
    }


}
