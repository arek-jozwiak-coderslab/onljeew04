package pl.coderslab;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("pl"));

//        String name = faker.name().fullName(); // Miss Samanta Schmidt
//        System.out.println(name);
//        String firstName = faker.name().firstName(); // Emory
//        System.out.println(firstName);
//
//        String lastName = faker.name().lastName(); // Barton
//        System.out.println(lastName);
//
//        String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
//        System.out.println(streetAddress);

        String fact = faker.chuckNorris().fact();
        System.out.println(fact);
    }
}
