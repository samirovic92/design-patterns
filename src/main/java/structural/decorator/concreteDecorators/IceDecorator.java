package structural.decorator.concreteDecorators;

import structural.decorator.Coffee;
import structural.decorator.CoffeeDecorator;

public class IceDecorator extends CoffeeDecorator {

    public IceDecorator(Coffee wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + ", with Ice";
    }

    @Override
    public double getCost() {
        return wrapped.getCost();
    }
}
