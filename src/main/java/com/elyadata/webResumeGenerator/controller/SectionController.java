package com.elyadata.webResumeGenerator.controller;
import com.elyadata.webResumeGenerator.dto.SectionDTO;
import com.elyadata.webResumeGenerator.services.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("section")
public class SectionController {
    private final SectionService sectionService;
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }
    @GetMapping("")
    public ResponseEntity<List<SectionDTO>> getAllSection(){
        return ResponseEntity.ok(sectionService.findAllSection());
    }
    @GetMapping("/{id}")
    public ResponseEntity<SectionDTO> getSectionById(@PathVariable Long id){
        return ResponseEntity.ok(sectionService.findSectionById(id));
    }

    @GetMapping("/resume/{id}")
    public ResponseEntity<List<SectionDTO>>  getSectionByResumeId(@PathVariable Long resumeId){
        return ResponseEntity.ok(sectionService.findSectionByResumeId(resumeId));
    }
    @PostMapping("/")
    public ResponseEntity<SectionDTO> addSection(@RequestBody SectionDTO sectionDto){
        return  ResponseEntity.ok(sectionService.addSection(sectionDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SectionDTO> updateSection(@RequestBody SectionDTO sectionDto){
        return  ResponseEntity.ok(sectionService.updateSection(sectionDto));
    }

    @DeleteMapping("/{id}")
    public void deleteSection(@PathVariable("id") Long id){
        sectionService.deleteSection(id);
    }



}
