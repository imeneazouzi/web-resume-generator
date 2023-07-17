package com.elyadata.webResumeGenerator.controller;
import com.elyadata.webResumeGenerator.model.Resume;
import com.elyadata.webResumeGenerator.services.ResumeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/Resume")
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Resume>> getAllResume(){
        List<Resume> resume = resumeService.findAllresume();
        return new ResponseEntity<>(resume, HttpStatus.OK);
}

    @GetMapping("/find/{id}")
    public ResponseEntity<Resume> getProblemById(@PathVariable("id") Long id){
        Resume resume = resumeService.findResumeById(id);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @GetMapping("/by-title/{title}")
    public ResponseEntity<List<Resume>> findByTitle(@PathVariable("title") String title) {
        List<Resume> resume= resumeService.findByTitle(title);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Resume> addResume(@RequestBody Resume resume){
        Resume newresume = resumeService.addResume(resume);
        return new ResponseEntity<>(newresume, HttpStatus.CREATED);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Resume> updateProblem(@RequestBody Resume resume,@PathVariable("id") Long id){
        Resume updateResume = resumeService.updateResume(resume,id);
        return new ResponseEntity<>(updateResume, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteResume(@PathVariable("id") Long id){
        resumeService.deleteResume(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
