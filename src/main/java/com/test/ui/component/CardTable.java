package com.test.ui.component;

import com.test.ui.MainFrame;
import com.test.ui.listener.TableRowSelectionListener;
import com.test.vo.YGOCardVo;

import javax.swing.*;
import java.util.List;

/**
 * 卡片表
 * @author sunhao
 */
public class CardTable extends JTable {
    private int selectedIndex = -1;
    private CardTableModel cardTableModel;
    private MainFrame frame;

    public CardTable(MainFrame frame) {
        this.frame = frame;
        cardTableModel = new CardTableModel();
        this.init();
    }

    private void init() {
        this.setModel(cardTableModel);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel selectionModel = this.getSelectionModel();

        selectionModel.addListSelectionListener(new TableRowSelectionListener(this.frame, this.cardTableModel));
    }

    public void setDatas(List<YGOCardVo> list) {
        this.cardTableModel.setList(list);
    }
}
