package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceService;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ResourceServiceTest {

    private static ResourceService resourceService;

    @BeforeAll
    static void setupBeforeClass() {
        resourceService = ResourceService.getInstance();
    }

    @AfterAll
    static void tearDownAfterClass() {
        resourceService = null;
    }

    @Test
    public void canSelectResource() {
        assertDoesNotThrow(() -> {
            resourceService.getSelectedResource(ResourceEnumeration.CAR, ResourceEnumeration.CHILD_SEAT);
        });

        try {
            assertNull(resourceService.getSelectedResource());
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThrows(MoreThanOneDecoratableResourceException.class, () -> {
            resourceService.getSelectedResource(ResourceEnumeration.CAR, ResourceEnumeration.CAR,
                    ResourceEnumeration.CHILD_SEAT);
        });

        assertThrows(NoDecoratableResourceException.class, () -> {
            resourceService.getSelectedResource(ResourceEnumeration.CHILD_SEAT);
        });
    }
}
