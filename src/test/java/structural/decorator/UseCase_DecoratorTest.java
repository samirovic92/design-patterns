package structural.decorator;

import org.junit.jupiter.api.Test;
import structural.decorator.concreteDecorators.IceDecorator;
import structural.decorator.concreteDecorators.MilkDecorator;
import structural.decorator.concreteDecorators.SugarDecorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase_DecoratorTest {

    @Test
    public void prepare_simple_coffee()  {
        // When
        Coffee coffee = new SimpleCoffee();

        // When
        assertEquals("Simple Coffee", coffee.getDescription());
        assertEquals(3.0, coffee.getCost());
    }

    @Test
    public void prepare_coffee_with_decorator()  {
        // Given
        Coffee coffee = new SimpleCoffee();

        // When
        coffee = new SugarDecorator(coffee);
        coffee = new MilkDecorator(coffee);
        coffee = new IceDecorator(coffee);

        // Then
        assertEquals("Simple Coffee, with Sugar, with Milk, with Ice", coffee.getDescription());
        assertEquals(4.5, coffee.getCost());
    }
}
