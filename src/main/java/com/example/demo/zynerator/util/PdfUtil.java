package com.example.demo.zynerator.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;


public class PdfUtil {


    public static HttpEntity<byte[]> createPdf(String fileName, String templatePath, Map<String, String> data) throws IOException {


        /* first, get and initialize an engine */
        VelocityEngine ve = new VelocityEngine();

        /* next, get the Template */
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate(templatePath);
        /* create a context and add data */
        VelocityContext context = new VelocityContext();
        data.forEach((k, v) -> context.put(k, v));
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        /* show the World */
        System.out.println(writer.toString());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos = generatePdf(writer.toString());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + fileName.replace(" ", "_"));
        header.setContentLength(baos.toByteArray().length);

        return new HttpEntity<byte[]>(baos.toByteArray(), header);

    }

    private static ByteArrayOutputStream generatePdf(String html) {

        String pdfFilePath = "";
        PdfWriter pdfWriter = null;

        // create a new document
        Document document = new Document();
        try {

            document = new Document();
            // document header attributes
            document.addAuthor("zynerator");
            document.addAuthor("zynerator123");
            document.addCreationDate();
            document.addProducer();
            document.addCreator("zynerator123.github.io");
            document.addTitle("HTML to PDF using itext");
            document.setPageSize(PageSize.LETTER);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);

            // open document
            document.open();

            XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
            xmlWorkerHelper.getDefaultCssResolver(true);
            xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));
            // close the document
            document.close();
            System.out.println("PDF generated successfully");

            return baos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static <T> HttpEntity<byte[]> createPdf(String generatedfileName, String templatePath, String key, Map<String, String> data) throws IOException {


        /* first, get and initialize an engine */
        VelocityEngine ve = new VelocityEngine();

        /* next, get the Template */
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
        Template t = ve.getTemplate(templatePath);
        /* create a context and add data */
        VelocityContext context = new VelocityContext();
        data.forEach((k, v) -> context.put(k, v));
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        /* show the World */
        System.out.println(writer.toString());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos = generatePdf(writer.toString());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + "my-generated-pdf");
        header.setContentLength(baos.toByteArray().length);

        return new HttpEntity<byte[]>(baos.toByteArray(), header);

    }

    @GetMapping("/msg")
    public String printMesssage() {
        return "this is the message";
    }
}