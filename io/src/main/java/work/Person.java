/**
 * @(#)Person.java, 2021/11/23.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.util.Objects;

/**
 * @Author Tmind
 * @Date 2021/11/23
 */
public class Person {
    private Integer type;

    public Person(Integer type) {
        this.type = type;
    }

    public Person() {

    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(type, person.type);
    }

}