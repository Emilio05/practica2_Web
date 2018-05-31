import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class FreeMarker {
    public void manejoTemplates(){

        Configuration configuration = new Configuration();

        configuration.setClassForTemplateLoading(FreeMarker.class, "/estudiantes");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        get("/estudiantes", (request, response) -> {
            Estudiante estudiante = new Estudiante(20120994, "emilio", "ferreiras", "8296498970");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);
            return new ModelAndView(attributes, "listadoEstudiantes.ftl");
        }, freeMarkerEngine);
    }
}
