/**
 * @(#)Wei.java, 2021/11/5.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * @Author Tmind
 * @Date 2021/11/5
 */
public class Wei extends Person{
    private String name;
    private Integer age;
    private Integer account;

    private List<String> card;

    private BigDecimal money;

    public Wei() {
    }

    public Wei(String name, Integer age, Integer account) {
        super();
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public Wei(Integer type, String name, Integer age, Integer account, BigDecimal money) {
        super(type);
        this.name = name;
        this.age = age;
        this.account = account;
        this.money = money;
    }

    public Wei(String name, Integer age, Integer account, BigDecimal money) {
        this.name = name;
        this.age = age;
        this.account = account;
        this.money = money;
    }

    public Wei(Integer type, String name, Integer age, Integer account, List<String> card, BigDecimal money) {
        super(type);
        this.name = name;
        this.age = age;
        this.account = account;
        this.card = card;
        this.money = money;
    }

    public Wei(String name, Integer age, Integer account, List<String> card, BigDecimal money) {
        this.name = name;
        this.age = age;
        this.account = account;
        this.card = card;
        this.money = money;
    }

    public List<String> getCard() {
        return card;
    }

    public void setCard(List<String> card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wei wei = (Wei) o;
        return Objects.equals(name, wei.name) && Objects.equals(age, wei.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Wei{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", account=" + account +
                ", card=" + card +
                ", money=" + money +
                '}';
    }
}