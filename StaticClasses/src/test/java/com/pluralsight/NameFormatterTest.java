package com.pluralsight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NameFormatterTest {

    @Test
    public void testFullNameWithAllParts() {
        String result = NameFormatter.formatName("Dr.", "Mel", "B", "Johnson", "PhD");
        assertEquals("Johnson, Dr. Mel B, PhD", result);
    }

    @Test
    public void testNameWithoutPrefix() {
        String result = NameFormatter.formatName("", "Mel", "B", "Johnson", "PhD");
        assertEquals("Johnson, Mel B, PhD", result);
    }

    @Test
    public void testNameWithoutMiddleName() {
        String result = NameFormatter.formatName("Mr.", "James", "", "Smith", "Jr.");
        assertEquals("Smith, Mr. James, Jr.", result);
    }

    @Test
    public void testNameWithoutSuffix() {
        String result = NameFormatter.formatName("Mrs.", "Anna", "Marie", "Brown", "");
        assertEquals("Brown, Mrs. Anna Marie", result);
    }

    @Test
    public void testNameWithOnlyRequiredFields() {
        String result = NameFormatter.formatName("", "Lucas", "", "White", "");
        assertEquals("White, Lucas", result);
    }
}