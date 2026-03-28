package structural.decorator.concreteDecorators;

import structural.decorator.Coffee;
import structural.decorator.CoffeeDecorator;

// ───  Concrete Decorator ────────────
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + ", with Milk";
    }

    @Override
    public double getCost() {
        return wrapped.getCost() + 1;
    }
}
