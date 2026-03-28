package structural.decorator.concreteDecorators;

import structural.decorator.Coffee;
import structural.decorator.CoffeeDecorator;

public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + ", with Sugar";
    }

    @Override
    public double getCost() {
        return wrapped.getCost() + 0.5;
    }
}
