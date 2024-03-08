import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JFrame {
    private ActionObserver carControl;
    private int gasAmount;
    private CarView carView;

    public ControlPanel(ActionObserver carControl, CarView carView) {
        this.carControl = carControl;
        this.gasAmount = 0;
        this.carView = carView;
        initComponents();
        setBackground(Color.CYAN);
    }

    private void initComponents() {
        setLayout(new GridLayout(2, 5));

        add(createButton("Gas", e -> carControl.gas(gasAmount)));
        add(createButton("Saab Turbo on", e -> carControl.turboOn()));
        add(createButton("Scania Lift Bed", e -> carControl.raiseFlap()));
        add(createButton("Brake", e -> carControl.brake(gasAmount)));
        add(createButton("Saab Turbo off", e -> carControl.turboOff()));
        add(createButton("Lower Lift Bed", e -> carControl.lowerFlap()));
        add(createButton("Add New Car", e -> {
            CreateNewCar createNewCar = new CreateNewCar();
            CommonBaseCar car = createNewCar.createRandomCar();
            if (carControl instanceof CarController carController) {
                if (carController.cars.size() < 6) {
                    carController.cars.add(car);
                }
            }
        }));
        add(createButton("Remove Random Car", e -> carControl.removeCar()));
        add(createButton("Start all cars", e -> carControl.startEngine()));
        add(createButton("Stop all cars", e -> carControl.stopEngine()));
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }
}
