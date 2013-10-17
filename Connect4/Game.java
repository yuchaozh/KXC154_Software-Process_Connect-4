//import java.util.Map;
import javax.swing.*;

import java.lang.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener{
 
	private int m_Columns=8;//���̲���9��8��                
	private int m_Rows=9;
	
	private int m_PlayerFlag;//�����־λ
	
	private Mode m_PlayMode;//��սģʽ��Ĭ���˻���ս��
	 
	private Map m_Map;      //���Ӱڷ�
	 
	private Table m_Table;  //����
	 
	private RoundButton[][] m_RoundButton;//����
	
	private int m_WinFlag=0;
	 
	private JButton m_SetGame;//���ð�Ŧ
	 
	private JButton m_StartGame;//��ʼ��Ŧ
	 
	private JButton m_NewGame;//���¿�ʼ��Ŧ
	 
	private JButton m_Exit;   //������Ŧ
	 
	private InfoShow m_InfoBoard;//��Ϣ��ʾ��
	 
	private UserInfo m_User1Board,m_User2Board;//�����Ϣ
	
	private SetDialog m_dialog;
	
	
	
	String imagePath = "res/bk.jpg";//����ͼ������
	ImagePanel panel;
	
	
	public Game()
	{
		
		InitGame();
	}
	//��ʼ����Ϸ 
	public void InitGame() 
	{
		m_PlayerFlag=1;
		Container container=getContentPane();
		
		
		GridLayout tableLayout=new GridLayout(m_Rows,m_Columns);
		
		m_PlayMode=new Mode();
		//��ʼ���֣������Ϣ����ʾ��Ϣ
		m_Table=new Table(tableLayout);// ����
		m_Table.setBackground(Color.white);
		
		m_InfoBoard=new InfoShow();
		m_RoundButton=new RoundButton[m_Rows][m_Columns];
		
		m_User1Board=new UserInfo("��",Color.blue);
		m_User2Board=new UserInfo("����",Color.red);
		
		m_InfoBoard.SetP1Name(m_User1Board.m_Name);
		m_InfoBoard.SetP2Name(m_User2Board.m_Name);
		
		//��Ӱ�Ŧ ��LISTENER
		ImageIcon StartIcon=new ImageIcon("res/start.jpg");
		ImageIcon NewIcon=new ImageIcon("res/new.jpg");
		ImageIcon ExitIcon=new ImageIcon("res/exit.jpg");
		ImageIcon SetIcon=new ImageIcon("res/set.jpg");
		
		m_SetGame=new JButton(SetIcon);
		m_SetGame.addActionListener(this);
		
		m_StartGame=new JButton(StartIcon);
		m_StartGame.addActionListener(this);
		
		m_NewGame=new JButton(NewIcon);
		m_NewGame.addActionListener(this);
		
		m_Exit=new JButton(ExitIcon);
		m_Exit.addActionListener(this);
		
		//��table������������ӣ���Ŧ���棩
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				m_RoundButton[i][j]=new RoundButton();
				
				m_RoundButton[i][j].addActionListener(this);
				
				m_RoundButton[i][j].setEnabled(false);
				
				m_Table.add(m_RoundButton[i][j]);
			}
		}
		
		//��ʾ��������
		panel=new ImagePanel(imagePath);
		
		
		//this.add(panel);
		
		
		//������г�ʼ���Ķ���
		container.add(m_StartGame);
		container.add(m_NewGame);
		container.add(m_SetGame);
		container.add(m_Exit);
		container.add(m_Table);
		container.add(m_InfoBoard);
		container.add(m_User1Board);
		container.add(m_User2Board);
		container.add(panel);
		container.setLayout(null);
		m_Table.setBounds(20,20,m_Columns*48,m_Rows*48);
		m_InfoBoard.setBounds(440,200,160,80);
		m_User1Board.setBounds(440,20,160,100);
		m_User2Board.setBounds(440,360,160,100);
		
		m_StartGame.setBounds(20,480,79,38);
		m_NewGame.setBounds(120,480,79,38);
		m_Exit.setBounds(218,480,79,38);
		m_SetGame.setBounds(316,480,85,38);
		
		panel.setBounds(0,0,640, 580);
	}
	
	//������Ϸ���� �������ɫ����սģʽ��
	public void SetGame() 
	{
		m_dialog=new SetDialog(this,m_PlayMode,m_User1Board,m_User2Board,m_InfoBoard);
		m_dialog.show();
		
		//m_User1Board.UpdateUserInfo();
		//m_User2Board.UpdateUserInfo();
		m_InfoBoard.SetP1Name(m_User1Board.m_Name);
		m_InfoBoard.SetP2Name(m_User2Board.m_Name);
		
	}
	 
	//��ʼ��Ϸ
	public void StartGame() 
	{
		m_Map=new Map(m_Rows,m_Columns);
		m_InfoBoard.ShowMessage();
		
		
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				
				m_RoundButton[i][j].setEnabled(true);
				
			}
		}
		m_StartGame.setEnabled(false);
	}
	
	//��ֹ��Ϸ
	public void StopGame()
	{
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				
				m_RoundButton[i][j].setEnabled(false);
				
			}
		}
	}
	 
	 //���¿�ʼ��Ϸ
	public void NewGame() 
	{
		//InitGame();
		//StartGame();
		m_WinFlag=0;
		m_InfoBoard.EqualFlag=0;
		m_PlayerFlag=1;
		m_InfoBoard.SetPlayerFlag(m_PlayerFlag);
		m_InfoBoard.WinFlag=0;
		m_Map=new Map(m_Rows,m_Columns);
		m_InfoBoard.ShowMessage();
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				
				m_RoundButton[i][j].setEnabled(true);
				m_RoundButton[i][j].hitFlag=0;
				m_RoundButton[i][j].setBackground(getBackground());
				
				
			}
		}
	}
	
	//�˳���Ϸ
	public void Exit() 
	{
		dispose();
	}
	
	//���ACTION
	public void actionPerformed(ActionEvent e) 
	{
		// Object obj = e.getSource();
		if (e.getSource().equals(m_StartGame))
		{
			StartGame();
		}
		
		if (e.getSource().equals(m_SetGame))
		{
			SetGame();
		}
		
		if (e.getSource().equals(m_NewGame))
		{
			NewGame();
		}
		
		if (e.getSource().equals(m_Exit))
		{
			Exit();
		}
        
		//��ÿ���������ACTION��������壩
		for (int i = 0; i < m_Rows; i++) 
		{
			for (int j = 0; j < m_Columns; j++) 
			{
				if (e.getSource().equals(m_RoundButton[i][j])) 
				{ 
					//���˶�սģʽ
					if (m_PlayMode.PlayMode == 1) 
					{
						System.out.println("mousePressed()");
						//�жϵ�ǰ����Ƿ�����ӣ�1���£�0��
						if (m_PlayerFlag == 1) 
						{
							if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
							{
								m_RoundButton[m_Map.Place(j)][j]
										.setBackground(m_User1Board.m_Color);
								m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
								
								m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//���õ�ͼ
								
								m_Map.m_Count--;
								
								if(m_Map.IsEqual())//�ж�ƽ��
								{
									System.out.println("equal");
									m_InfoBoard.EqualFlag=1;
									m_InfoBoard.ShowEqual();
								}
								
								//�ж��Ƿ��Ӯ
								if(m_Map.IsWin(m_Map.Place(j),j,m_PlayerFlag))
								{
									System.out.println("end");
									m_InfoBoard.ShowWin();
									StopGame();
								}
								
								
								m_Map.AddPlace(j);
								m_PlayerFlag = 2;
								m_InfoBoard.SetPlayerFlag(2);
								m_InfoBoard.ShowMessage();
							}
						} 
						//����һ������
						else 
						{
							if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
							{
								m_RoundButton[m_Map.Place(j)][j]
										.setBackground(m_User2Board.m_Color);
								m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
								
								m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//���õ�ͼ
								
								
								
								m_Map.m_Count--;
								if(m_Map.IsEqual())//�ж�ƽ��
								{
									System.out.println("equal");
									m_InfoBoard.EqualFlag=1;
									m_InfoBoard.ShowEqual();
								}
								
								if(m_Map.IsWin(m_Map.Place(j),j,m_PlayerFlag))
								{
									System.out.println("end");
									m_InfoBoard.ShowWin();
									
									StopGame();
								}
								
								m_Map.AddPlace(j);
								
								m_PlayerFlag = 1;
								m_InfoBoard.SetPlayerFlag(1);
								m_InfoBoard.ShowMessage();
							}
						}
					} 
					//�˻���սģʽ
					else 
					{
                        //������ 
						if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
						{
							m_RoundButton[m_Map.Place(j)][j]
									.setBackground(m_User1Board.m_Color);
							m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
							
							
							m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//���õ�ͼ
							
							
							
							
							
							m_Map.m_Count--;
							if(m_Map.IsEqual())//�ж�ƽ��
							{
								System.out.println("equal");
								m_InfoBoard.EqualFlag=1;
								m_InfoBoard.ShowEqual();
							}
							
							
							//�ж��Ƿ��Ӯ
							if(m_Map.IsWin(m_Map.Place(j),j,m_PlayerFlag))
							{
								System.out.println("end");
								m_WinFlag=1;
								m_InfoBoard.ShowWin();
								StopGame();
							}
							
							m_Map.AddPlace(j);
							
							m_PlayerFlag = 2;
							m_InfoBoard.SetPlayerFlag(2);
							m_InfoBoard.ShowMessage();
						}

						// �������� 
						if (m_WinFlag==0&&m_PlayerFlag == 2) 
						{
							//Thread.currentThread().sleep(500);
							
							int temp = m_Map.ComputerAiPlace();
							
							while (m_RoundButton[m_Map.Place(temp)][temp].hitFlag != 0) {
								temp = m_Map.ComputerPlace();
							}
							

							m_RoundButton[m_Map.Place(temp)][temp]
									.setBackground(m_User2Board.m_Color);
							m_RoundButton[m_Map.Place(temp)][temp].hitFlag = m_PlayerFlag;
							
							
							m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(temp),temp);//���õ�ͼ
							
							
							
							m_Map.m_Count--;
							if(m_Map.IsEqual())//�ж�ƽ��
							{
								System.out.println("equal");
								m_InfoBoard.EqualFlag=1;
								m_InfoBoard.ShowEqual();
							}
							
							if(m_Map.IsWin(m_Map.Place(temp),temp,m_PlayerFlag))
							{
								System.out.println("end");
								m_InfoBoard.ShowWin();
								StopGame();
							}
							
							m_Map.AddPlace(temp);
							
							m_PlayerFlag = 1;							
							m_InfoBoard.SetPlayerFlag(1);
							m_InfoBoard.ShowMessage();
						}

					}
				}

			}
		}
	}
	
		/*
		 * JButton button = (JButton) e.getSource();
		 * 
		 * button.setBackground(Color.red);
		 * System.out.println("mousePressed()");
		 */

	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Game panel=new Game();
		panel.setTitle("Connect4");
		panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setSize(640, 600);
		
		//���д���
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int ScreenWidth=screenSize.width;
		int ScreenHeight=screenSize.height;
		
		int x=(ScreenWidth-panel.getWidth())/2;
		int y=(ScreenHeight-panel.getHeight())/2;
		panel.setLocation(x, y);
		
		panel.setVisible(true);

	}
	 
}


class Mode
{
	public int PlayMode=0;
	
}
 
