package com.test.ui;

import com.test.ui.listener.SearchButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * 查询参数面板
 * @author sunhao
 */
public class QueryParamPanel extends JPanel {
    private MainFrame frame;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel dbTypeLabel;
    private JList<String> dbTypeList;
    private JButton searchButton;

    public QueryParamPanel(MainFrame frame) {
        this.frame = frame;
        idLabel = new JLabel("卡牌编号");
        idField = new JTextField();
        nameLabel = new JLabel("卡牌名称");
        nameField = new JTextField();
        dbTypeLabel = new JLabel("数据库类型");
        dbTypeList = new JList<>(new String[]{"ENGLISH", "JAPAN", "CHINA"});
        dbTypeList.setSelectedIndex(0);
        searchButton = new JButton("搜索");
        init();
    }

    private void init() {
        this.setLayout(new GridLayout(7, 1));
        this.add(idLabel);
        this.add(idField);
        this.add(nameLabel);
        this.add(nameField);
        searchButton.addMouseListener(new SearchButtonListener(this.frame, this));

        this.add(dbTypeLabel);
        JPanel dbTypePanel = new JPanel();
        dbTypePanel.setLayout(new BorderLayout());
        JScrollPane pane = new JScrollPane(dbTypeList);
        dbTypePanel.add(pane);
        this.add(dbTypePanel);

        this.add(searchButton);
    }

    public JLabel getIdLabel() {
        return idLabel;
    }

    public JTextField getIdField() {
        return idField;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JLabel getDbTypeLabel() {
        return dbTypeLabel;
    }

    public JList<String> getDbTypeList() {
        return dbTypeList;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
