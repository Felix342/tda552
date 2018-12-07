public class CarFactory {

    public static Car createSaab95(double x, double y) {
        return new Saab95(x, y);
    }

    public static Car createVolvo240(double x, double y) {
        return new Volvo240(x, y);
    }

    public static Car createScania(double x, double y) {
        return new Scania(x, y);
    }
}
