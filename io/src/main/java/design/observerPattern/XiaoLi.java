package design.observerPattern;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
public class XiaoLi implements Person{

    private String name = "小李";

    public XiaoLi() {
    }

    @Override
    public void getMessage(String s) {
        System.out.println(name + "接到了小美打过来的电话，电话内容是：->" + s);
    }
}
