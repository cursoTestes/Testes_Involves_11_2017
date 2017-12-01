package br.com.k21.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.k21.Cliente;

public class ClienteDAO {

	@PersistenceContext(unitName = "JPA")
	private static EntityManager entityManager;

	public void salvarClientes(List<Cliente> clientes) {

		for (Cliente cliente : clientes) {
				salvarCliente(cliente);
		}
	}

	public void salvarCliente(Cliente cliente) {
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();
	}

	public static void remove(long id) {
		entityManager.remove(find(id));
	}

	public static Cliente find(long id) {
		return entityManager.find(Cliente.class, new Long(id));
	}

	public static List<Cliente> findAll() {
		return entityManager.createQuery("select c from Cliente c").getResultList();
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void setEntityManager(EntityManager entityManager) {
		ClienteDAO.entityManager = entityManager;
	}
}
