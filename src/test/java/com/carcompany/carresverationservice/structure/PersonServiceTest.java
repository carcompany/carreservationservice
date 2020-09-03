package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonServiceImplementation;
import com.carcompany.carreservationservice.structure.personservice.structure.LegalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.NaturalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.exception.TooFewOrLessParametersForPersonCreationException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    private static PersonService personService;
    private static String firstname;
    private static String lastname;
    private static String companyName;

    @BeforeAll
    static void setupBeforeClass() {
        personService = new PersonServiceImplementation();
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
    public void canCreateLegalPerson() {
        assertDoesNotThrow(() -> {
            personService.createPerson(companyName);
        });

        assertThrows(TooFewOrLessParametersForPersonCreationException.class, () -> {
            personService.createPerson();
        });

        assertTrue(personService.createPerson(companyName) instanceof LegalPerson);
    }

    @Test
    public void canCreateNaturalPerson() {
        assertDoesNotThrow(() -> {
            personService.createPerson(firstname, lastname);
        });

        assertThrows(TooFewOrLessParametersForPersonCreationException.class, () -> {
            personService.createPerson(firstname, lastname, null);
        });

        assertTrue(personService.createPerson(firstname, lastname) instanceof NaturalPerson);
    }
}
