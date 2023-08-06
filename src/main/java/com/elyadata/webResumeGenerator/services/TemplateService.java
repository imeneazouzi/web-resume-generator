package com.elyadata.webResumeGenerator.services;

import com.itextpdf.kernel.pdf.PdfDocument;

import java.io.IOException;

public interface TemplateService {

    void generateResume() throws IOException;
}
