package com.test;
 
import com.test.entity.YGOCard;
import com.test.enums.DbType;
import com.test.util.YGOUtil;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.*;
import javax.swing.plaf.FontUIResource;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

/**
 * swing基础实例
 * @author HZ20232
 *
 */
public class Hello{
    public static void main(String args[])throws Exception{
        InitGlobalFont(new Font("宋体", Font.BOLD, 18));  //统一设置字体
        NewFrame frame1 = new NewFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//一定要设置关闭
 
        frame1.setVisible(true);
    }
    /**
     * 统一设置字体，父界面设置之后，所有由父界面进入的子界面都不需要再次设置字体
     */
    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }
}
class NewFrame extends JFrame{
    private JLabel label1;
    private JButton button1;
    private JTextField text1;
    private JComboBox box;
    private JMenuBar menuBar;
    private JSlider slider;
    private JSpinner spinner;
    private JToolBar toolBar;
    private NewFrame newFrame;
    public NewFrame(){
        super();
        this.setSize(400,800);
//        this.getContentPane().setLayout(null);//设置布局控制器
 
//        this.getContentPane().setLayout(new FlowLayout());//设置布局控制器
 
//        this.getContentPane().setLayout(new GridLayout(1,2));//设置布局控制器,需要给出设定的行列数目
 
        this.getContentPane().setLayout(new BorderLayout());//设置布局控制器，以North,South,West,East，来控制控件布局
 
//        this.getContentPane().setLayout(new GridBagLayout());//设置布局控制器
        RightPanel rightPanel=new RightPanel();
        CenterPanel centerPanel = new CenterPanel();
        /*this.add(this.getTextField(),null);//添加文本框
 
        this.add(this.getButton(),null);//添加按钮
 
        this.add(this.getLabel(),null);//添加标签*/
 
        //this.add(this.getBox(),null);//添加下拉列表框
 
        //this.setJMenuBar(this.getMenu());//添加菜单
 
        //this.add(this.getSlider(),null);
        //this.add(this.getSpinner(),null);
        //.add(this.getToolBar(),null);
        this.setTitle("查卡器");//设置窗口标题
        Container c=this.getContentPane();
        c.add(centerPanel,BorderLayout.CENTER);
        c.add(rightPanel,BorderLayout.EAST);
 
    }


    private class comboxListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Object o = e.getSource();
            System.out.println(o.toString());
        }
    }


    /**
     * 监听器类实现ActionListener接口，主要实现actionPerformed方法
     * @author HZ20232
     *
     */
    private class HelloButton implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String text = text1.getText();
            java.util.List<YGOCard> cardsEx = YGOUtil.getCardsByName(text, DbType.ENGLISH);
            for (YGOCard ygoCard :cardsEx){
                YGOCard ygoZHCard = YGOUtil.getCardById(ygoCard.getId());
                System.out.println(ygoZHCard.getName());
            }

        }
    }

    class CenterPanel extends JPanel{
        public CenterPanel(){
            text1 = new JTextField();
            this.add(text1);
            text1.setBounds(96,49,140,30);
            this.add(this.getButton());//添加按钮
            this.add(this.getLabel());//添加标签
        }
        /**
         * 设置标签
         * @return 设置好的标签
         */
        private JLabel getLabel(){
            if(label1==null){
                label1 = new JLabel();
                label1.setBounds(10,49,100,25);
                label1.setText("卡片名字:");
                label1.setToolTipText("JLabel");
            }
            return label1;
        }
        /**
         * 设置按钮
         * @return 设置好的按钮
         */
        private JButton getButton(){
            if(button1==null){
                button1 = new JButton();
                button1.setBounds(103,90,71,27);
                button1.setText("ok");
                button1.setToolTipText("OK");
                button1.addActionListener(new HelloButton());//添加监听器类，其主要的响应都由监听器类的方法实现

            }
            return button1;
        }

    }
    class RightPanel extends JPanel{

        public RightPanel(){

            this.setLayout(new GridLayout(8,1));

            DefaultListModel litem=new DefaultListModel();

            litem.addElement("香蕉");

            litem.addElement("水果");

            JList list=new JList(litem);

            list.addListSelectionListener(new ListSelectionListener(){

                public void valueChanged(ListSelectionEvent e){

                    JList l=(JList)e.getSource();

                    Object s=l.getSelectedValue();

                    JOptionPane.showMessageDialog(null,s,"消息框",JOptionPane.YES_OPTION);

                }

            });



            add(list);

            this.setBorder(new EtchedBorder(EtchedBorder.LOWERED,Color.LIGHT_GRAY,Color.blue));

        }

    }
}