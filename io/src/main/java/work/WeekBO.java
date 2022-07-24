/**
 * @(#)WeekBO.java, 2022/3/18.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.io.Serializable;

import lombok.Data;

/**
 * @Author zcwang
 * @Date 2022/3/18
 */
@Data
public class WeekBO extends CalendarBO implements Serializable {
    private static final long serialVersionUID = -8257847770069791918L;

    /**
     * 是否签到
     */
    private Boolean isSign;
}