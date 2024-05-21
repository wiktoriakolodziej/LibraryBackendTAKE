package pl.kurs.library.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//import antlr.collections.List;
import java.util.Collections;

@Entity
@Table(name="books")
@XmlRootElement
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String title;
	String authorName;
	String authorSurname;
	int version;
	String description;

	@OneToMany(mappedBy = "book")
	Set<Volume> volumes;
	
	public int getId(){return id;}
	public void setId(int id){this.id = id;}
	
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}
	
	public String getAuthorName(){return authorName;}
	public void setAuthorName(String name){this.authorName = name;}
	
	public String getAuthorSurname(){return authorSurname;}
	public void setAuthorSurname(String surname){this.authorSurname = surname;}
	
	public int getVersion(){return version;}
	public void setVersion(int version){this.version = version;}
	
	public String getDescription(){return description;}
	public void setDescription(String description){this.description = description;}
	
	public Set<Volume> getVolumes() {return volumes;}
	public void setVolumes(Set<Volume> volumes) {this.volumes =  volumes;}
	
}
