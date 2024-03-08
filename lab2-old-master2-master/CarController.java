import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    Timer timer = new Timer(delay, new TimerListener());

    public DrawPanel drawPanel;

    // The frame that represents this instance View of the MVC pattern

    CarView frame;
    // A list of cars, modify if needed


    public CarController() {
        cars = new ArrayList<>();
        volvoWorkshop = new VolvoWorkshop<>(10,300,300);
    }

    public ArrayList<CommonBaseCar> cars;
    public Workshop<CommonBaseCar> volvoWorkshop;

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    public void setCars(ArrayList<CommonBaseCar> cars) {
        this.cars = cars;
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (CommonBaseCar car : cars) {
                car.move();

                if (car.getXPosition() < 0) {
                    car.setXPosition(0);
                    car.stopEngine();
                    car.setDirection((car.getDirection() + 180) % 360);
                    car.startEngine();
                }
                if (car.getXPosition() > CarView.X - 100) {
                    car.setXPosition(CarView.X - 100);
                    car.stopEngine();
                    car.setDirection((car.getDirection() + 180) % 360);
                    car.startEngine();
                }
                if (car.getYPosition() < 0) {
                    car.setYPosition(0);
                    car.stopEngine();
                    car.setDirection((car.getDirection() + 180) % 360);
                    car.startEngine();
                }
                if (car.getYPosition() > CarView.Y - 60) {
                    car.setYPosition(CarView.Y - 60);
                    car.stopEngine();
                    car.setDirection((car.getDirection() + 180) % 360);
                    car.startEngine();
                }

                int x = (int) Math.round(car.getXPosition());
                int y = (int) Math.round(car.getYPosition());

                frame.drawPanel.moveit(car, x, y);
                frame.drawPanel.repaint();

                if (car instanceof Volvo240) {
                    if (frame.drawPanel.isWithinWorkshopRadius(car, volvoWorkshop)) {
                        volvoWorkshop.receiveCar((Volvo240) car);
                        cars.remove(car);
                        break;
                    }
                }
            }
        }
    }
}