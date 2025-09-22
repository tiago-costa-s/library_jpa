package test;

import entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_db");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Book book = new Book();
		book.setTitle("O minimo que você precisa para não ser um idiota.");
		book.setAuthor("Olavo de Carvalho");

		em.persist(book);
		em.getTransaction().commit();

		System.err.println("Salvo livro com ID: " + book.getId());
		em.close();
		emf.close();
	}

}
