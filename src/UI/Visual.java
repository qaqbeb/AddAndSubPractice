package UI;
import Problem.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Visual {

	private static Problem p;
	private static JFrame frame = new JFrame("100以内加减法练习小软件");
	
	public static void visualize() {
        // 设置窗口长和宽
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();    
        // 添加面板
        frame.add(panel);
        placeComponents(panel);
        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        Font f1 = new Font("宋体",Font.BOLD,20);
        Font f2 = new Font("宋体",Font.BOLD,30);
        // 创建 JLabel
        JLabel Label1 = new JLabel("小学生加减法练习小程序");
        Label1.setBounds(10,20,400,25);
        Label1.setFont(f1);
        Label1.setForeground(Color.GREEN);
        panel.add(Label1);
        JLabel Label2 = new JLabel("答案");
        Label2.setBounds(10,200,80,25);
        panel.add(Label2);
        JLabel Label3 = new JLabel("解析");
        Label3.setBounds(10,250,300,25);
        panel.add(Label3);
        JLabel num1 = new JLabel("100");
        num1.setBounds(100, 90, 40, 40);
        num1.setForeground(Color.YELLOW);
        num1.setFont(f2);
        panel.add(num1);
        JLabel num2 = new JLabel("100");
        num2.setBounds(100, 140, 40, 40);
        num2.setForeground(Color.YELLOW);
        num2.setFont(f2);
        panel.add(num2);
        JLabel op = new JLabel("+");
        op.setBounds(50, 150, 30, 30);
        op.setForeground(Color.RED);
        op.setFont(f2);
        panel.add(op);
        
        //创建文本域用于学生输入答案
        JTextField ans = new JTextField(20);
        ans.setBounds(50,200,165,25);
        panel.add(ans);
        
        
        // 提交答案按钮
        JButton submitButton = new JButton("提交");
        submitButton.setBounds(300, 200, 80, 25);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p == null) {
					JOptionPane.showMessageDialog(
							frame,
	                        "在提交前请先选择题目",
	                        "错误",
	                        JOptionPane.WARNING_MESSAGE
							);
				}
				String answer = String.valueOf(p.Calculate());
				if(answer.equals(ans.getText())) {
					Label3.setText("正确");
				}
				else
					Label3.setText("错误，正确答案应该是" + answer);
				
			}
        });
        
        JButton nextproblem = new JButton("下一题");
        nextproblem.setBounds(300, 175, 80, 25);
        panel.add(nextproblem);
        nextproblem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = ProblemGenerator.Generate();
				num1.setText(String.valueOf(p.getnum1()));
				num2.setText(String.valueOf(p.getnum2()));
				op.setText(String.valueOf(p.getop()));
			}
        });
    }
}
