package com.elyadata.webResumeGenerator.controller;
import com.elyadata.webResumeGenerator.services.TemplateService;
import com.itextpdf.kernel.pdf.PdfDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
@RestController
@RequestMapping("template")
public class TemplateController {
    private final TemplateService templateService;
    @Autowired
    public TemplateController(TemplateService  templateService) {
        this.templateService = templateService;
    }
    @GetMapping("/generate")
    public void generateResume() throws IOException {
                templateService.generateResume();
    }
}
