/**
 * @(#)WeiInfo.java, 2021/11/16.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.util.List;

/**
 * @Author Tmind
 * @Date 2021/11/16
 */
public class WeiInfo {
    private Integer age;
    private List<Wei> weiList;

    public WeiInfo() {
        this.age = age;
        this.weiList = weiList;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Wei> getWeiList() {
        return weiList;
    }

    public void setWeiList(List<Wei> weiList) {
        this.weiList = weiList;
    }

    @Override
    public String toString() {
        return "WeiInfo{" +
                "age=" + age +
                ", weiList=" + weiList +
                '}';
    }
}