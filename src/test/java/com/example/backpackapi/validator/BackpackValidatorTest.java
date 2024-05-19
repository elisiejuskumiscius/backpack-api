package com.example.backpackapi.validator;

import com.example.backpackapi.exceptions.RequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BackpackValidatorTest {

    @Test
    @DisplayName("Given valid kilometers and valid date then no exception is thrown")
    void testValidKilometersAndValidDate() {
        // Given
        int kilometers = 50;
        String date = "2023-05-15";

        // When / Then
        assertDoesNotThrow(() -> BackpackValidator.validateRequest(kilometers, date));
    }

    @Test
    @DisplayName("Given kilometers less than 1 When validateRequest is called, then a RequestException is thrown")
    void testKilometersLessThanOne() {
        // Given
        int kilometers = 0;
        String date = "2023-05-15";

        // When / Then
        RequestException exception = assertThrows(RequestException.class, () ->
                BackpackValidator.validateRequest(kilometers, date));
        assertEquals("Entered invalid kilometers value 0", exception.getMessage());
    }

    @Test
    @DisplayName("Given kilometers greater than 100")
    void testKilometersGreaterThanHundred() {
        // Given
        int kilometers = 101;
        String date = "2023-05-15";

        // When / Then
        RequestException exception = assertThrows(RequestException.class, () ->
                BackpackValidator.validateRequest(kilometers, date));
        assertEquals("Entered invalid kilometers value 101", exception.getMessage());
    }

    @Test
    @DisplayName("Given valid kilometers and invalid date format When validateRequest is called, then a RequestException is thrown")
    void testValidKilometersAndInvalidDateFormat() {
        // Given
        int kilometers = 50;
        String date = "15-05-2023";

        // When / Then
        RequestException exception = assertThrows(RequestException.class, () ->
                BackpackValidator.validateRequest(kilometers, date));
        assertEquals("Entered invalid date value 15-05-2023", exception.getMessage());
    }

    @Test
    @DisplayName("Given valid kilometers and non-date string then a RequestException is thrown")
    void testValidKilometersAndNonDateString() {
        // Given
        int kilometers = 50;
        String date = "invalid-date";

        // When / Then
        RequestException exception = assertThrows(RequestException.class, () ->
                BackpackValidator.validateRequest(kilometers, date));
        assertEquals("Entered invalid date value invalid-date", exception.getMessage());
    }

    @Test
    @DisplayName("Given valid kilometers and empty date string then a RequestException is thrown")
    void testValidKilometersAndEmptyDateString() {
        // Given
        int kilometers = 50;
        String date = "";

        // When / Then
        RequestException exception = assertThrows(RequestException.class, () ->
                BackpackValidator.validateRequest(kilometers, date));
        assertEquals("Entered invalid date value ", exception.getMessage());
    }

}