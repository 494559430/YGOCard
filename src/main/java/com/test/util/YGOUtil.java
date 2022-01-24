package com.test.util;

import com.test.entity.YGOCard;
import com.test.enums.DbType;
import com.test.vo.YGOCardVo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rumble on 2022/1/24.
 */
public class YGOUtil {
    /**
     * 根据id获取卡牌信息
     * @param id
     * @return
     */
    public static YGOCard getCardById(Integer id) {
        return getCardById(id, DbUtil.getDbType());
    }

    /**
     * 根据卡牌id获取卡牌信息
     * @param id
     * @param dbType
     * @return
     * @throws ClassNotFoundException
     */
    public static YGOCard getCardById(Integer id, DbType dbType) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DbUtil.getConnection(dbType);
            statement = connection.createStatement();

            rs = statement.executeQuery("select * from texts where id = " + id);
            while (rs.next()) {
                YGOCard ygoCard = new YGOCard();
                ygoCard.setId(rs.getInt("id"));
                ygoCard.setDesc(rs.getString("desc"));
                ygoCard.setName(rs.getString("name"));
                ygoCard.setStr1(rs.getString("str1"));
                ygoCard.setStr2(rs.getString("str2"));
                ygoCard.setStr3(rs.getString("str3"));
                ygoCard.setStr4(rs.getString("str4"));
                ygoCard.setStr5(rs.getString("str5"));
                ygoCard.setStr6(rs.getString("str6"));
                ygoCard.setStr7(rs.getString("str7"));
                ygoCard.setStr8(rs.getString("str8"));
                ygoCard.setStr9(rs.getString("str9"));
                ygoCard.setStr10(rs.getString("str10"));
                ygoCard.setStr11(rs.getString("str11"));
                ygoCard.setStr12(rs.getString("str12"));
                ygoCard.setStr13(rs.getString("str13"));
                ygoCard.setStr14(rs.getString("str14"));
                ygoCard.setStr15(rs.getString("str15"));
                ygoCard.setStr16(rs.getString("str16"));
                return ygoCard;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtil.close(connection, statement, rs);
        }
        return null;
    }

    public static List<YGOCardVo> getCardsVoByName(String name) {
        return getCardsVoByName(name, DbUtil.getDbType());
    }

    public static List<YGOCardVo> getCardsVoByName(String name, DbType dbType) {
        List<YGOCardVo> cardList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DbUtil.getConnection(dbType);
            String sql = "select id, name from texts where name like '%" + name + "%'";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                YGOCardVo ygoCard = new YGOCardVo();
                ygoCard.setId(rs.getInt("id"));
                ygoCard.setName(rs.getString("name"));
                cardList.add(ygoCard);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtil.close(connection, statement, rs);
        }
        return cardList;
    }

    /**
     * 根据名称获取卡牌列表
     * @param name
     * @return
     */
    public static List<YGOCard> getCardsByName(String name) {
        return getCardsByName(name, DbUtil.getDbType());
    }

    /**
     * 根据卡牌名称查询卡牌列表
     * @param name
     * @param dbType
     * @return
     */
    public static List<YGOCard> getCardsByName(String name, DbType dbType) {
        List<YGOCard> cardList = new ArrayList<YGOCard>();

        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DbUtil.getConnection(dbType);
            String sql = "select * from texts where name like \'%" + name + "%\'";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                YGOCard ygoCard = new YGOCard();
                ygoCard.setId(rs.getInt("id"));
                ygoCard.setName(rs.getString("name"));
                ygoCard.setDesc(rs.getString("desc"));
                ygoCard.setStr1(rs.getString("str1"));
                ygoCard.setStr2(rs.getString("str2"));
                ygoCard.setStr3(rs.getString("str3"));
                ygoCard.setStr4(rs.getString("str4"));
                cardList.add(ygoCard);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtil.close(connection, statement, rs);
        }
        return cardList;
    }

    public static YGOCard getDatas(Integer id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DbUtil.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from datas where id = " + id);
            while (rs.next()) {
                YGOCard ygoCard = new YGOCard();
                ygoCard.setId(rs.getInt("id"));
                ygoCard.setDesc(rs.getString("ot"));
                ygoCard.setName(rs.getString("alias"));
                ygoCard.setStr1(rs.getString("setcode"));
                ygoCard.setStr2(rs.getString("type"));
                ygoCard.setStr3(rs.getString("atk"));
                ygoCard.setStr4(rs.getString("def"));
                ygoCard.setStr5(rs.getString("level"));
                ygoCard.setStr6(rs.getString("race"));
                // ygoCard.setStr7(rs.getString("attributecategory"));

                return ygoCard;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            DbUtil.close(connection, statement, rs);
        }
        return null;
    }
}
