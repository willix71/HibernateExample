package com.multibag.sets;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

/**
 * Check http://blog.eyallupu.com/2010/06/hibernate-exception-simultaneously.html
 * and http://www.jroller.com/eyallupu/entry/solving_simultaneously_fetch_multiple_bags
 * 
 * @author wkeyser
 *
 */
@Entity
@Table(name = "parent", schema = "multibag")
public class Parent {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "NAME", unique = true, nullable = false, length = 20)
	private String name;
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@IndexColumn(name="INDEX_COL")
	// or used Sets	
	List<Child1> child1s = new ArrayList<Child1>();
	
	@OneToMany(mappedBy="parent",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@IndexColumn(name="INDEX_COL")
	// or used Sets
	List<Child2> child2s = new ArrayList<Child2>();

	public Parent() {}
	public Parent(String name) {this.name = name;}
	
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public List<Child1> getChild1s() {return child1s;}
	public void setChild1s(List<Child1> child1s) {this.child1s = child1s;}
	public void addChild1(Child1 child) {
		this.child1s.add(child);
		child.setParent(this);
		child.setIndexId(child1s.size()-1);
	}
	
	public List<Child2> getChild2s() {return child2s;}
	public void setChild2s(List<Child2> child2s) {this.child2s = child2s;}

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
		Parent other = (Parent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + "]";
	}
}
