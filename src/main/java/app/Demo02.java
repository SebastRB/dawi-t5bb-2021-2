package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		   //.1 Especificar la conexion de BD-DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		
		//Procesos...Actualizar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(10);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("tatakae@gmail.com");
		u.setClave("Titan");
		u.setFnacim("2010/08/27");
		u.setTipo(1);
		u.setEstado(1);
		
		// Registrar, Actualizar, Eliminar -> Transacciones
		try{
			em.getTransaction().begin();
		    em.merge(u); //Actualizar es Merge -> si existe codigo actualiza, si no existe lo crea
		    em.getTransaction().commit();
		    System.out.println("Actualizado Ok");
		} catch (Exception e) {
			System.out.println("Error : " +e.getClass().getTypeName());
		}
		em.close();
	}
	
}
