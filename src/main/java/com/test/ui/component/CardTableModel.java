package com.test.ui.component;

import com.test.vo.YGOCardVo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CardTableModel extends AbstractTableModel {
    private List<YGOCardVo> list = new ArrayList<>();
    private String[] columnNames = {"ID", "NAME"};

    public CardTableModel() {
    }

    public CardTableModel(List<YGOCardVo> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        YGOCardVo info = list.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return info.getId();
            case 1:
                return info.getName();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
        }
        return null;
    }

    public void clear() {
        this.list.clear();
        this.fireTableDataChanged();
    }

    public void addRow(YGOCardVo cardVo) {
        this.list.add(cardVo);
        this.fireTableDataChanged();
    }

    public void setList(List<YGOCardVo> list) {
        this.list = list;
        this.fireTableDataChanged();
    }

    public YGOCardVo getCard(int rowIndex) {
        return list.get(rowIndex);
    }
}
