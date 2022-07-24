package design;

import design.adapterPattern.Phone;
import design.adapterPattern.VoltageAdapter;
import design.decoratorPattern.Bread;
import design.decoratorPattern.Cream;
import design.decoratorPattern.Food;
import design.decoratorPattern.Vegetable;
import design.factoryPattern.easy.Car;
import design.factoryPattern.easy.Factory;
import design.factoryPattern.method.BroomFactory;
import design.factoryPattern.method.Moveable;
import design.factoryPattern.method.VehicleFactory;
import design.observerPattern.XiaoLi;
import design.observerPattern.XiaoMei;
import design.observerPattern.XiaoWang;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
public class DesignTest {
    public static void main(String[] args) {

        // 1.观察者模式测试
        System.out.println("观察者模式");
        XiaoMei xiaoMei = new XiaoMei();
        XiaoWang laoWang = new XiaoWang();
        XiaoLi laoLi = new XiaoLi();

        //小王和小李在小美那里都注册了一下
        xiaoMei.addPerson(laoWang);
        xiaoMei.addPerson(laoLi);

        //小美向小王和小李发送通知
        xiaoMei.notifyPerson();
        System.out.println("----------");

        // 2.装饰模式
        System.out.println("装饰模式");
        Food food = new Bread(new Vegetable(new Cream(new Food("香肠"))));
        System.out.println(food.make());
        System.out.println("----------");

        // 3.适配器模式
        System.out.println("适配器模式");
        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();
        System.out.println("----------");

        // 4.工厂模式
        // 简单工厂模式：一个抽象的接口，多个抽象接口的实现类，一个工厂类，用来实例化抽象的接口
        System.out.println("工厂模式");
        System.out.println("简单工厂模式");
        Car c = Factory.getCarInstance("Benz");
        if (c != null) {
            c.run();
            c.stop();
        } else {
            System.out.println("造不了这种汽车。。。");
        }
        System.out.println("----------");
        System.out.println("工厂方法模式");
        // 工厂方法模式：有四个角色，抽象工厂模式，具体工厂模式，抽象产品模式，具体产品模式。
        // 不再是由一个工厂类去实例化具体的产品，而是由抽象工厂的子类去实例化产品
        VehicleFactory factory = new BroomFactory();
        Moveable m = factory.create();
        m.run();
        System.out.println("----------");

        System.out.println("工厂模式");
        // 抽象工厂模式：与工厂方法模式不同的是，工厂方法模式中的工厂只生产单一的产品，而抽象工厂模式中的工厂生产多个产品

        System.out.println("----------");
        System.out.println("工厂模式");

        System.out.println("----------");
        System.out.println("工厂模式");

        System.out.println("----------");
        System.out.println("工厂模式");

        System.out.println("----------");
        System.out.println("工厂模式");

        System.out.println("----------");
        System.out.println("工厂模式");

        System.out.println("----------");
        System.out.println("工厂模式");

        System.out.println("----------");

    }

}
