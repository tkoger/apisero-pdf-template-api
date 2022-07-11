package com.apisero.pdf;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FreeMarkerGenerator {
    private Configuration cfg;
    private Map<String, String> root;

    public FreeMarkerGenerator(Map<String, String> fields) {
        this.setRoot(fields);
        setupConfig();
    }

	@SuppressWarnings("unchecked")
	public FreeMarkerGenerator(TemplateData templateData, String imgSrc) {
        @SuppressWarnings("rawtypes")
		Map root = new HashMap();
        root.put("templateData", templateData);
        root.put("imgSrc", imgSrc);
        this.setRoot(root);
        setupConfig();
    }


    private void setupConfig() {
        Version ourVersion = Configuration.VERSION_2_3_27;
        cfg = new Configuration(ourVersion);
        cfg.setObjectWrapper(new DefaultObjectWrapper(ourVersion));
        cfg.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setOutputEncoding("UTF-8");
        cfg.setLocale(Locale.ENGLISH);
        cfg.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/templates"));
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
    }

    public String generateHTML(String templateName)
            throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        cfg.getTemplate(templateName, Locale.ENGLISH, "UTF-8").process(this.root, stringWriter);
        return stringWriter.toString();
    }

    public void setRoot(Map<String, String> root) {
        this.root = root;
    }
}
