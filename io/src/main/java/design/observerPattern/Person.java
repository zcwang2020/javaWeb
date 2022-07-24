package design.observerPattern;

/**
 * @Author wzc
 * @Date 2022/5/8
 */
public interface Person {
    //小王和小李通过这个接口可以接收到小美发过来的消息
    void getMessage(String s);
}


