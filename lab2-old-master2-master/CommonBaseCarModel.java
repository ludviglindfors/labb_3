import com.sun.jdi.ArrayReference;
import java.util.ArrayList;

public class CommonBaseCarModel implements ActionObserver {

    private ArrayList<CommonBaseCar> cars = new ArrayList<>();
    private ArrayList<CarObserver> observerList = new ArrayList<>();

    public void addCarToList(CommonBaseCar car) {
        cars.add(car);
    }

    public ArrayList<CommonBaseCar> getCars() {
        return cars;
    }

    public void addObserver(CarObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(CarObserver observer) {
        observerList.remove(observer);
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (CommonBaseCar car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (CommonBaseCar car : cars) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (CommonBaseCar car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (CommonBaseCar car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    public void raiseFlap() {
        for (CommonBaseCar car : cars) {
            if (car instanceof Flap) {
                ((Flap) car).raiseFlap();
            }
        }
    }

    public void lowerFlap() {
        for (CommonBaseCar car : cars) {
            if (car instanceof Flap) {
                ((Flap) car).lowerFlap();
            }
        }
    }

    public void addCar() {
        new CreateNewCar().createRandomCar();
    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            CommonBaseCar removedCar = cars.removeLast();
            carRemovedNotification(removedCar);
        }
    }

    public void carRemovedNotification(CommonBaseCar removedCar) {
        for (CarObserver observer : observerList) {
            observer.carRemoved(removedCar);
        }
    }

    public void startEngine() {
        for (CommonBaseCar car : cars) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (CommonBaseCar car : cars) {
            car.stopEngine();
        }
    }
}
