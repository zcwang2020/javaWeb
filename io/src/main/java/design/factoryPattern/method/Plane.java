package design.factoryPattern.method;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
// 具体产品角色
public class Plane implements Moveable {
    @Override
    public void run() {
        System.out.println("plane....");
    }
}
