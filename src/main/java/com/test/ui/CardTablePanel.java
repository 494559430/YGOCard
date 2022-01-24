package com.test.ui;

import com.test.ui.component.CardTable;

import javax.swing.*;
import java.awt.*;

/**
 * 卡片列表面板
 * @author sunhao
 */
public class CardTablePanel extends JPanel {
    private MainFrame frame;
    private CardTable cardTable;

    public CardTablePanel(MainFrame frame) {
        this.frame = frame;
        cardTable = new CardTable(frame);
        this.init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(cardTable);
        add(pane, BorderLayout.CENTER);
    }

    public CardTable getCardTable() {
        return cardTable;
    }
}
