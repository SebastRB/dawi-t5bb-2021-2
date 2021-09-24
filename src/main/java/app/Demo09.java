package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo09 {

	public static void main(String[] args) {
		   //.1 Especificar la conexion de BD-DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();
		
		//Procesos...Obtener la informacion de un nuevo usuario
		//Usuario u = em.find(Usuario.class, 5); //Busaca segun la pk
		//Validar usando Usuario y Clave
		String sql = "{call usp_validaAcceso (?,?)}";
     //TypedQuery<Usuario> query3 = em.createQuery(sql,Usuario.class); JPA 
    
	 Query query3 = em.createNativeQuery(sql, Usuario.class); //como si fuera object
     query3.setParameter(1,"U002@gmail.com");
     query3.setParameter(2,"10002");
		
     
     
     
     Usuario u = null;
		try {
			u = (Usuario) query3.getSingleResult();
			
		} catch (NoResultException e) {
			
		}
     
     
		if (u == null) {
			System.out.println("Usuario no Existe");
			
		}else {
			System.out.println("usuario Encontrado : "+ u.getNombre());
			System.out.println(u);
		}
		//u.setCodigo(10);
		em.close();
	}
}
