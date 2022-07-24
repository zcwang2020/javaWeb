package design.factoryPattern.easy;

import design.factoryPattern.easy.Car;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
class Ford extends Car {
    @Override
    public void run() {
        System.out.println("Ford开始启动了。。。");
    }

    @Override
    public void stop() {
        System.out.println("Ford停车了。。。。");
    }
}
