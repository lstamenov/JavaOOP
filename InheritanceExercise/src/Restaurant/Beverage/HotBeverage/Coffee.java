package Restaurant.Beverage.HotBeverage;

import java.math.BigDecimal;

public class Tea extends HotBeverage{
    private final double COFFEE_MILLILITERS = 50;
    private final BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;

    public Tea(String name, BigDecimal price, double milliliters, double caffeine) {
        super(name, price, milliliters);
        super.setPrice(COFFEE_PRICE);
        super.setMilliliters(COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
