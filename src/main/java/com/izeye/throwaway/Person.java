package com.izeye.throwaway;

import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement(localName = "person")
// Make this use camelCase.
@JsonNaming
public class Person {

	private String firstName;
	private String lastName;
	private int age;

}
