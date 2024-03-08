import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Instance of this class
        CarController carController = new CarController();
        CommonBaseCarModel carModel = new CommonBaseCarModel();
        CreateNewCar createCar = new CreateNewCar();

        CommonBaseCar scania = createCar.createNewScania(new Point(0,0));
        CommonBaseCar saab = createCar.createNewSaab95(new Point(0,160));
        CommonBaseCar volvo = createCar.createNewVolvo240(new Point(0,320));

        carModel.addCarToList(scania);
        carModel.addCarToList(saab);
        carModel.addCarToList(volvo);

        carController.setCars(carModel.getCars());

        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0", cc);
        carController.frame = CreateNewGraphics.createNewCarView("CarSim 1.0", carController, carModel);

        // Start the timer
        carController.timer.start();
    }
}
