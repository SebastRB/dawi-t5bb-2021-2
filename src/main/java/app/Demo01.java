package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	
   public static void main(String[] args) {
	   //.1 Especificar la conexion de BD-DAOFactory
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	
	//2. Obtener el DAO
	EntityManager em = fabrica.createEntityManager();
	
	//Procesos...Registrar un nuevo usuario
	Usuario u = new Usuario();
	u.setCodigo(10);
	u.setNombre("Eren");
	u.setApellido("Ackerman");
	u.setUsuario("tatakae@gmail.com");
	u.setClave("paloma");
	u.setFnacim("2021/08/27");
	u.setTipo(1);
	u.setEstado(1); 
	
	// Registrar, Actualizar, Eliminar -> Transacciones
	try{
		em.getTransaction().begin();
	    em.persist(u); //registrar es Persist
	    em.getTransaction().commit();
	    System.out.println("Registro Ok");
	} catch (Exception e) {
		System.out.println("Error : " +e.getClass().getTypeName());
	}
	em.close();
	
	
}
	
}
