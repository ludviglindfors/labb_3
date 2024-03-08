public class CreateNewGraphics {

    public static CarController createNewCarController(){
        return new CarController();
    }

    public static CarView createNewCarView(String framename, CarController cc, CommonBaseCarModel model){
        return new CarView(framename, cc, model);
    }

    public static DrawPanel createNewDrawPanel(int x, int y){
        return new DrawPanel(x, y);
    }

    public static CommonBaseCarModel createNewCarModel() {
        return new CommonBaseCarModel();
    }
}

