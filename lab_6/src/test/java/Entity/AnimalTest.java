package Entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void testAnimalCreationWithId() {
        Animal animal = new Animal(1, "Кот", 100.0);
        assertEquals(1, animal.getId());
        assertEquals("Кот", animal.getName());
        assertEquals(100.0, animal.getCareCost());
    }

    @Test
    public void testAnimalCreationWithoutId() {
        Animal animal = new Animal("Собака", 200.0);
        assertEquals("Собака", animal.getName());
        assertEquals(200.0, animal.getCareCost());
    }

    @Test
    public void testAnimalToString() {
        Animal animal = new Animal(1, "Попугай", 50.0);
        assertTrue(animal.toString().contains("Попугай"));
    }
}
