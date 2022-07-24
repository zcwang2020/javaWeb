/**
 * @(#)MetarialBO.java, 2022/3/18.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @Author zcwang
 * @Date 2022/3/18
 */
@Data
public class MaterialBO implements Serializable {

    private static final long serialVersionUID = -8257847770069791918L;

    /**
     * abt分组id
     */
    private Long schemaId;

    /**
     * 日历信息
     */
    private List<CalendarBO> calendar;
}