package pl.kurs.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reader {
	
	int id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId(){return id;}
	public void setId(int id){this.id = id;}

}
