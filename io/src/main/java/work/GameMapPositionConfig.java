package work;

import lombok.Data;

@Data
public class GameMapPositionConfig {

    /**
     * 位置id
     */
    private Long positionId;

    /**
     * 位置类型，0-空，1-有奖品，2-结束位置
     * com.netease.yanxuan.act.attendance.common.constants.enums.MapTypeEnum
     */
    private Integer type;

    /**
     * 奖品id
     */
    private Long rewardId;

    /**
     * 位置要添加的图片，和前端商量后定，待定
     */
    private String imageUrl;

    @Override
    public String toString() {
        return "GameMapPositionConfig{" +
                "positionId=" + positionId +
                ", type=" + type +
                ", rewardId=" + rewardId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
