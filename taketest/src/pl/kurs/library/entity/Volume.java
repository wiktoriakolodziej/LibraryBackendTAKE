package pl.kurs.library.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import antlr.collections.List;

@Entity
public class Volume {
	@Id
	int id;
//	@ManyToMany(mappedBy = "contents")
//	List rentals = (List) new ArrayList<Rental>();
	
	public int getId(){return id;}
	public void setId(int id){this.id = id;}
//	public List getRentals(){return rentals;}
//	public void setRentals(List rentals){this.rentals = rentals;}

}
