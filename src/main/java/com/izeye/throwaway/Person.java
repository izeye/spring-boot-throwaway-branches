package com.izeye.throwaway;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by izeye on 15. 9. 19..
 */
@Entity
@Document(indexName = "person")
@Data
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	private int age;
	
}
