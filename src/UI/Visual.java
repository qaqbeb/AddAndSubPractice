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

	private static Problem p;				//��Ŀ
	private static JFrame frame = new JFrame("100���ڼӼ�����ϰС���");	//���
	private static Timer timer = null;		//��ʱ��
	private static int total = 0;			//��������
	private static int ture_sum = 0;		//���Ե���Ŀ��
	private static boolean status = false;	//����״̬
	
	public static void visualize() {
        // ���ô��ڳ��Ϳ�
        frame.setSize(533, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        @SuppressWarnings("serial")
		JPanel panel = new JPanel(){//�ؼ����룬������д��paint��һ������
            @Override
            protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 ImageIcon img = new ImageIcon("src/image/1.jpg");
                 //ͼƬ·��
                 img.paintIcon(this, g, 0, 0);
            }
       };;    
        // ������
        frame.add(panel);
        placeComponents(panel);
        // ���ý���ɼ�
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        Font f1 = new Font("����",Font.BOLD,20);
        Font f2 = new Font("����",Font.BOLD,30);
        Font f3 = new Font("����",Font.BOLD,50);
        
        // ���� JLabel
        //�����ǩ
        JLabel Label1 = new JLabel("Сѧ���Ӽ�����ϰС����");
        Label1.setBounds(10,20,400,25);
        Label1.setFont(f1);
        Label1.setForeground(Color.GREEN);
        panel.add(Label1);
        
        //�𰸱�ǩ
        JLabel Label2 = new JLabel("��");
        Label2.setBounds(10,200,80,25);
        panel.add(Label2);
        
        //������ǩ
        JLabel Label3 = new JLabel("����");
        Label3.setBounds(10,250,300,25);
        panel.add(Label3);
        
        //��ʱ����ǩ
        JLabel Label4 = new JLabel("TIME");
        Label4.setBounds(300,100,300,50);
        Label4.setFont(f3);
        Label4.setForeground(Color.BLACK);
        panel.add(Label4);
        
        //���Ե���Ŀ��
        JLabel Label5 = new JLabel("0");
        Label5.setBounds(400,10,30,50);
        Label5.setFont(f3);
        Label5.setForeground(Color.RED);
        panel.add(Label5);
        
        //������
        JLabel Label6 = new JLabel("|0");
        Label6.setBounds(430,10,60,50);
        Label6.setFont(f3);
        panel.add(Label6);
        
        //��һ
        JLabel num1 = new JLabel("...");
        num1.setBounds(100, 90, 40, 40);
        num1.setForeground(Color.red);
        num1.setFont(f2);
        panel.add(num1);
        
        //����
        JLabel num2 = new JLabel("...");
        num2.setBounds(100, 140, 40, 40);
        num2.setForeground(Color.RED);
        num2.setFont(f2);
        panel.add(num2);
        
        //�����
        JLabel op = new JLabel("+");
        op.setBounds(50, 150, 30, 30);
        op.setForeground(Color.RED);
        op.setFont(f2);
        panel.add(op);
        
        //�����ı�������ѧ�������
        JTextField ans = new JTextField(20);
        ans.setBounds(50,200,165,25);
        panel.add(ans);
        
        
        // �ύ�𰸰�ť
        JButton submitButton = new JButton("�ύ");
        submitButton.setBounds(300, 200, 100, 25);
        panel.add(submitButton);
        submitButton.addActionListener(new ActionListener() {
        	//��Ӽ�����
			@Override
			public void actionPerformed(ActionEvent e) {
				if(p == null) {
					JOptionPane.showMessageDialog(frame, "���ύǰ���ȿ�ʼ����", "����", 0);
					return;
				}
				if(!status) {
					JOptionPane.showMessageDialog(frame, "�����ظ�����", "����", 0);
					return;
				}
				
				if(ans.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "�����ڴ����������", "����", 0);
					return;
				}
					
				String answer = String.valueOf(p.Calculate());
				if(answer.equals(ans.getText())) {
					Label3.setText("��ϲ�㣬�ش���ȷ����");
					ture_sum++;
					Label5.setText(String.valueOf(ture_sum));
				}
				else
					Label3.setText("������ȷ��Ӧ����" + answer);
				status = false;
				
			}
        });
        
        //��һ�ⰴť
        JButton nextproblem = new JButton("��ʼ����");
        nextproblem.setBounds(300, 175, 100, 25);
        panel.add(nextproblem);
        nextproblem.addActionListener(new ActionListener() {
        	//��Ӽ�����
			@Override
			public void actionPerformed(ActionEvent e) {
				p = ProblemGenerator.Generate();
				num1.setText(String.valueOf(p.getnum1()));
				num2.setText(String.valueOf(p.getnum2()));
				op.setText(String.valueOf(p.getop()));
				nextproblem.setText("��һ��");
				total++;
				Label6.setText("|" + String.valueOf(total));
				status = true;
			}
        });
        
        
        /*
         * -----------------------------------------------------------------------------------------------
         * ����������һ����
         * */
        //��ȡ��ǰʱ�䰴ť
        JButton gettime = new JButton("��ʼ��ʱ");
        gettime.setBounds(300, 70, 150, 25);
        panel.add(gettime);
        gettime.addActionListener(new ActionListener() {
        	//��Ӽ�����
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer != null)	//��������Ѿ��ڽ��У�����
					timer.cancel();
				timer = new Timer();
				TimeKeeper tk = new TimeKeeper(Label4);
				timer.schedule(tk, new Date(), 1000);//ÿ1000�������һ�μ�ʱ����ֵ
				gettime.setText("���¿�ʼ��ʱ");
			}
        });
        
        JButton stop = new JButton("ֹͣ��ʱ");
        stop.setBounds(300, 150, 150, 25);
        panel.add(stop);
        stop.addActionListener(new ActionListener() {
        	//��Ӽ�����
			@Override
			public void actionPerformed(ActionEvent e) {
				timer.cancel();//ֹͣ��ʱ
				timer = new Timer();
			}
        });
        /*
         * -----------------------------------------------------------------------------------------------
         * */
    }
}
