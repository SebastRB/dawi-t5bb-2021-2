package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	
	public static void main(String[] args) {
		   //.1 Especificar la conexion de BD-DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		
		//Procesos...Obtener la informacion de un nuevo usuario
		Usuario u = em.find(Usuario.class, 5);
		if (u==null) {
			System.out.println("Usuario no Existe");
			
		}else {
			System.out.println("usuario Encontrado : "+ u.getNombre());
			System.out.println(u);
		}
		//u.setCodigo(10);
		em.close();
	}
}
