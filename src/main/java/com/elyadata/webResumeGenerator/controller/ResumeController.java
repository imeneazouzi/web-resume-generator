package com.elyadata.webResumeGenerator.controller;
import com.elyadata.webResumeGenerator.model.Resume;
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
    public ResponseEntity<List<Resume>> getAllResume(){
        return ResponseEntity.ok(resumeService.findAllResume());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id){
        return ResponseEntity.ok(resumeService.findResumeById(id));
    }

    @GetMapping("/resume-title/{title}")
    public ResponseEntity<List<Resume>> findByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(resumeService.findByTitle(title));
    }


    @PostMapping("/")
    public ResponseEntity<Resume> addResume(@RequestBody Resume resume){
        return ResponseEntity.ok(resumeService.addResume(resume));
    }


    @PutMapping
    public ResponseEntity<Resume> updateResume(@RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.updateResume(resume));
    }

    @DeleteMapping("/{id}")
    public void deleteResume(@PathVariable("id") Long id){
        resumeService.deleteResume(id);
    }

}
