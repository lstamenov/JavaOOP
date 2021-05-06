package Vehicles;

public abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumptionPerLiter;

    Vehicle(double fuelQuantity, double fuelConsumptionPerLiter){
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerLiter = fuelConsumptionPerLiter;
    }

    public abstract void drive(double distance) throws Exception;

    public abstract void refuel(double liters);

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), fuelQuantity);
    }
}
