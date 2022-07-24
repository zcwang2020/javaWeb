package design.factoryPattern.abs;

/**
 * @Author wzc
 * @Date 2022/5/8
 */

import design.decoratorPattern.Food;
//抽象工厂类
public abstract class AbstractFactory {
    public abstract Vehicle createVehicle();
    public abstract Weapon createWeapon();
    public abstract Food createFood();
}
