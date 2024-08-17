class Car {


    String make;
    String model;
    int year;

    String fuel;
    double consumption;

    Car(String make, String model, int year, String fuel, double consumption) {

        this.make = make;
        this.model = model;
        this.year = year;
        this.fuel = fuel;
        this.consumption = consumption;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Make:" + make + "Model:" + model + "Year" + year + "Fuel:" + fuel + "Consumation:" + consumption;
    }
}
