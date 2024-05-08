package pl.kurs.komis;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.kurs.komis.entities.Car;
import pl.kurs.library.entity.Rental;

public class Test {
public static void main(String[] args) {
	EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("komis");
	EntityManager manager = managerFactory.createEntityManager(); 
	manager.getTransaction().begin();
	
	Car car = new Car();
	car.setMake("Fiat");
	manager.persist(car);
	
	Rental rental = new Rental();
	rental.setRentalDate(Date.valueOf("2024-12-12"));
	rental.setDueDate(Date.valueOf("2024-12-23"));
	manager.persist(rental);
	
	
	
	manager.getTransaction().commit();
	manager.close();
	managerFactory.close();
	
}
}
