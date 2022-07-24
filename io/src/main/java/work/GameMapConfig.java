package work;

import java.util.List;

import lombok.Data;

@Data
public class GameMapConfig {

    /**
     * 地图id
     */
    private Long mapId;

    /**
     * 位置数量
     */
    private Integer positionCount;

    /**
     * 位置信息
     */
    private List<GameMapPositionConfig> positions;
}
