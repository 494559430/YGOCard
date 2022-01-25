package com.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 卡牌列表视图对象
 * @author sunhao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YGOCardVo {
    private Integer id;
    private String name;

}
