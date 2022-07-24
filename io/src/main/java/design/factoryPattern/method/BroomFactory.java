package design.factoryPattern.method;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
public class BroomFactory extends VehicleFactory {
    @Override
    public Moveable create() {
        return new Broom();
    }
}
