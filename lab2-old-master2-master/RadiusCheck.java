public class RadiusCheck<T extends CommonBaseCar> {
    public boolean isWithinRadius(T car, double x, double y, double radius) {
        double xRadiusMax = x + radius;
        double xRadiusMin = x - radius;
        double yRadiusMax = y + radius;
        double yRadiusMin = y - radius;

        double carX = car.getXPosition();
        double carY = car.getYPosition();

        return (xRadiusMin <= carX && carX <= xRadiusMax && yRadiusMin <= carY && carY <= yRadiusMax);
    }
}
