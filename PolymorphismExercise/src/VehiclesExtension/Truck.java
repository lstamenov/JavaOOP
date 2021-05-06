package Vehicles;

public class Truck extends Vehicle{

    Truck(double fuelQuantity, double fuelConsumptionPerLiter) {
        super(fuelQuantity, fuelConsumptionPerLiter);
    }

    @Override
    public void drive(double distance) throws Exception {
        if (distance * (super.fuelConsumptionPerLiter + 1.6) > fuelQuantity){
            throw new Exception(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
        this.fuelQuantity -= distance * (fuelConsumptionPerLiter + 1.6);
        System.out.printf("%s travelled %.2f", this.getClass().getSimpleName(), distance);
        System.out.println();
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters * 0.95;
    }
}
