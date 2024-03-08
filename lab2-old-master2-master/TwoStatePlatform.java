public class TwoStatePlatform implements Flap {
    private boolean platformState;

    public TwoStatePlatform() {
        this.platformState = true;
    }

    public void raiseFlap() {
        platformState = true;
    }

    public void lowerFlap() {
        platformState = false;
    }

    public boolean isUp() {
        return platformState;
    }

}
