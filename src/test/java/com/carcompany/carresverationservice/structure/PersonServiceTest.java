package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.personservice.structure.LegalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.NaturalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.personservice.structure.exception.TooFewOrManyParametersForPersonCreationException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    private static PersonService personService;
    private static String firstname;
    private static String lastname;
    private static String companyName;

    @BeforeAll
    static void setupBeforeClass() {
        personService = PersonService.getInstance();
        firstname = "Jane";
        lastname = "Doe";
        companyName = "CineCar GmbH";
    }

    @AfterAll
    static void tearDownAfterClass() {
        personService = null;
        firstname = null;
        lastname = null;
        companyName = null;
    }

    @Test
    @Order(1)
    public void canCreateLegalPerson() {
        assertDoesNotThrow(() -> {
            personService.createPerson(companyName);
        });

        assertThrows(TooFewOrManyParametersForPersonCreationException.class, () -> {
            personService.createPerson();
        });

        assertTrue(personService.createPerson(companyName) instanceof LegalPerson);
    }

    @Test
    @Order(2)
    public void canCreateNaturalPerson() {
        assertDoesNotThrow(() -> {
            personService.createPerson(firstname, lastname);
        });

        assertThrows(TooFewOrManyParametersForPersonCreationException.class, () -> {
            personService.createPerson(firstname, lastname, null);
        });

        assertTrue(personService.createPerson(firstname, lastname) instanceof NaturalPerson);
    }

    @Test
    @Order(3)
    public void canGetNaturalPerson() {
        assertDoesNotThrow(() -> {
            Person person = personService.createPerson(firstname, lastname);
            assertNotNull(personService.getPerson(person.getId()));
        });
    }

    @Test
    @Order(4)
    public void canGetLegalPerson() {
        assertDoesNotThrow(() -> {
            Person person = personService.createPerson(companyName);
            assertNotNull(personService.getPerson(person.getId()));
        });
    }

    @Test
    @Order(4)
    public void canPersonBeDeleted() {
        assertDoesNotThrow(() -> {
            Person person = personService.createPerson(companyName);
            assertDoesNotThrow(() -> personService.deletePerson(person.getId()));
        });
    }
}
