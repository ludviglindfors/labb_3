import java.awt.*;
import java.util.Random;
public class CreateNewCar {

    private static final Random random = new Random();

    public CommonBaseCar createNewSaab95(Point pos) {
        CommonBaseCar newCar = new Saab95();
        newCar.xPosition = pos.x;
        newCar.yPosition = pos.y;
        return newCar;
    }

    public CommonBaseCar createNewVolvo240(Point pos) {
        CommonBaseCar newCar = new Volvo240();
        newCar.xPosition = pos.x;
        newCar.yPosition = pos.y;
        return newCar;
    }

    public CommonBaseCar createNewScania(Point pos) {
        CommonBaseCar newTruck = new Scania();
        newTruck.xPosition = pos.x;
        newTruck.yPosition = pos.y;
        return newTruck;
    }

    public CommonBaseCar createRandomCar() {
        int carType = random.nextInt(3);
        int xCord = random.nextInt(200);
        int yCord = random.nextInt(400);

        CommonBaseCar car;

        switch (carType) {
            case 0:
                car=  createNewSaab95(new Point(xCord, yCord));
                break;

            case 1:
                car = createNewVolvo240(new Point(xCord, yCord));
                break;

            case 2:
                car = createNewScania(new Point(xCord, yCord));
                break;

            default:
                throw new IllegalStateException(carType + "is not allowed");
        }
        return car;
    }
}
