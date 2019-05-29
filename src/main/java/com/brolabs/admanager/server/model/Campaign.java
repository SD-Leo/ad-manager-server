package com.brolabs.admanager.server.model;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;


/**
 * Рекламная кампания
 */
@Data
@Builder
public class Campaign {

    private String id;

    private AdSettings settings;

    /**
     * Список точек показа рекламы, которые
     * показывают рекламный маретиал данной рекламной кампании
     */
    @Singular
    private List<String> points;

    /**
     * Список рекламного материала, который
     * участвует в данной рекламной кампании
     */
    @Singular
    private List<String> ads;

    //todo Предусмотреть(если это будет нужно), чтобы в рекламной кампании
    // можно было задавать показ определенного рекламного материала
    // на определенной рекламной точке
}
