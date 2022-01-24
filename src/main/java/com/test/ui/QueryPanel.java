package com.test.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 查询面板
 * @author sunhao
 */
public class QueryPanel extends JPanel {
    private MainFrame frame;
    private QueryParamPanel queryParamPanel;
    private CardTablePanel cardTablePanel;

    public QueryPanel(MainFrame frame) {
        this.frame = frame;
        this.queryParamPanel = new QueryParamPanel(frame);
        this.cardTablePanel = new CardTablePanel(frame);
        init();
    }

    private void init() {
        this.setLayout(new GridLayout());
        this.add(queryParamPanel);
        this.add(cardTablePanel);
    }

    public QueryParamPanel getQueryParamPanel() {
        return queryParamPanel;
    }

    public CardTablePanel getCardTablePanel() {
        return cardTablePanel;
    }
}
