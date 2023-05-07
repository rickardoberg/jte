package gg.jte.models.runtime;

import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.WriterOutput;

import java.io.Writer;
import java.util.Map;

public class DynamicJteModel implements JteModel {
    private final TemplateEngine engine;
    private final String name;
    private final Map<String, Object> paramMap;

    public DynamicJteModel(TemplateEngine engine, String name, Map<String, Object> paramMap) {
        this.engine = engine;
        this.name = name;
        this.paramMap = paramMap;
    }

    @Override
    public void render(Writer writer) {
       writeTo(new WriterOutput(writer));
    }

    @Override
    public void writeTo(TemplateOutput output) {
        engine.render(name, paramMap, output);
    }
}
