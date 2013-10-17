import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.*;

import javax.swing.*;

class RoundButton extends JButton 
{ //扩展按钮类，使按钮边框画出圆
	int hitFlag=0;
   
//     画圆的背景和标签
   public RoundButton()
   {
	   super();
	   Dimension size = getPreferredSize();
	   size.width = Math.max(size.width,
	   size.height);
	    size.height = size.width/3;
	   setPreferredSize(size);
	   //setBackground(Color.red);
//	    这个调用使JButton不画背景，而允许我们画一个圆的背景。
	   setContentAreaFilled(false);
	   this.addMouseListener(new MouseAdapter(){
		   /*
	       public void mouseEntered(MouseEvent arg0) {    //鼠标进入的效果，为了显示的稍微象按钮    
	           setBackground(Color.GRAY);
	       }
	       /*
	       public void mouseExited(MouseEvent arg0) { //鼠标离开后
	           setBackground(Color.GRAY);
	       }
	       */
		   /*
	       public void mouseClicked(MouseEvent arg0)
	       {
	    	   setBackground(Color.red);
	       }
	       */
	       public void mousePressed(MouseEvent arg0)
	       {
	    	   //setBackground(getBackground());
	    	   /*
	    	   if(playerFlag==1)
	    	   {
	    		   setBackground(Color.red);
	    	   }
	    	   else if(playerFlag==2)
	    	   {
	    		   setBackground(Color.blue);
	    	   }
	    	   */
	    	   
	       }
	   });
   }
   

   
   public void setHit(int i)
   {
	   hitFlag=i;
   }
   
   protected void paintComponent(Graphics g) {
	   
   /*
   if (getModel().isArmed()) 
   {
//     你可以选一个高亮的颜色作为圆形按钮类的属性
       g.setColor(Color.red);
	   /*
	   if(playerFlag==1)
	   {
		   g.setColor(Color.red);
	   }
	   else if(playerFlag==2)
	   {
		   g.setColor(Color.blue);
	   }
	   
	   
   } 
   else 
   {
	   g.setColor(getBackground());
   }
   */
	   //g.setColor(new Color(123,12,23));
       g.setColor(getBackground());
   g.fillOval(2, 2, getSize().width-4,
   getSize().height-4);
//    这个调用会画一个标签和焦点矩形。
   //super.paintComponent(g);
   }
   

//     用简单的弧画按钮的边界。
   protected void paintBorder(Graphics g) {
       
   g.setPaintMode();
   //g.setColor(Color.gray);
   //g.drawOval(0, 0, getSize().width-1,
   //getSize().height-1);
   }

//     侦测点击事件
   Shape shape;
   public boolean contains(int x, int y) {
//     如果按钮改变大小，产生一个新的形状对象。
   if (shape == null || !shape.getBounds().equals(getBounds())) {
   shape = new Ellipse2D.Float(2,2,getWidth()-4,getHeight()-4);
   }
   return shape.contains(x, y);
   }
   
   } 