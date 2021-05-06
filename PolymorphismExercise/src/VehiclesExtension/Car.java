package Vehicles;

public class Car extends Vehicle{
    Car(double fuelQuantity, double fuelConsumptionPerLiter) {
        super(fuelQuantity, fuelConsumptionPerLiter);
    }

    @Override
    public void drive(double distance) throws Exception {
        if (distance * (super.fuelConsumptionPerLiter + 0.9) > fuelQuantity){
            throw new Exception(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= distance * (fuelConsumptionPerLiter + 0.9);
        System.out.printf("%s travelled %.2f", this.getClass().getSimpleName(), distance);
        System.out.println();
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }
}
