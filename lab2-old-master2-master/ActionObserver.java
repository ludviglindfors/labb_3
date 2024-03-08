public interface ActionObserver {
    void gas(int amount);
    void brake(int amount);
    void turboOn();
    void turboOff();
    void raiseFlap();
    void lowerFlap();
    void startEngine();
    void stopEngine();
    void addCar();
    void removeCar();
}
