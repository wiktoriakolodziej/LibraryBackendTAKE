package pl.kurs.komis;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import org.hibernate.mapping.Set;

import antlr.collections.List;
import pl.kurs.komis.entities.Car;
import pl.kurs.library.entity.Book;
import pl.kurs.library.entity.Rental;
import pl.kurs.library.entity.Volume;
import pl.kurs.library.entity.Volume.BookCover;
import pl.kurs.library.entity.Volume.Conditionn;

public class Test {
public static void main(String[] args) {
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("komis");
	EntityManager manager = managerFactory.createEntityManager(); 
	manager.getTransaction().begin();
	
	/*Car car = new Car();
	car.setMake("Fiat");
	manager.persist(car); */
	
	Rental rental = new Rental();
	rental.setRentalDate(Date.valueOf("2026-12-12"));
	rental.setDueDate(Date.valueOf("2024-12-23"));
	manager.persist(rental); 
	
	Rental rental2 = new Rental();
	rental2.setRentalDate(Date.valueOf("2026-12-12"));
	rental2.setDueDate(Date.valueOf("2024-12-23"));
	manager.persist(rental2); 
		
	Set<Rental> rentals = new HashSet<Rental>();
	rentals.add(rental);
	rentals.add(rental2);
	
	Book book = new Book();
	book.setAuthorName("Ziutek");
	book.setAuthorSurname("Kogutek");
	book.setTitle("Kubuœ Puchatek");
	book.setVersion(1);
	book.setDescription("Pamparampam");
	manager.persist(book); 
	
	
	Volume volume = new Volume();
	volume.setBookCover(BookCover.hardcover);
	volume.setCondition(Conditionn.good);
	volume.setPages(300);
	volume.setYearOfPublication(1996);
	volume.setBook(book);	
	manager.persist(volume); 

	Set<Volume> volumes = new HashSet<Volume>();
	volumes.add(volume);
	Volume volume2 = new Volume();
	volume2.setPages(200);
	volume2.setBookCover(BookCover.paperback);
	volume2.setCondition(Conditionn.bad);
	volume2.setYearOfPublication(1946);
	volume2.setBook(book);
	manager.persist(volume2); 
	volumes.add(volume2);
	
	rental.setVolumes(volumes);
	rental2.setVolumes(volumes);
	volume.setRentals(rentals);
	volume2.setRentals(rentals);
	manager.persist(rental);
	manager.persist(rental2);
	manager.persist(volume);
	manager.persist(volume2);

	
	manager.getTransaction().commit();
	manager.close();
	managerFactory.close();
	
}
}
