package design.adapterPattern;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
// 手机类
public class Phone {

    public static final int V = 220;// 正常电压220v，是一个常量

    private VoltageAdapter adapter;

    // 充电
    public void charge() {
        adapter.changeVoltage();
    }

    public void setAdapter(VoltageAdapter adapter) {
        this.adapter = adapter;
    }
}
