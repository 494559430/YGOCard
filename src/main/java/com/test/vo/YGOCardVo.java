package com.test.vo;

/**
 * 卡牌列表视图对象
 * @author sunhao
 */
public class YGOCardVo {
    private Integer id;
    private String name;

    public YGOCardVo() {
    }

    public YGOCardVo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
