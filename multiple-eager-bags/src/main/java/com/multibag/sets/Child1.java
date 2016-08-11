package com.multibag.sets;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "child1", schema = "multibag")
public class Child1 {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 20)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="Parent_ID")
    private Parent parent;

	public Child1() {}
	public Child1(String name) {this();this.name = name;}
	public Child1(String name, Parent parent) {this(name);this.parent = parent;}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	@Column(name = "INDEX_COL", nullable = false)
	private Integer indexId;
	public Integer getIndexId() {return indexId;}
	public void setIndexId(Integer indexId) {this.indexId = indexId;}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Child1 other = (Child1) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Child1 [id=" + id + ", name=" + name + "]";
	}

}
