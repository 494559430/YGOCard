package com.test.ui.listener;

import com.test.enums.DbType;
import com.test.ui.MainFrame;
import com.test.ui.QueryPanel;
import com.test.ui.QueryParamPanel;
import com.test.util.YGOUtil;
import com.test.vo.YGOCardVo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SearchButtonListener extends MouseAdapter {
    private MainFrame frame;
    private QueryParamPanel queryParamPanel;

    public SearchButtonListener(MainFrame frame, QueryParamPanel queryParamPanel) {
        this.frame = frame;
        this.queryParamPanel = queryParamPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        DbType dbType = DbType.valueOf(queryParamPanel.getDbTypeList().getSelectedValue());
        List<YGOCardVo> list = YGOUtil.getCardsVoByName(queryParamPanel.getNameField().getText(), dbType);
        QueryPanel queryPanel = this.frame.getQueryPanel();
        queryPanel.getCardTablePanel().getCardTable().setDatas(list);
    }
}
