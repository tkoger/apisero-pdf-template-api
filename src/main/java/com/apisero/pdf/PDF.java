package com.apisero.pdf;

import java.io.ByteArrayOutputStream;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import com.openhtmltopdf.util.XRLog;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PDF {

	public static byte[] createPDF(String variable_1, String variable_2) throws IOException, TemplateException {
		XRLog.listRegisteredLoggers().forEach(logger -> XRLog.setLevel(logger, java.util.logging.Level.WARNING));
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("variable_1", variable_1);
        fields.put("variable_2", variable_2);
        FreeMarkerGenerator templateEngine = new FreeMarkerGenerator(fields);
        String html = templateEngine.generateHTML("template1.html");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withHtmlContent(html, null);
        builder.toStream(os);
        builder.run();
        os.close();
        return os.toByteArray();
	}
	
	public static byte[] createPDF(TemplateData templateData, String imgSrc) throws IOException, TemplateException {
		XRLog.listRegisteredLoggers().forEach(logger -> XRLog.setLevel(logger, java.util.logging.Level.WARNING));
        FreeMarkerGenerator templateEngine = new FreeMarkerGenerator(templateData, imgSrc);
        String html = templateEngine.generateHTML("template2.html");
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.useFastMode();
        builder.withHtmlContent(html, null);
        builder.toStream(os);
        builder.run();
        os.close();
        return os.toByteArray();
	}

}