//import java.util.Map;
import javax.swing.*;

import java.lang.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener{
 
	private int m_Columns=8;//棋盘布局9行8列                
	private int m_Rows=9;
	
	private int m_PlayerFlag;//下棋标志位
	
	private Mode m_PlayMode;//对战模式（默认人机对战）
	 
	private Map m_Map;      //旗子摆放
	 
	private Table m_Table;  //布局
	 
	private RoundButton[][] m_RoundButton;//棋子
	
	private int m_WinFlag=0;
	 
	private JButton m_SetGame;//设置按纽
	 
	private JButton m_StartGame;//开始按纽
	 
	private JButton m_NewGame;//重新开始按纽
	 
	private JButton m_Exit;   //结束按纽
	 
	private InfoShow m_InfoBoard;//信息提示框
	 
	private UserInfo m_User1Board,m_User2Board;//玩家信息
	
	private SetDialog m_dialog;
	
	
	
	String imagePath = "res/bk.jpg";//布局图画背景
	ImagePanel panel;
	
	
	public Game()
	{
		
		InitGame();
	}
	//初始化游戏 
	public void InitGame() 
	{
		m_PlayerFlag=1;
		Container container=getContentPane();
		
		
		GridLayout tableLayout=new GridLayout(m_Rows,m_Columns);
		
		m_PlayMode=new Mode();
		//初始布局，玩家信息和提示消息
		m_Table=new Table(tableLayout);// 布局
		m_Table.setBackground(Color.white);
		
		m_InfoBoard=new InfoShow();
		m_RoundButton=new RoundButton[m_Rows][m_Columns];
		
		m_User1Board=new UserInfo("我",Color.blue);
		m_User2Board=new UserInfo("电脑",Color.red);
		
		m_InfoBoard.SetP1Name(m_User1Board.m_Name);
		m_InfoBoard.SetP2Name(m_User2Board.m_Name);
		
		//添加按纽 和LISTENER
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
		
		//在table布局中添加棋子（按纽代替）
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
		
		//显示整个背景
		panel=new ImagePanel(imagePath);
		
		
		//this.add(panel);
		
		
		//添加所有初始化的对象
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
	
	//设置游戏参数 （玩家颜色，对战模式）
	public void SetGame() 
	{
		m_dialog=new SetDialog(this,m_PlayMode,m_User1Board,m_User2Board,m_InfoBoard);
		m_dialog.show();
		
		//m_User1Board.UpdateUserInfo();
		//m_User2Board.UpdateUserInfo();
		m_InfoBoard.SetP1Name(m_User1Board.m_Name);
		m_InfoBoard.SetP2Name(m_User2Board.m_Name);
		
	}
	 
	//开始游戏
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
	
	//终止游戏
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
	 
	 //重新开始游戏
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
	
	//退出游戏
	public void Exit() 
	{
		dispose();
	}
	
	//添加ACTION
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
        
		//给每个棋子添加ACTION（如何下棋）
		for (int i = 0; i < m_Rows; i++) 
		{
			for (int j = 0; j < m_Columns; j++) 
			{
				if (e.getSource().equals(m_RoundButton[i][j])) 
				{ 
					//人人对战模式
					if (m_PlayMode.PlayMode == 1) 
					{
						System.out.println("mousePressed()");
						//判断当前玩家是否可下子（1可下，0否）
						if (m_PlayerFlag == 1) 
						{
							if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
							{
								m_RoundButton[m_Map.Place(j)][j]
										.setBackground(m_User1Board.m_Color);
								m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
								
								m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//设置地图
								
								m_Map.m_Count--;
								
								if(m_Map.IsEqual())//判断平局
								{
									System.out.println("equal");
									m_InfoBoard.EqualFlag=1;
									m_InfoBoard.ShowEqual();
								}
								
								//判断是否可赢
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
						//另外一人下子
						else 
						{
							if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
							{
								m_RoundButton[m_Map.Place(j)][j]
										.setBackground(m_User2Board.m_Color);
								m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
								
								m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//设置地图
								
								
								
								m_Map.m_Count--;
								if(m_Map.IsEqual())//判断平局
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
					//人机对战模式
					else 
					{
                        //人下子 
						if (m_RoundButton[m_Map.Place(j)][j].hitFlag == 0) 
						{
							m_RoundButton[m_Map.Place(j)][j]
									.setBackground(m_User1Board.m_Color);
							m_RoundButton[m_Map.Place(j)][j].hitFlag = m_PlayerFlag;
							
							
							m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(j),j);//设置地图
							
							
							
							
							
							m_Map.m_Count--;
							if(m_Map.IsEqual())//判断平局
							{
								System.out.println("equal");
								m_InfoBoard.EqualFlag=1;
								m_InfoBoard.ShowEqual();
							}
							
							
							//判断是否可赢
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

						// 电脑下子 
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
							
							
							m_Map.SetPlayer(m_PlayerFlag,m_Map.Place(temp),temp);//设置地图
							
							
							
							m_Map.m_Count--;
							if(m_Map.IsEqual())//判断平局
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
		
		//居中窗体
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
 
