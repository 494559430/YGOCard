package com.test.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 主页面
 * @author sunhao
 */
public class MainFrame extends JFrame {
    private QueryPanel queryPanel;
    private CardDetailPanel cardDetailPanel;

    public MainFrame() {
        init();
        this.setTitle("查卡器 v1.0.0");
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(new GridLayout(2, 1));
        queryPanel = new QueryPanel(this);
        cardDetailPanel = new CardDetailPanel(this);
        this.add(queryPanel);
        this.add(cardDetailPanel);
    }

    public QueryPanel getQueryPanel() {
        return queryPanel;
    }

    public CardDetailPanel getCardDetailPanel() {
        return cardDetailPanel;
    }
}
