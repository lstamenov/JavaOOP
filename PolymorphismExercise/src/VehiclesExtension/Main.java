package Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carData = reader.readLine().split("\\s+");
        String[] truckData = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");
            if (command[0].equals("Drive")){
                try{
                    if (command[1].equals("Car")){
                        car.drive(Double.parseDouble(command[2]));
                    }else {
                        truck.drive(Double.parseDouble(command[2]));
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }else {
                if (command[1].equals("Car")){
                    car.refuel(Double.parseDouble(command[2]));
                }else {
                    truck.refuel(Double.parseDouble(command[2]));
                }
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
