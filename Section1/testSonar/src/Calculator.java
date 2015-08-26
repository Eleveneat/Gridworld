/*
*    Filename: Calculator.java
*    Description: A simple calculator.
*    Last modified: 2015-08-18 10:40
*
*    Created by Eleveneat on 2015-08-18
*    Email: eleveneat@gmail.com
*    Copyright (C) 2015 Eleveneat. All rights reserved.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.DecimalFormat;

public class Calculator extends JFrame {
    // serialVersionUID作用: 序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。
    private static final long serialVersionUID = 1L;

    private JTextField num1, operator, num2, equal, result;
    private JButton add, sub, mul, div, OK;

    /* 主函数 */
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.setVisible(true);
    }

    public Calculator() {
        initLayout();
        listener();
    }

    /* 初始化布局函数 */
    public void initLayout() {
        // 网格布局
        this.setLayout(new GridLayout(2, 5));

        num1 = new JTextField("12");
        operator = new JTextField();
        num2 = new JTextField("2");
        equal = new JTextField("=");
        result = new JTextField();

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        OK = new JButton("OK");

        // 使 JTextField 里的文本居中
        num1.setHorizontalAlignment(JTextField.CENTER);
        operator.setHorizontalAlignment(JTextField.CENTER);
        num2.setHorizontalAlignment(JTextField.CENTER);
        equal.setHorizontalAlignment(JTextField.CENTER);
        result.setHorizontalAlignment(JTextField.CENTER);

        // 设置格子背景色为灰色
        operator.setBackground(new Color(237, 237, 237));
        equal.setBackground(new Color(237, 237, 237));
        result.setBackground(new Color(237, 237, 237));

        // 使格子处于不可用状态
        // num1.setEnabled(false);
        operator.setEnabled(false);
        // num2.setEnabled(false);
        equal.setEnabled(false);
        // result.setEnabled(false);

        this.add(num1);
        this.add(operator);
        this.add(num2);
        this.add(equal);
        this.add(result);
        this.add(add);
        this.add(sub);
        this.add(mul);
        this.add(div);
        this.add(OK);

        // 设置名字
        this.setTitle("Calculator");
        // 设置窗口大小
        this.setSize(600, 300);
        // 设置窗口默认关闭状态为EXIT_ON_CLOSE，即直接关闭应用程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /* 添加监听器函数 */
    public void listener() {
        operatorListener opListener = new operatorListener();
        add.addActionListener(opListener);
        sub.addActionListener(opListener);
        mul.addActionListener(opListener);
        div.addActionListener(opListener);

        OKListener okListener = new OKListener();
        OK.addActionListener(okListener);
    }

    /* 加减乘除运算符按钮监听器
     * 使 operator 显示所选择运算符
     */
    private class operatorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedOp = e.getActionCommand();
            operator.setText(selectedOp);
        }
    }

    /* OK按钮监听器
     * 若已选择运算符，则根据运算符进行计算，结果赋予 result；
     * 否则，result 为零
     */
    private class OKListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedOp = operator.getText();
            double n1 = Double.parseDouble(num1.getText());
            double n2 = Double.parseDouble(num2.getText());
            double n3 = 0;
            DecimalFormat df = new DecimalFormat("#.00"); 

            if (selectedOp.equals("+")) {
                n3 = n1 + n2;
            } else if (selectedOp.equals("-")) {
                n3 = n1 - n2;
            } else if (selectedOp.equals("*")) {
                n3 = n1 * n2;
            } else if (selectedOp.equals("/")) {
                n3 = n1 / n2;
            }
            result.setText(df.format(n3));
        }
    }
}
