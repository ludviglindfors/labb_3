import java.util.ArrayList;
import java.util.Optional;

public class Workshop<T extends CommonBaseCar> {

    private double xPosition;
    private double yPosition;

    private int maxCars;
    private ArrayList<T> cars = new ArrayList<>();

    public Workshop(int maxCars, double xPosition, double yPosition) {
        this.maxCars = maxCars;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public int getCarsAmount() {
        if (cars.size() <= maxCars) {
            return cars.size();
        } else {
            return maxCars;
        }
    }

    public void receiveCar(T car) {
        if (cars.size() < maxCars) {
            cars.add(car);
        } else {
            System.err.println("Cannot receive car");
        }
    }

    public Optional<T> returnCar() {
        if (!cars.isEmpty()) {
            T car = cars.remove(cars.size() - 1);
            return Optional.of(car);
        } else {
            System.err.println("Cannot return car");
            return Optional.empty();
        }
    }
}

