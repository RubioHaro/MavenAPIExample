package mx.com.ipn.escom.roy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/alumnos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AlumnoService {
	private static Map<Integer, Alumno> alumnos = new HashMap<>();
	
	static {
		Alumno Roy =  new Alumno(2015090680,"Rodrigo Rodolfo", "Rubio Haro", "ESCOM","Sistemas Computacionales", "chavo0022009@gmail.com");
		alumnos.put(1, Roy);
	}
	
	@GET
	public List<Alumno> getAllAlumnos(){
		return new ArrayList<Alumno>(alumnos.values());
	}
	
	/**
	 * Metodo para guardar un nuevo alumno
	 * @param alumno
	 * 
	 */
	
	@POST
	public void AddAlumno(Alumno alumno) {
		alumnos.put(alumnos.size()+1, alumno);
	}
	
	@DELETE
	@Path("/{alumnoId}")
	private void DeleteAlumno(@PathParam("alumnoId") int id) {
		alumnos.remove(id);
		System.out.println("Eliminado");
	}
}
