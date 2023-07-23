package com.elyadata.webResumeGenerator.controller;
import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import com.elyadata.webResumeGenerator.services.ResumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("resume")
public class ResumeController {
    private final ResumeService resumeService;
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }
    @GetMapping("")
    public ResponseEntity<List<ResumeDTO>> getAllResume(){
        return ResponseEntity.ok(resumeService.findAllResume());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResumeDTO> getResumeById(@PathVariable Long id){
        return ResponseEntity.ok(resumeService.findResumeById(id));
    }
    @GetMapping("/resume-title/{title}")
    public ResponseEntity<List<ResumeDTO>> findByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(resumeService.findByTitle(title));
    }
    @PostMapping("/")
    public ResponseEntity<ResumeDTO> addResume(@RequestBody ResumeDTO resumeDto){
        return ResponseEntity.ok(resumeService.addResume(resumeDto));
    }
    @PutMapping
    public ResponseEntity<ResumeDTO> updateResume(@RequestBody ResumeDTO resumeDto) {
        return ResponseEntity.ok(resumeService.updateResume(resumeDto));
    }
    @DeleteMapping("/{id}")
    public void deleteResume(@PathVariable("id") Long id){
        resumeService.deleteResume(id);
    }
}
