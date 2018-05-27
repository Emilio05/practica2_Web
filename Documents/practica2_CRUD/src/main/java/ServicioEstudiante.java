import java.util.LinkedList;
import java.util.List;

public class ServicioEstudiante {

    private static List<Estudiante> estudiantes;

    public ServicioEstudiante(){

        //Prueba
        estudiantes = new LinkedList<Estudiante>();
        estudiantes.add(new Estudiante(20120994, "Emilio", "Ferreiras", "829-649-8970"));
    }

    public List<Estudiante> obtenerTodosEstudiantes(){

        return estudiantes;
    }

    public Estudiante obtenerEstudiante(int matricula){

        Estudiante estudiante = null;

        for(Estudiante estudiante1 : estudiantes){

            if(estudiante1.getMatricula() == matricula){

                estudiante = estudiante1;
            }
        }

        return estudiante;
    }

    public Estudiante crearEstudiante(int matricula, String nombre, String apellido, String telefono){

        Estudiante estudiante = new Estudiante(matricula, nombre, apellido, telefono);

        estudiantes.add(estudiante);

        return estudiante;
    }

    public Estudiante actualizarEstudiante(int matricula, String nombre, String apellido, String telefono){

        Estudiante estudiante = null;

        for(Estudiante estudiante1 : estudiantes){

            if(estudiante1.getMatricula() == matricula){

                estudiante1.setNombre(nombre);
                estudiante1.setApellido(apellido);
                estudiante1.setTelefono(telefono);

                estudiante = estudiante1;
            }
        }

        return estudiante;
    }

    public void eliminarEstudiante(int matricula){

        Estudiante estudiante = null;

        for(Estudiante estudiante1 : estudiantes){

            if(estudiante1.getMatricula() == matricula){

                estudiante = estudiante1;
            }
        }

        if(estudiante != null){

            estudiantes.remove(estudiante);
        }
    }


}
