import javax.imageio.ImageIO; //玩家信息显示（如玩家名称，棋子颜色）
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;



public class UserInfo extends JPanel {
 
	public String m_Name;
	 
	public Color m_Color;
	 
	public JLabel m_NameCtrl;
	 
	public JLabel m_ColorCtrl;
	
	public RoundButton m_ColorBtn;
	
	String imagePath = "res/user.jpg";
	
	ImagePanel panel;
	
	public UserInfo(String name,Color color)
	{
		m_Name=name;
		m_Color=color;
		
		InitUser();
	}
	 
	public void SetName(String name) {
		m_Name=name;
	}
	 
	public void SetColor(Color color) {
		m_Color=color;
	}
	 
	public void InitUser()
	{
		Font font=new Font("黑体",Font.BOLD,16);
		if(m_NameCtrl==null)
		{
			m_NameCtrl=new JLabel();
			m_NameCtrl.setFont(font);
			m_NameCtrl.setText("玩家姓名:"+m_Name);
		}
		
		if(m_ColorCtrl==null)
		{
			m_ColorCtrl=new JLabel();
			m_ColorCtrl.setFont(font);
			m_ColorCtrl.setText("玩家颜色:");
		}
		m_ColorBtn=new RoundButton();
		m_ColorBtn.setBackground(m_Color);
		panel=new ImagePanel(imagePath);
		
		this.setLayout(null);
		this.add(m_NameCtrl);
		this.add(m_ColorCtrl);
		this.add(m_ColorBtn);
		this.add(panel);
		m_NameCtrl.setBounds(10,10,120,30);
		m_ColorCtrl.setBounds(10,30,120,30);
		m_ColorBtn.setBounds(60,60,30,30);
		panel.setBounds(0,0,160,100);
	}
	
	public void UpdateUserInfo()
	{
		Font font=new Font("黑体",Font.BOLD,18);
		
			m_NameCtrl=new JLabel();
			m_NameCtrl.setFont(font);
			m_NameCtrl.setText("玩家姓名:"+m_Name);
		
			m_ColorCtrl=new JLabel();
			m_ColorCtrl.setFont(font);
			m_ColorCtrl.setText("玩家颜色:");
		
		m_ColorBtn=new RoundButton();
		m_ColorBtn.setBackground(m_Color);
		panel=new ImagePanel(imagePath);
		
		this.setLayout(null);
		this.add(m_NameCtrl);
		this.add(m_ColorCtrl);
		this.add(m_ColorBtn);
		this.add(panel);
		m_NameCtrl.setBounds(10,10,120,30);
		m_ColorCtrl.setBounds(10,30,120,30);
		m_ColorBtn.setBounds(60,60,30,30);
		panel.setBounds(0,0,160,100);
	}
	protected void paintComponent(Graphics g)
	{
		
		
		
		super.paintComponent(g);
		//int verticalStart[2];
		int width=getWidth();
		int height=getHeight();
		
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);
		
		
	}
}
 
