package pl.coderslab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.coderslab.dto.CategoryDTO;

@Entity
@Table(name ="category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    public Category(String name, String description) {
	this.name = name;
	this.description = description;
    }

    public Category(Long id, String name, String description) {
	this.id = id;
	this.name = name;
	this.description = description;
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public CategoryDTO toDto() {
	
   	return new CategoryDTO(getId(), getName(), getDescription());
   	
   	
       }
    
    

}
