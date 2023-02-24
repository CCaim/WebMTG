package main.crud;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import main.util.JPAUtil;



public class GenericDAO<T> {
	
private Class<T> type;
	
	public GenericDAO(Class<T> mitipo) {
		
		type=mitipo;
	}
	
	
	
	public void insertarRegistroJPA(T registro) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(registro);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.clear();
		}

	}
	
	

	public void modificarRegistroJPA(T registro) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(registro);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

	}
	
	
	
	public void deleteRegistro(T registro) {
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();

			em.remove(em.contains(registro) ? registro : em.merge(registro));

			em.getTransaction().commit();
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}
	}
	
	
	

	@SuppressWarnings("unchecked")
	public ArrayList<T> listarRegistros(String tabla) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			ArrayList<T> misRegistros = (ArrayList<T>) em.createQuery("from "+tabla).getResultList();
			em.getTransaction().commit();
			return misRegistros;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

		return null;

	}

	public void imprimirRegistros(ArrayList<T> misRegistros) {
		System.out.println("Listado de Registros");
		for (T a : misRegistros) {
			System.out.println(a.toString());
		}
	}
	
	
	
	
	
	
	public T buscarPorId(int id) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			T Registro = (T) em.find(type, id);
			System.out.println("El Registro buscado se llama: " + Registro);
			return Registro;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		} finally {
			em.close();
		}

		return null;
	}


}
