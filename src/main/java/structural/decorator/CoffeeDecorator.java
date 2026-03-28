package structural.decorator;

// ─── Base Decorator ────────────
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee wrapped;

    public CoffeeDecorator(Coffee coffee) {
        this.wrapped = coffee;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription();
    }

    @Override
    public double getCost() {
        return wrapped.getCost();
    }
}
