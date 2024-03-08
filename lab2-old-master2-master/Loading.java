public class Loading<T extends CommonBaseCar> {

    private RadiusCheck radiusCheck;

    public Loading(RadiusCheck radiusCheck) {
        this.radiusCheck = radiusCheck;
    }

    public void loadCar(T car, CarTransport<T> transporter) {
        if (car instanceof Flap) {
            if (radiusCheck.isWithinRadius(car, car.getXPosition(), car.getYPosition(), transporter.getLoadingRadius())
                    && !transporter.isPlatformUp() && transporter.getCurrentSpeed() == 0 && transporter.getLoadedCars() < transporter.getMaxCars()) {
                transporter.carsLoaded.add(car);
            } else {
                System.err.println("CarTransport cannot load car");
            }
        } else {
            System.err.println("CarTransport cannot load another carTransport");
        }
    }

    public void unloadCar(CarTransport<T> transporter) {
        int lastCar = transporter.getLoadedCars() - 1;
        if (transporter.isPlatformUp() && transporter.getCurrentSpeed() == 0 && transporter.getLoadedCars() > 0) {
            CommonBaseCar unloadedCar = transporter.carsLoaded.remove(lastCar);
            unloadedCar.yPosition = unloadedCar.getYPosition() - 18;
        } else {
            System.err.println("Cannot unload car");
        }
    }
}