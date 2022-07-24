/**
 * @(#)AutoTest.java, 2022/4/27.
 * <p/>
 * Copyright 2022 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package work;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @Author zcwang
 * @Date 2022/4/27
 */
public class AutoTest {
    public static void main(String[] args) {
        List<GameMapPositionConfig> positions = new ArrayList<>();
        for (long i = 1; i <=43 ; i++) {
            GameMapPositionConfig gameMapPositionConfig = new GameMapPositionConfig();
            gameMapPositionConfig.setPositionId(i);
            gameMapPositionConfig.setType(0);
            if (i == 13 || i == 21 || i == 31) {
                gameMapPositionConfig.setType(1);
            }
            if (i == 43) {
                gameMapPositionConfig.setType(2);
            }
            gameMapPositionConfig.setRewardId(0L);
            gameMapPositionConfig.setImageUrl("");
            positions.add(gameMapPositionConfig);
        }
        System.out.println(JSON.toJSONString(positions));
    }
}