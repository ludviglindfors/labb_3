import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements CarObserver {
    public static final int X = 800;
    public static final int Y = 800;

    private ControlPanel controlPanel;

    JPanel jPanel = new JPanel();


    // The controller member
    public CarController carC;

    DrawPanel drawPanel = CreateNewGraphics.createNewDrawPanel(X, Y-240);

    private ActionObserver carControl;

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    private int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addCarButton = new JButton("Add New Car");
    JButton removeCarButton = new JButton("Remove Random Car");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename, CarController cc, CommonBaseCarModel model) {
        this.carC = cc;
        this.carControl = model;
        initComponents(framename, carControl);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title, ActionObserver carControl) {
        this.controlPanel = new ControlPanel(carControl, this);

        this.add(jPanel);
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        jPanel.setLayout(new GridLayout(2, 5));
        jPanel.add(gasButton, 0);
        jPanel.add(turboOnButton, 1);
        jPanel.add(liftBedButton, 2);
        jPanel.add(brakeButton, 3);
        jPanel.add(turboOffButton, 4);
        jPanel.add(lowerBedButton, 5);
        jPanel.add(addCarButton, 6);
        jPanel.add(removeCarButton, 7);
        jPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(jPanel);
        jPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);

        gasButton.addActionListener(e -> carControl.gas(gasAmount));
        brakeButton.addActionListener(e -> carControl.brake(gasAmount));
        turboOnButton.addActionListener(e -> carControl.turboOn());
        turboOffButton.addActionListener(e -> carControl.turboOff());
        liftBedButton.addActionListener(e -> carControl.raiseFlap());
        lowerBedButton.addActionListener(e -> carControl.lowerFlap());
        addCarButton.addActionListener(e -> {
            CreateNewCar createNewCar = new CreateNewCar();
            CommonBaseCar car = createNewCar.createRandomCar();
            if (carC.cars.size() < 6) {
                carC.cars.add(car);
            }
        });
        removeCarButton.addActionListener(e -> carControl.removeCar());
        startButton.addActionListener(e -> carControl.startEngine());
        stopButton.addActionListener(e -> carControl.stopEngine());

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void carRemoved(CommonBaseCar car) {
        drawPanel.removeCar(car);
        drawPanel.repaint();
    }
}