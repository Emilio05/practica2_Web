
import com.google.gson.Gson;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class RutasEstudiante {
    public RutasEstudiante(final ServicioEstudiante servicioEstudiante, final FreeMarkerEngine freeMarkerEngine){
        get("/estudiantes", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiantes", servicioEstudiante.obtenerTodosEstudiantes());

            return new ModelAndView(attributes, "listadoEstudiantes.ftl");
        }, freeMarkerEngine);

        get("/estudiante/nuevo", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            return new ModelAndView(attributes, "formulario.ftl");
        }, freeMarkerEngine);

        post("/estudiante/nuevo", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");

            servicioEstudiante.crearEstudiante(matricula, nombre, apellido, telefono);

            response.redirect("/estudiantes");

            return null;
        });

        get("/estudiante/editar/:matricula", (request, response) -> {
            int matricula = Integer.parseInt(request.params("matricula"));

            Estudiante estudiante = servicioEstudiante.obtenerEstudiante(matricula);

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "editar.ftl");
        }, freeMarkerEngine);

        post("/estudiante/editar/:matricula", (request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");

            servicioEstudiante.actualizarEstudiante(matricula, nombre, apellido, telefono);

            response.redirect("/estudiantes");

            return null;
        });

        //Borrar
        get("/estudiante/borrar/:matricula", (request, response) -> {

            int matricula = Integer.parseInt(request.params(":matricula"));

            Estudiante estudiante = servicioEstudiante.obtenerEstudiante(matricula);

            if (estudiante != null){
                servicioEstudiante.eliminarEstudiante(matricula);
            }

            response.redirect("/estudiantes");

            return null;

        },freeMarkerEngine);
    }

    private static Estudiante convertirJsonEstudiante(String info) {
        Estudiante estudiante= null;
        try {
            estudiante= new Gson().fromJson(info, Estudiante.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiante;
    }
}
