package test;

import java.time.LocalDate;
import java.util.List;

import entities.Book;
import entities.Loan;
import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library_db");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

// Inserir book

//		Book book = new Book();
//		book.setTitle("Jardim das Aflições.");
//		book.setAuthor("Olavo de Carvalho");
//
//		em.persist(book);
//		em.getTransaction().commit();
//
//		System.err.println("Salvo livro com ID: " + book.getId());

//		Inserir User

//		User user = new User();
//		user.setActive(true);
//		user.setName("Tiago Costa");
//		user.setEmail("tiago@gmail.com");
//		user.setPhone("31990908080");
//		user.setAge(33);
//
//		em.persist(user);
//		em.getTransaction().commit();
//
//		System.err.println("Salvo Usuario com ID: " + user.getId());

//		Buscar por um Book
//		Book b1 = em.find(Book.class, 2L);
//		System.out.println("Livro encontrado: " + b1);
////		Buscar por todos os Books
//
//		List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
//		for (Book book : books) {
//			System.out.println(book);		}
//

//		Atualizar dados
//		Book book = em.find(Book.class, 1L);
//		book.setTitle("##O minimo que você precisa para não ser um idiota.");
//
//		em.getTransaction().commit();
//
//		System.out.println("Book atualizado:" + book);

//		Deletar(remover)
//		em.getTransaction().begin();
//		Book book = em.find(Book.class, 1L);
//
//		em.remove(book);
//		em.getTransaction().commit();

//
		User user = em.find(User.class, 1L);
		Book book = em.find(Book.class, 1L);

		Loan loan = new Loan();
		loan.setUser(user);
		loan.setBook(book);
		loan.setLoanDate(LocalDate.now());

		em.persist(loan);
		em.getTransaction().commit();

		em.close();
		emf.close();

	}

}
