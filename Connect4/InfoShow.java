import javax.swing.*;//信息提示（如 该谁下，谁赢）
import java.awt.*;

public class InfoShow extends JPanel {
 
	private String Player1Name="玩家1";
	 
	private String Player2Name="玩家2";
	 
	private int PlayerFlag=1;
	
	public int WinFlag=0;
	
	public int EqualFlag=0;
	
	private JLabel label=new JLabel("");
	
	
	String imagePath = "res/info.jpg";
	
	ImagePanel panel;
	
	public InfoShow()
	{
		
		panel=new ImagePanel(imagePath);
		Font font=new Font("黑体",Font.BOLD,20);
		label.setFont(font);
		this.setLayout(null);
		
		
		
		this.add(label);
		this.add(panel);
		label.setBounds(10,25,120,30);
		panel.setBounds(0,0,160,80);
	}
	 
	public void ShowMessage() 
	{
		if(WinFlag==0&&EqualFlag==0)
		{
			if(PlayerFlag==1)
			{
				label.setText(Player1Name+"下棋");
				//this.add(label);
			}
			else
			{
				label.setText(Player2Name+"下棋");
				//this.add(label);
			}
		}
	}
	 
	public void SetP1Name(String Name) {
		Player1Name=Name;
	}
	 
	public void SetP2Name(String Name) {
		Player2Name=Name;
	}
	 
	public void SetPlayerFlag(int id) 
	{
		PlayerFlag=id;
	}
	
	public void ShowWin()
	{
		WinFlag=1;
		if(PlayerFlag==1)
		{
			label.setText(Player1Name+"赢了");
			//this.add(label);
		}
		else
		{
			label.setText(Player2Name+"赢了");
			//this.add(label);
		}
		
	}
	
	public void ShowEqual()
	{
		
			label.setText("平局!");
	}
	
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		int width=getWidth();
		int height=getHeight();
		
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);
		
		
	}
}
 
