
import static spark.Spark.*;


public class Main {

    public static void main(String[] args) {

        new ControladorEstudiante(new ServicioEstudiante());
    }
}
