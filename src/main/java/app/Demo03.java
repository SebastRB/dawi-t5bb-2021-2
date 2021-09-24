package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		   //.1 Especificar la conexion de BD-DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		
		//Procesos...Eliminar un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(10);
		
		
		// Registrar, Actualizar, Eliminar -> Transacciones
		try{
			em.getTransaction().begin();
		    em.remove(u); //Eliminar
		    em.getTransaction().commit();
		    System.out.println("Eliminado Ok");
		} catch (Exception e) {
			System.out.println("Error : " +e.getClass().getTypeName());
		}
		em.close();
	}

}
