package com.test.ui.listener;

import com.test.entity.YGOCard;
import com.test.ui.MainFrame;
import com.test.ui.component.CardTableModel;
import com.test.util.YGOUtil;
import com.test.vo.YGOCardVo;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableRowSelectionListener implements ListSelectionListener {
    private MainFrame frame;
    private CardTableModel cardTableModel;

    public TableRowSelectionListener(MainFrame frame, CardTableModel cardTableModel) {
        this.frame = frame;
        this.cardTableModel = cardTableModel;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int rowIndex = handleSelectionEvent(e);
        if (rowIndex >= 0) {
            YGOCardVo cardVo = cardTableModel.getCard(rowIndex);
            YGOCard card = YGOUtil.getCardById(cardVo.getId());
            this.frame.getCardDetailPanel().setCard(card);
        }
    }

    private int handleSelectionEvent(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return -1;
        }
        String strSource = e.getSource().toString();
        int start = strSource.indexOf("{") + 1,
                stop = strSource.length() - 1;
        if (start == stop) {
            return -1;
        }
        return Integer.parseInt(strSource.substring(start, stop));
    }
}
