import javax.swing.JPanel;//������Ϸ�����Ի���
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.*;
import javax.swing.*;

public class SetDialog extends JDialog {

	private static final long serialVersionUID = 1L;//

	private JPanel jContentPane = null;//��ǰ���

	private JLabel jLabel = null;//��1����ҵ���Ϣ

	private JLabel jLabel1 = null;//��1����ҵ�����

	private JTextField jTextField = null;//�������1������

	private JLabel jLabel2 = null;//��ʾ��1�����ѡ����ɫ

	private JButton jButton = null;//ѡ�����1������ɫ

	private JLabel jLabel3 = null;//��2����ҵ���Ϣ

	private JLabel jLabel4 = null;//��2����ҵ�����

	private JTextField jTextField1 = null;//�������2������

	private JLabel jLabel5 = null;//��ʾ��2�����ѡ����ɫ

	private JButton jButton1 = null;//ѡ�����2������ɫ

	private JLabel jLabel6 = null;//��սģʽ

	private JRadioButton jRadioButton = null;//ѡ�����˶�ս

	private JRadioButton jRadioButton1 = null;//ѡ���˻���ս

	private JButton jButton2 = null;//ȷ����ť

	private JButton jButton3 = null;//ȡ����ť
	
	////////////��������Ϣ///////////
	public String user1name,user2name;
	public Color user1color,user2color;
	
	
	
	public UserInfo user1,user2;
	public InfoShow info;
	public Mode PlayMode;
	
	ButtonGroup group=new ButtonGroup();  
	

	
	public SetDialog(Frame owner) {
		super(owner);
		initialize();
	}
	
	public SetDialog(Frame owner,Mode playmode,UserInfo user1,UserInfo user2,InfoShow info) {
		super(owner);
		
		this.PlayMode=playmode;
		this.user1=user1;
		this.user2=user2;
		this.info=info;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	//��ʼ����Ϣ
	private void initialize() {
		group.add(getJRadioButton());
		group.add(getJRadioButton1());
		getJRadioButton1().setSelected(true);
		this.setTitle("����");
		this.setSize(300, 263);
		///////////////////////
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int ScreenWidth=screenSize.width;
		int ScreenHeight=screenSize.height;
		
		int x=(ScreenWidth-this.getWidth())/2;
		int y=(ScreenHeight-this.getHeight())/2;
		this.setLocation(x, y);
		//////////////////////
		
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	//�������úõ����
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(25, 130, 61, 18));
			jLabel6.setText("��սģʽ:");
			jLabel5 = new JLabel();
			jLabel5.setBounds(new Rectangle(155, 94, 53, 17));
			jLabel5.setText("��ɫ:");
			jLabel4 = new JLabel();
			jLabel4.setBounds(new Rectangle(23, 97, 38, 16));
			jLabel4.setText("����:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(24, 71, 65, 17));
			jLabel3.setText("���2��Ϣ:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(158, 43, 49, 17));
			jLabel2.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jLabel2.setText("��ɫ:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(24, 42, 37, 17));
			jLabel1.setText("����:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(24, 16, 64, 17));
			jLabel.setText("���1��Ϣ:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setName("����");
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJTextField(), null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(jLabel3, null);
			jContentPane.add(jLabel4, null);
			jContentPane.add(getJTextField1(), null);
			jContentPane.add(jLabel5, null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(jLabel6, null);
			jContentPane.add(getJRadioButton(), null);
			jContentPane.add(getJRadioButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	//������ʾ���ҡ�JTextField
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField("��");
			jTextField.setBounds(new Rectangle(73, 43, 62, 17));
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	//�������1ѡ����ɫJButton
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(222, 43, 63, 18));
			jButton.setBackground(Color.blue);
			jButton.setText("ѡ��");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					JColorChooser color1=new JColorChooser();
					user1color=color1.showDialog(color1, "���1��ɫ", Color.blue);
					if(user1color==null)
						user1color=Color.blue;
					
						jButton.setBackground(user1color);
					
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	//������ʾ�����ԡ�JTextField
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField("����");
			jTextField1.setBounds(new Rectangle(74, 95, 62, 17));
		}
		return jTextField1;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	//�������2ѡ����ɫJButton
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(223, 93, 62, 19));
			jButton1.setText("ѡ��");
			jButton1.setBackground(Color.red);
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					JColorChooser color2=new JColorChooser();
					user2color=color2.showDialog(color2, "���2��ɫ", Color.red);
					if(user2color==null)
						user2color=Color.red;
					
						jButton1.setBackground(user2color);
				}
				
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
   //	������ʾ�����˶�ս��JRadioButton
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setBounds(new Rectangle(25, 158, 84, 19));
			jRadioButton.setText("���˶�ս");
			jRadioButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText("����");
					jTextField1.setText("����");
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				//PlayMode.PlayMode=1;
				}
			});
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
     //	������ʾ���˻���ս��JRadioButton
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setBounds(new Rectangle(134, 157, 82, 21));
			jRadioButton1.setText("�˻���ս");
			jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText("��");
					jTextField1.setText("����");
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				//PlayMode.PlayMode=0;
				}
			});
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	//����ȷ��JButton
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(119, 201, 68, 23));
			jButton2.setText("ȷ��");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				user1name=getJTextField().getText();
				user2name=getJTextField1().getText();
				
				//user1.m_Name=user1name;
				//user1.m_Color=user1color;
				user1.SetName(user1name);
				user1.SetColor(user1color);
				
				user2.SetName(user2name);
				user2.SetColor(user2color);
				//user2.m_Name=user2name;
				//user2.m_Color=user2color;
				
				user1.m_NameCtrl.setText("�������:"+user1name);
				if(user1color==null)
				{
					user1color=Color.blue;
				    
				}
				
				user1.m_Color=user1color;
				user1.m_ColorBtn.setBackground(user1color);
				
				user2.m_NameCtrl.setText("�������:"+user2name);
				if(user2color==null)
				{
					user2color=Color.red;
				    
				}
				user2.m_Color=user2color;
				user2.m_ColorBtn.setBackground(user2color);
				
				info.SetP1Name(user1name);
				info.SetP2Name(user2name);

                                if(jRadioButton.isSelected())
				{
					PlayMode.PlayMode=1;
				}
				else if(jRadioButton1.isSelected())
				{
					PlayMode.PlayMode=0;
				}  
				
				dispose();
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jButton3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	//����ȡ��JButton
	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(211, 200, 71, 25));
			jButton3.setText("ȡ��");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					/*
					user1name=getJTextField().getText();
					user2name=getJTextField1().getText();
					
					//user1.m_Name=user1name;
					//user1.m_Color=user1color;
					user1.SetName(user1name);
					user1.SetColor(user1color);
					
					user2.SetName(user2name);
					user2.SetColor(user2color);
					//user2.m_Name=user2name;
					//user2.m_Color=user2color;
					
					user1.m_NameCtrl.setText("�������:"+user1name);
					if(user1color==null)
					{
						user1color=Color.blue;
					    
					}
					
					user1.m_Color=user1color;
					user1.m_ColorBtn.setBackground(user1color);
					
					user2.m_NameCtrl.setText("�������:"+user2name);
					if(user2color==null)
					{
						user2color=Color.red;
					    
					}
					user2.m_Color=user2color;
					user2.m_ColorBtn.setBackground(user2color);
					
					info.SetP1Name(user1name);
					info.SetP2Name(user2name);
					*/
				dispose();
				}
			});
			
		}
		return jButton3;
	}
	
	//�����������
	public String setUser1Name()
	{
		return user1name;
	}
	
	

}  //  @jve:decl-index=0:visual-constraint="10,10"
