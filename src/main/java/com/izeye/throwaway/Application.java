package com.izeye.throwaway;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Created by izeye on 15. 9. 19..
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		try {
			ClassPath classPath = ClassPath.from(Application.class.getClassLoader());
			ImmutableSet<ClassPath.ClassInfo> classes = classPath.getTopLevelClasses("com.izeye.throwaway");
			System.out.println("classes: " + classes);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		SpringApplication.run(Application.class, args);
	}
	
}
