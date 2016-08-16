package com.izeye.throwaway;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import lombok.Data;

/**
 * Person.
 *
 * @author Johnny Lim
 */
@Entity
@Table(name = "person")
@SecondaryTables(
		@SecondaryTable(
				name = "person_name",
				pkJoinColumns = {
						@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
				}
		)
)
@Data
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(table = "person_name")
	private String firstName;
	@Column(table = "person_name")
	private String lastName;

	private int age;
	
}
