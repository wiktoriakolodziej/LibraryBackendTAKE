package pl.kurs.komis;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import org.hibernate.mapping.Set;

//import antlr.collections.List;
import java.util.Collections;
import pl.kurs.komis.entities.Car;
import pl.kurs.library.entity.Book;
import pl.kurs.library.entity.Reader;
import pl.kurs.library.entity.Rental;
import pl.kurs.library.entity.Volume;
import pl.kurs.library.entity.Volume.BookCover;
import pl.kurs.library.entity.Volume.Conditionn;

public class Test {
public static void main(String[] args) {
	//EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("komis");
	EntityManagerFactory managerFactory = new Persistence().createEntityManagerFactory("komis");
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
	book.setTitle("Kubu� Puchatek");
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
	
	Set<Reader> readers = new HashSet<Reader>();
	Reader reader1 = new Reader();
    reader1.setReaderName("Jan");
    reader1.setReaderSurname("Kowalski");
    reader1.setBirthDate(Date.valueOf("1990-05-15"));
    reader1.setJoiningDate(Date.valueOf("2020-01-01"));
    reader1.setPenalty(0.0f);
    manager.persist(reader1);
    
    Reader reader2 = new Reader();
    reader2.setReaderName("Anna");
    reader2.setReaderSurname("Nowak");
    reader2.setBirthDate(Date.valueOf("1985-10-20"));
    reader2.setJoiningDate(Date.valueOf("2018-03-15"));
    reader2.setPenalty(5.0f);
    manager.persist(reader2);
  
    readers.add(reader1);
    readers.add(reader2);
    
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
