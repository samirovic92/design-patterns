package creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase_BuilderTest {

    @Test
    public void create_computer_with_builder() {
        // Given
        var computerBuilder = new Computer.Builder("Dell", "Intel i7")
                .ramGB("16GB")
                .storageGB("512GB")
                .hasBluetooth(true)
                .hasWifi(true);

        // When
        var computer = computerBuilder.build();

        // Then
        assertEquals("Dell", computer.getBrand());
        assertEquals("Intel i7", computer.getCpu());
        assertEquals("16GB", computer.getRamGB());
        assertEquals("512GB", computer.getStorageGB());
        assertTrue(computer.isHasBluetooth());
        assertTrue(computer.isHasWifi());
    }

    @Test
    public void not_create_the_computer_with_invalid_brand() {
        // Given
        var computerBuilder = new Computer.Builder("", "Intel i7")
                .ramGB("16GB");

        // When & Then
        var errorMessage = assertThrows(IllegalArgumentException.class, computerBuilder::build)
                .getMessage();
        assertEquals("Brand is required", errorMessage);
    }
}
