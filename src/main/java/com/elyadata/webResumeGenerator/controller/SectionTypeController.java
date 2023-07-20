package com.elyadata.webResumeGenerator.controller;


import com.elyadata.webResumeGenerator.model.SectionType;
import com.elyadata.webResumeGenerator.services.SectionTypeService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<SectionType>> getAllSectionType(){
        return ResponseEntity.ok(sectionTypeService.findAllSectionType());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SectionType> getSectionTypeById(@PathVariable Long id){
        return ResponseEntity.ok(sectionTypeService.findSectionTypeById(id));
    }
    @PostMapping("/")
    public ResponseEntity<SectionType> addSectionType(@RequestBody SectionType sectionType){
        return  ResponseEntity.ok(sectionTypeService.addSectionType(sectionType));
    }


    @PutMapping("/{id}")
    public ResponseEntity<SectionType> updateSectionType(@RequestBody SectionType sectionType){
        return  ResponseEntity.ok(sectionTypeService.updateSectionType(sectionType));
    }

    @DeleteMapping("/{id}")
    public void deleteSectionType(@PathVariable("id") Long id){
        sectionTypeService.deleteSectionType(id);
    }


}
