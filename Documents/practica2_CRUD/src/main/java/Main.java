import freemarker.template.Configuration;
import spark.Service;
import spark.Service.StaticFiles;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.debug.DebugScreen.enableDebugScreen;

public class Main {

    public static void main(String[] args) {
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Main.class, "/");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        enableDebugScreen();

        new RutasEstudiante(new ServicioEstudiante(), freeMarkerEngine);
//        new FreeMarker().manejoTemplates();
    }
}
