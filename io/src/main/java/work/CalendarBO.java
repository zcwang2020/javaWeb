/**
 * @(#)CalendarBO.java, 2022/3/18.
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
public class CalendarBO implements Serializable {

    private static final long serialVersionUID = -8257847770069791918L;

    private Long id;

    /**
     * 日期
     */
    private String date;

    /**
     * 主标题
     */
    private String subject;

    /**
     * 副标题
     */
    private String remark;

    /**
     * 商品组id
     */
    private Long itemGroup;

    /**
     * 签到获得积分
     */
    private Long signInIntegral;

    /**
     * 底图
     */
    private String picUrl;

    /**
     * 跳转链接
     */
    private String linkUrl;
}