package com.test.ui;

import com.test.entity.YGOCard;

import javax.swing.*;
import java.awt.*;

public class CardDetailPanel extends JPanel {
    private MainFrame frame;
    private YGOCard card;
    private JTextArea textArea;

    public CardDetailPanel(MainFrame frame) {
        this.frame = frame;
        textArea = new JTextArea();
        this.init();
    }

    private void init() {
        this.setLayout(new GridLayout());
        textArea.setLineWrap(true);
        JScrollPane pane = new JScrollPane(textArea);
        this.add(pane);
    }

    public YGOCard getCard() {
        return card;
    }

    public void setCard(YGOCard card) {
        this.card = card;
        textArea.setText(formatCardInfo(card));
    }

    public String formatCardInfo(YGOCard card) {
        StringBuilder infoBuilder = new StringBuilder();
        infoBuilder.append(card.getId());
        infoBuilder.append(System.lineSeparator());
        infoBuilder.append(System.lineSeparator());
        infoBuilder.append(System.lineSeparator());
        infoBuilder.append(card.getName());
        infoBuilder.append(System.lineSeparator());
        infoBuilder.append(System.lineSeparator());
        infoBuilder.append(System.lineSeparator());
        infoBuilder.append(card.getDesc());
        return infoBuilder.toString();
    }
}
