package com.elyadata.webResumeGenerator.services.impl;

import com.elyadata.webResumeGenerator.dto.ParametersDTO;
import com.elyadata.webResumeGenerator.dto.ResumeDTO;
import com.elyadata.webResumeGenerator.dto.SectionDTO;
import com.elyadata.webResumeGenerator.execption.NotFoundException;
import com.elyadata.webResumeGenerator.mapper.ResumeMapper;
import com.elyadata.webResumeGenerator.model.Parameters;
import com.elyadata.webResumeGenerator.model.Resume;
import com.elyadata.webResumeGenerator.model.Section;
import com.elyadata.webResumeGenerator.utils.Constants;
import com.elyadata.webResumeGenerator.repo.ResumeRepository;
import com.elyadata.webResumeGenerator.services.TemplateService;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {
    private final ResumeRepository resumeRepository;
    private final ResumeMapper resumeMapper;
    DeviceRgb white = new DeviceRgb(255, 255,255);
    DeviceRgb blue = new DeviceRgb(5, 186, 238);
    DeviceRgb pink = new DeviceRgb(214, 0, 127);

    /**
     * Creates a header table with specified title and formatting.
     *
     * @param title The title to be displayed in the header table.
     * @return A Table object representing the header table.
     */

    private Table header(String title) {
        float col = 422f;
        float[] columnWidth = {col, col};
        Table table = new Table(UnitValue.createPointArray(columnWidth));
        table.setBackgroundColor(new DeviceRgb(0, 0, 0));
        table.addCell(new Cell().add(new Paragraph("Nom et prenom").setFontSize(20).setFontColor(white).setMarginLeft(60).setBold().setMarginTop(10)).setBorder(Border.NO_BORDER)).setHeight(70).setMarginBottom(3).setMinHeight(80);
        table.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph(title).setFontColor(blue).setMarginLeft(60)).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        return table;
    }

    /**
     * Draws a vertical line at the middle of the specified page in the PdfDocument.
     *
     * @param pdfDocument The PdfDocument to which the vertical line will be drawn.
     * @param pageNumber  The page number of the PdfDocument where the line will be drawn.
     *                    The first page is represented by pageNumber = 1.
     */
    private void drawMiddleLines(PdfDocument pdfDocument, int pageNumber) {
        float pageWidth = PageSize.A4.getHeight();
        float pageHeight = PageSize.A4.getWidth();
        float middleX = pageWidth / 2;


        PdfCanvas canvas = new PdfCanvas(pdfDocument.getPage(pageNumber));
        canvas.setStrokeColorRgb(0, 0, 0);
        canvas.moveTo(middleX, 0);
        canvas.lineTo(middleX, pageHeight);
        canvas.stroke();
    }

    /**
     * Adds a list item to the Document with the specified title, place, date range, and summary.
     *
     * @param document  The Document to which the list item will be added.
     * @param title     The title of the list item.
     * @param place     The place associated with the list item.
     * @param startDate The start date of the list item (can be null).
     * @param endDate   The end date of the list item (can be null).
     * @param summary   The summary content to be added as a list in the Document (can be null).
     */
    private void addListItem(Document document, String title, String place, LocalDate startDate, LocalDate endDate, String summary,String description) {
        if (title != null) {

            if (place != null) {
                document.add(new Paragraph(title + "  |  " + place).setFontColor(blue).setMarginLeft(30).setBold().setMarginBottom(0));
            }

            else if (summary != null) {
                document.add(new Paragraph(title + "  |  " + summary).setFontColor(blue).setMarginLeft(30).setBold().setMarginBottom(0));
            }
            else {
                document.add(new Paragraph(title).setFontColor(blue).setMarginLeft(30).setBold().setMarginBottom(0));
            }
        }
        if (startDate != null && endDate != null) {
            document.add(new Paragraph(startDate + " - " + endDate).setFontColor(blue).setMarginLeft(30).setFontSize(8).setMarginTop(0));
        }
        if (description != null) {
            List list = new List();
            list.setListSymbol("        •     ");

            String[] descriptionLines = description.split("•");
            for (String line : descriptionLines) {
                if (!line.trim().isEmpty()) {
                    list.add(line.trim()).setFontSize(8).setTextAlignment(TextAlignment.JUSTIFIED);
                }
            }

            document.add(list);
        }

    }

    /**
     * Calculates an array of Rectangle objects representing the parts (columns) of a document.
     *
     * @param partWidth The width of each part (column) to be calculated.
     * @return An array of Rectangle objects representing the parts (columns) of a document.
     */
    private Rectangle[] calculatePartRectangles(float partWidth) {
        int totalParts = 2;
        Rectangle[] partRectangles = new Rectangle[totalParts];
        for (int i = 0; i < totalParts; i++) {
            partRectangles[i] = new Rectangle(i * partWidth + 10, 40, partWidth - 50, 430);
        }
        return partRectangles;
    }
    /**
     * Renders sections of the Resume in different parts (columns) of the Document.
     *
     * @param document       The Document to which the sections will be rendered.
     * @param resume         The Resume object containing the sections to be rendered.
     * @param imageSymbol    The Image object representing the symbol to be used for section names.
     * @param partRectangles An array of Rectangle objects representing each part (column) of the Document.
     *                       The sections will be rendered in these different parts to create columns.
     */
    private void renderSectionsInParts(Document document, ResumeDTO resume, Image imageSymbol, Rectangle[] partRectangles) {
        for (SectionDTO section : resume.getSections()) {
            List l = new List();
            l.setListSymbol(imageSymbol);
            l.setSymbolIndent(-20);
            l.add(section.getName()).setFontSize(18).setFontColor(pink).setPaddingLeft(0).setMarginLeft(20);
            document.add(l);
            if (!section.getParameters().isEmpty()) {
                for (ParametersDTO parameter : section.getParameters()) {
                    addListItem(document, parameter.getTitle(), parameter.getPlace(), parameter.getStartDate(), parameter.getEndDate(), parameter.getSummary(),parameter.getDescription());
                }
            }
            document.add(new Paragraph("\n"));
        }
        addAreaBreaks(document, partRectangles.length);
    }

    /**
     * Adds area breaks to the Document to create separation between sections.
     *
     * @param document    The Document to which area breaks will be added.
     * @param totalBreaks The total number of area breaks to be added.
     *                    Each break creates separation between different sections of the Document.
     */
    private void addAreaBreaks(Document document, int totalBreaks) {
        for (int currentPart = 0; currentPart < totalBreaks; currentPart++) {
            document.add(new AreaBreak());
        }
    }

    /**
     * Splits the Document into two columns and renders the resume content in each part.
     *
     * @param document    The Document to be split and rendered.
     * @param resume      An optional Resume object containing the content to be rendered.
     *                    If present, the resume content will be split into two columns.
     * @param imageSymbol The Image object representing the symbol to be included in the rendering.
     */
    private void splitInTwo(Document document, ResumeDTO resume, Image imageSymbol) {

            int totalParts = 2;
            float partWidth = document.getPdfDocument().getDefaultPageSize().getWidth() / totalParts;
            Rectangle[] partRectangles = calculatePartRectangles(partWidth);

            document.setRenderer(new ColumnDocumentRenderer(document, partRectangles));

            renderSectionsInParts(document, resume, imageSymbol, partRectangles);

    }

    /**
     * The given PdfDocument contains an unnecessary page that needs to be removed,this function proceed to delete the last page from the document.
     *
     * @param pdfDocument The PdfDocument from which the last page will be removed.
     */
    private void removeLastPage(PdfDocument pdfDocument) {
        int lastPageIndex = pdfDocument.getNumberOfPages();
        pdfDocument.removePage(lastPageIndex);
    }

    /**
     * Repeats a template consisting of a Table and an Image on multiple pages within the Document.
     *
     * @param table       The Table object representing the template's table content.
     * @param image       The Image object representing the template's image content.
     * @param document    The Document where the template will be repeated on multiple pages.
     * @param pdfDocument The PdfDocument associated with the Document.
     */
    private void repeatTemplateOnMultiplePages(Table table, Image image, Document document, PdfDocument pdfDocument) {
        for (int j = 1; j < 3; j++) {
            table.setFixedPosition(j, 0, 524, 900);
            image.setFixedPosition(j, 30, 10, 100);
            document.add(table);
            document.add(image);

            drawMiddleLines(pdfDocument, j);
        }
    }

    /**
     * Creates an instance of the Image object with the specified parameters.
     *
     * @param imagePath The path to the image to be loaded.
     * @param width     The desired width of the image.
     * @param height    The desired height of the image.
     * @param opacity   The desired opacity of the image (ranging from 0.0 to 1.0, inclusive).
     * @return The Image object created with the specified properties.
     * @throws MalformedURLException If the image path is malformed.
     */
    private Image createImage(String imagePath, float width, float height, float opacity) throws MalformedURLException {
        ImageData imageData = ImageDataFactory.create(imagePath);
        Image image = new Image(imageData);

        image.setWidth(width);
        image.setHeight(height);
        image.setOpacity(opacity);

        return image;
    }


    @Override
    public void generateResume() throws IOException {


        try (PdfWriter pdfWriter = new PdfWriter(Constants.TEMPLATE_FILE_PATH); PdfDocument pdfDocument = new PdfDocument(pdfWriter); Document document = new Document(pdfDocument)) {

            pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
            pdfDocument.addNewPage();

            Image elyadataImg = createImage(Constants.IMG_SRC, Constants.WIDTH_OF_ELYADATA_IMG, Constants.HEIGHT_OF_ELYADATA_IMG, Constants.OPACITY_OF_ELYADATA_IMG);
            Image sectionSymbole = createImage(Constants.IMAGE_PATH, Constants.WIDTH_OF_SYMBOL_SECTION_IMG, Constants.HEIGHT_OF_SYMBOL_SECTION_IMG, Constants.OPACITY_OF_SYMBOL_SECTION_IMG);
            ResumeDTO resume =resumeMapper.toDto(resumeRepository.findById(2l)
                    .orElseThrow(() -> new NotFoundException("resumeDto with id was not found")));

            String title = resume.getTitle();
            Table table = header(title);

            repeatTemplateOnMultiplePages(table, elyadataImg, document, pdfDocument);
            splitInTwo(document, resume, sectionSymbole);
            removeLastPage(pdfDocument);

        }
    }
}
