package design.factoryPattern.abs;

import design.decoratorPattern.Food;
import design.factoryPattern.easy.Car;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
//具体工厂类，其中Food,Vehicle，Weapon是抽象类，
public class DefaultFactory extends AbstractFactory{
    @Override
    public Food createFood() {
        return new Apple();
    }
    @Override
    public Vehicle createVehicle() {
        return new Vehicle();
    }
    @Override
    public Weapon createWeapon() {
        return new Weapon();
    }
}
