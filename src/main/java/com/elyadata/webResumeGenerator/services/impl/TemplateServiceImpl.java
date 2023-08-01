package com.elyadata.webResumeGenerator.services.impl;

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
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;

@Service
public class TemplateServiceImpl implements TemplateService {
    public static final String IMG="static\\bluee.png";
    @Override
    public void generateResume() throws IOException {

        String path = ".\\first.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        Document document = new Document(pdfDocument) ;
        pdfDocument.setDefaultPageSize(PageSize.A4.rotate());
        pdfDocument.addNewPage() ;

        document.setMargins(0,0,0,0);
        String imgsrc ="static\\elyadata.png";
        ImageData data = null;
        ImageData imageDataa = ImageDataFactory.create(IMG);
        imageDataa.setWidth(40f);
        imageDataa.setHeight(30f);
        try {
            data = ImageDataFactory.create(imgsrc);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        String imagePathh = "static\\bluee.png";
        Image bleue = new Image(ImageDataFactory.create(imagePathh));
        bleue.setWidth(30);
        bleue.setHeight(30);

        bleue.setOpacity(0.3f);



        DeviceRgb white = new DeviceRgb(255,255,255);
        DeviceRgb bleu = new DeviceRgb(5,186,238);
        DeviceRgb rose = new DeviceRgb(214,0,127);

        float col= 422f;
        float columnWidth[] = {col,col};
        Table table = new Table(columnWidth);
        table.setBackgroundColor(new DeviceRgb(0,0,0));
        table.addCell(new Cell().add(new Paragraph("Nom et prenom").setFontSize(20).setFontColor(white).setMarginLeft(60).setBold().setMarginTop(10)).setBorder(Border.NO_BORDER))
                .setHeight(70).setMarginBottom(3);
        table.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("job").setFontColor(bleu).setMarginLeft(60)).setBorder(Border.NO_BORDER));
        table.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));



        float pageWidth = PageSize.A4.getHeight();
        float pageHeight = PageSize.A4.getWidth();
        float middleX = pageWidth / 2;
        float middleY = pageHeight / 2;


        Image image1 = new Image(data);

        for (int j=1;j<3;j++)
        {
            table.setFixedPosition(j,0,524,900);
            image1.setFixedPosition(j,30,10,100);
            document.add(table);
            document.add(image1);

            PdfCanvas canvas = new PdfCanvas(pdfDocument.getPage(j));
            canvas.setStrokeColorRgb(0, 0, 0);
            canvas.moveTo(middleX, 0);
            canvas.lineTo(middleX, pageHeight);
            canvas.stroke();

        }



        int totalParts = 2;
        float partWidth = pdfDocument.getDefaultPageSize().getWidth() / totalParts;
        Rectangle[] partRectangles = new Rectangle[totalParts];
        for (int i = 0; i < totalParts; i++) {

            partRectangles[i] = new Rectangle(i * partWidth+10,40,partWidth-50,430);
        }

        document.setRenderer(new ColumnDocumentRenderer(document, partRectangles));

        List l= new List();
        l.setListSymbol(bleue);
        l.setSymbolIndent(-20);
        l.add("Experience").setFontSize(18).setFontColor(rose).setPaddingLeft(0).setMarginLeft(20);
        document.add(l);


        document.add( new Paragraph("Software Data engineer "+"|"+" ELYADATA").setFontColor(bleu).setMarginLeft(30).setBold().setMarginBottom(0));
        document.add( new Paragraph("March2023-today ").setFontColor(bleu).setMarginLeft(30).setFontSize(8).setMarginTop(0));
        List list1 = new List();
        list1.setListSymbol("        \u2022     ");
        list1.add("Developed RESTful APIs using FastAPI, leveraging its high performance and asynchronous capabilities to deliver efficient and scalable backend services. Implemented authentication and authorization mechanisms, such as JWT tokens and role-based access control, to ensure secure access to APIs.").setFontSize(8).setTextAlignment(TextAlignment.JUSTIFIED);
        list1.add("Utilized databases like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation and serialization using Pydantic to ensure data integrity and consistency.").setFontSize(8).setTextAlignment(TextAlignment.JUSTIFIED);
        document.add(list1);
        document.add( new Paragraph("Software Data engineer  "+"|"+" INFOR").setFontColor(bleu).setMarginLeft(30).setBold().setMarginBottom(0));
        document.add( new Paragraph("March2023-today ").setFontColor(bleu).setMarginLeft(30).setFontSize(8).setMarginTop(0));
        List list2 = new List();
        list2.setListSymbol("        \u2022     ");
        list2.add("Developed RESTful APIs using FastAPI, leveraging its high performance and asynchronous capabilities to deliver efficient and scalable backend services. Implemented authentication and authorization mechanisms, such as JWT tokens and role-based access control, to ensure secure access to APIs.").setFontSize(8).setTextAlignment(TextAlignment.JUSTIFIED);
        list2.add("Utilized databases like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation and serialization using Pydantic to ensure data integrity and consistency.").setFontSize(8);
        document.add(list2);
        document.add( new Paragraph("Development Intern  "+"|"+" ATB").setFontColor(bleu).setMarginLeft(30).setBold().setMarginBottom(0));
        List list3 = new List();
        list3.setListSymbol("        \u2022     ");
        document.add( new Paragraph("March2023-today ").setFontColor(bleu).setMarginLeft(30).setFontSize(8).setMarginTop(0));
        list3.add("Developed RESTful APIs using FastAPI, leveraging its high performance and asynchronous capabilities to deliver efficient and scalable backend services. Implemented authentication and authorization mechanisms, such as JWT tokens and role-based access control, to ensure secure access to APIs.").setFontSize(8).setTextAlignment(TextAlignment.JUSTIFIED);
        list3.add("Utilized databases like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation and serialization using Pydantic to ensure data integrity and consistency.").setFontSize(8);

        document.add(list3);
        List l2= new List();
        l2.setListSymbol(bleue);
        l2.setSymbolIndent(-20);
        l2.add("Education").setFontSize(18).setFontColor(rose).setPaddingLeft(0).setMarginLeft(20).setMarginTop(15);
        document.add(l2);

        document.add(new Paragraph("Contenu de la deuxième partie\n" +
                "Loring iAPI, leveraging its high  ipsum orgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation a like PostgreSQL and MongoDB to store and retrieve data, optimizing queries and database interactions for improved performance. Implemented data validation aea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high  ipsum ore et daliquip ex ea coconse nonstAPI, leveraging its high ped").setMarginLeft(30).setMarginBottom(70).setMarginRight(10).setFontSize(10));
        for (int currentPart = 0; currentPart < totalParts; currentPart++) {
            document.add(new AreaBreak());
        }

        int i =pdfDocument.getNumberOfPages();
        pdfDocument.removePage(i);
        document.close();
    }
}
