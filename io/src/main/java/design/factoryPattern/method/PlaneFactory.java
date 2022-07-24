package design.factoryPattern.method;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
// 具体工厂
public class PlaneFactory extends VehicleFactory {
    @Override
    public Moveable create() {
        return new Plane();
    }
}
