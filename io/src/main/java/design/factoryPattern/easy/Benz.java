package design.factoryPattern.easy;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
// 具体实现类
class Benz extends Car {
    @Override
    public void run() {
        System.out.println("Benz开始启动了。。。。。");
    }

    @Override
    public void stop() {
        System.out.println("Benz停车了。。。。。");
    }
}
