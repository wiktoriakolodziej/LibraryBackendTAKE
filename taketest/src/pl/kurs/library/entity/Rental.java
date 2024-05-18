package pl.kurs.library.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import antlr.collections.List;

@Entity
@Table(name="rentals")
@XmlRootElement
public class Rental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Temporal(TemporalType.DATE)
	@Column(updatable = false, nullable = false)
	Date rentalDate;
	@Temporal(TemporalType.DATE)
	Date returnDate;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	Date dueDate;
	@ManyToOne
	@JoinColumn(name = "reader_id")
	Reader reader;

	@ManyToMany(targetEntity = Volume.class)
	@JoinTable(
			name = "rental_volumes",
			joinColumns = @JoinColumn(name = "rental_id"),
			inverseJoinColumns = @JoinColumn(name = "volume_id"))
	Set<Volume> volumes;
	

	public int getId(){return id;}
	public void setId(int id){this.id = id;}
	
	public Date getRentalDate(){return rentalDate;}
	public void setRentalDate(Date rentalDate){this.rentalDate = rentalDate;}
	
	public Date getReturnDate(){return returnDate;}
	public void setReturnDate(Date returnDate){this.returnDate = returnDate;}
	
	public Date getDueDate(){return dueDate;}
	public void setDueDate(Date dueDate){this.dueDate = dueDate;}
	
	public Reader getReader(){return reader;}
	public void setReader(Reader reader){this.reader = reader;}

	public Set<Volume> getVolumes(){return volumes;}
	public void setVolumes(Set<Volume> volumes){this.volumes = volumes;}

}
