package com.izeye.throwaway.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.JsonNodeValueResolver;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * {@link Controller} for home.
 *
 * @author Johnny Lim
 */
@Controller
@RequestMapping(path = "/")
public class HomeController {

    @Autowired
    private Handlebars handlebars;

    @GetMapping(value = "/homeJson")
    @ResponseBody
    public String homeJson() {
        String json = "{\"title\":\"Mr.\",\"name\":\"ABC\",\"address\":{\"address1\":\"address1\",\"address2\":\"address2\",\"city\":\"XYZ\",\"state\":\"State1\"}}";

        try {
            JsonNode jsonNode = new ObjectMapper().readValue(json, JsonNode.class);
            Template template = this.handlebars.compile("home");
            Context context = Context.newBuilder(jsonNode)
                    .resolver(JsonNodeValueResolver.INSTANCE, MapValueResolver.INSTANCE).build();
            return template.apply(context);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @GetMapping(value = "/homeObject")
    @ResponseBody
    public String homeObject() {
        Person person = new Person();
        person.setTitle("Mr.");
        person.setName("ABC");

        Address address = new Address();
        address.setAddress1("address1");
        address.setAddress2("address2");
        address.setCity("XYZ");
        address.setState("State1");
        person.setAddress(address);

        try {
            Template template = this.handlebars.compile("home");
            Context context = Context.newBuilder(person)
                    .resolver(JavaBeanValueResolver.INSTANCE).build();
            return template.apply(context);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Data
    private static class Person {

        private String title;
        private String name;
        private Address address;
    }

    @Data
    private static class Address {

        private String address1;
        private String address2;
        private String city;
        private String state;

    }

}
