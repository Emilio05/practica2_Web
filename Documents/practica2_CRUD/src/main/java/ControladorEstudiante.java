
import com.google.gson.Gson;

import static spark.Spark.*;


public class ControladorEstudiante {

    public ControladorEstudiante(final ServicioEstudiante servicioEstudiante){

        get("/estudiantes", (request, response) ->
                servicioEstudiante.obtenerTodosEstudiantes(), new JsonTransformer());



        get("/estudiantes/:matricula", (request, response) -> {

            int matricula = Integer.parseInt(request.params(":matricula"));

            Estudiante estudiante = servicioEstudiante.obtenerEstudiante(matricula);
            if(estudiante != null){
                return estudiante;
            }

            response.status(400);
            return "El estudiante con la matricula '" + matricula + "' no existe";
        }, new JsonTransformer());


        post("/estudiantes", (request, response) -> {

            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");
            String info = request.body();

            Estudiante estudiante = convertirJsonEstudiante(info);
            if(estudiante != null){
                matricula = estudiante.getMatricula();
                nombre = estudiante.getNombre();
                apellido = estudiante.getApellido();
                telefono = estudiante.getTelefono();
            }
            return servicioEstudiante.crearEstudiante(matricula, nombre, apellido, telefono);

        }, new JsonTransformer());

        put("/estudiantes/:matricula", (request, response) -> {

            int matricula = Integer.parseInt(request.params(":matricula"));
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String telefono = request.queryParams("telefono");

            Estudiante estudiante = convertirJsonEstudiante(request.body());
            if (estudiante != null){
                matricula = estudiante.getMatricula();
                nombre = estudiante.getNombre();
                apellido = estudiante.getApellido();
                telefono = estudiante.getTelefono();
            }

            Estudiante estudiante1 = servicioEstudiante.obtenerEstudiante(matricula);

            if (estudiante1 != null){

                return servicioEstudiante.actualizarEstudiante(matricula, nombre, apellido, telefono);
            }

            response.status(400);

            return "El estudiante con la matricula '" + matricula + "' no existe";


        }, new JsonTransformer());


        delete("/estudiantes/:matricula", (request, response) -> {

            int matricula = Integer.parseInt(request.params(":matricula"));

            Estudiante estudiante = servicioEstudiante.obtenerEstudiante(matricula);
            if (estudiante != null){
                servicioEstudiante.eliminarEstudiante(matricula);
                response.status(200);
                return "El estudiante con la matricula '" + matricula + "' fue eliminando";
            }

            response.status(400);
            return "El estudiante con la matricula '" + matricula + "' no existe";

        }, new JsonTransformer());


        
        after((request, response) -> {
            response.type("application/json");
        });


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
