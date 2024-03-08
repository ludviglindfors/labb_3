import java.awt.*;
import java.util.ArrayList;

public class CarTransport<T extends CommonBaseCar> extends CommonBaseCar implements Flap {

    private TwoStatePlatform platform;
    private double loadingRadius = 14;
    private boolean flapUp;
    private final int maxCars = 6;
    public ArrayList<CommonBaseCar> carsLoaded = new ArrayList<>();

    public CarTransport() {
        super(2, Color.blue, 220, "carTransport", 0.0, 0.0, 0.0);
        this.platform = new TwoStatePlatform();
        this.flapUp = true;
    }

    public int getMaxCars() {
        return this.maxCars;
    }
    private boolean isRampUp() {
        return flapUp;
    }

    public boolean isPlatformUp() {
        return platform.isUp();
    }

    public double getLoadingRadius() {
        return loadingRadius;
    }

    public void raiseFlap() {
        if (getCurrentSpeed() == 0) {
            platform.raiseFlap();
        }
    }

    public void lowerFlap() {
        if (getCurrentSpeed() == 0) {
            platform.lowerFlap();
        }
    }

    public int getLoadedCars() {
        if (carsLoaded.size() <= maxCars) {
            return carsLoaded.size();
        } else {
            return maxCars;
        }
    }
}