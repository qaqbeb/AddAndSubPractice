package UI;
import Problem.*;
import AddAndSubPractice.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Visual {

	private static Problem p;				//题目
	private static JFrame frame = new JFrame("100以内加减法练习小软件");	//框架
	private static Timer timer = null;		//计时器
	private static int total = 0;			//答题总数
	private static int ture_sum = 0;		//做对的题目数
	private static boolean status = false;	//答题状态
	
	public static void visualize() {
        // 设置窗口长和宽
        frame.setSize(533, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        @SuppressWarnings("serial")
		JPanel panel = new JPanel(){//关键代码，就是重写了paint的一个方法
            @Override
            protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 ImageIcon img = new ImageIcon("src/image/1.jpg");
                 //图片路径
                 img.paintIcon(this, g, 0, 0);
            }
       };;    
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
        Font f3 = new Font("宋体",Font.BOLD,50);
        
        // 创建 JLabel
        //程序标签
        JLabel Label1 = new JLabel("小学生加减法练习小程序");
        Label1.setBounds(10,20,400,25);
        Label1.setFont(f1);
        Label1.setForeground(Color.GREEN);
        panel.add(Label1);
        
        //答案标签
        JLabel Label2 = new JLabel("答案");
        Label2.setBounds(10,200,80,25);
        panel.add(Label2);
        
        //解析标签
        JLabel Label3 = new JLabel("解析");
        Label3.setBounds(10,250,300,25);
        panel.add(Label3);
        
        //计时器标签
        JLabel Label4 = new JLabel("TIME");
        Label4.setBounds(300,100,300,50);
        Label4.setFont(f3);
        Label4.setForeground(Color.BLACK);
        panel.add(Label4);
        
        //做对的题目数
        JLabel Label5 = new JLabel("0");
        Label5.setBounds(400,10,30,50);
        Label5.setFont(f3);
        Label5.setForeground(Color.RED);
        panel.add(Label5);
        
        //总题数
        JLabel Label6 = new JLabel("|0");
        Label6.setBounds(430,10,60,50);
        Label6.setFont(f3);
        panel.add(Label6);
        
        //数一
        JLabel num1 = new JLabel("...");
        num1.setBounds(100, 90, 40, 40);
        num1.setForeground(Color.red);
        num1.setFont(f2);
        panel.add(num1);
        
        //数二
        JLabel num2 = new JLabel("...");
        num2.setBounds(100, 140, 40, 40);
        num2.setForeground(Color.RED);
        num2.setFont(f2);
        panel.add(num2);
        
        //运算符
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
        submitButton.setBounds(300, 200, 100, 25);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
        	//添加监听器
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p == null) {
					JOptionPane.showMessageDialog(frame, "在提交前请先开始做题", "错误", 0);
					return;
				}
				if(!status) {
					JOptionPane.showMessageDialog(frame, "请勿重复答题", "错误", 0);
					return;
				}
				
				if(ans.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "请先在答题框内作答", "错误", 0);
					return;
				}
					
				String answer = String.valueOf(p.Calculate());
				if(answer.equals(ans.getText())) {
					Label3.setText("恭喜你，回答正确！！");
					ture_sum++;
					Label5.setText(String.valueOf(ture_sum));
				}
				else
					Label3.setText("错误，正确答案应该是" + answer);
				status = false;
				
			}
        });
        
        //下一题按钮
        JButton nextproblem = new JButton("开始做题");
        nextproblem.setBounds(300, 175, 100, 25);
        panel.add(nextproblem);
        nextproblem.addActionListener(new ActionListener() {
        	//添加监听器
			@Override
			public void actionPerformed(ActionEvent e) {
				p = ProblemGenerator.Generate();
				num1.setText(String.valueOf(p.getnum1()));
				num2.setText(String.valueOf(p.getnum2()));
				op.setText(String.valueOf(p.getop()));
				nextproblem.setText("下一题");
				total++;
				Label6.setText("|" + String.valueOf(total));
				status = true;
			}
        });
        
        
        /*
         * -----------------------------------------------------------------------------------------------
         * 以下是增量一内容
         * */
        //获取当前时间按钮
        JButton gettime = new JButton("开始计时");
        gettime.setBounds(300, 70, 150, 25);
        panel.add(gettime);
        gettime.addActionListener(new ActionListener() {
        	//添加监听器
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer != null)	//如果任务已经在进行，则丢弃
					timer.cancel();
				timer = new Timer();
				TimeKeeper tk = new TimeKeeper(Label4);
				timer.schedule(tk, new Date(), 1000);//每1000毫秒更新一次计时器的值
				gettime.setText("重新开始计时");
			}
        });
        
        JButton stop = new JButton("停止计时");
        stop.setBounds(300, 150, 150, 25);
        panel.add(stop);
        stop.addActionListener(new ActionListener() {
        	//添加监听器
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.cancel();//停止计时
				timer = new Timer();
			}
        });
        /*
         * -----------------------------------------------------------------------------------------------
         * */
    }
}
