/**
 * @(#)JsonTest.java, 2022/5/6.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import com.alibaba.fastjson.JSON;

/**
 * @Author zcwang
 * @Date 2022/5/6
 */
public class JsonTest {
    public static void main(String[] args) {

        String configJson = "{\"name\":\"张三\",\"age\":18}";
        Wei wei = JSON.parseObject(configJson, Wei.class);
        System.out.println(wei);
        Wei wei1 = new Wei();
        System.out.println(wei1.getAge().equals(1));
    }
}