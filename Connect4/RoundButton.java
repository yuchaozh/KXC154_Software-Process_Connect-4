import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.*;

import javax.swing.*;

class RoundButton extends JButton 
{ //��չ��ť�࣬ʹ��ť�߿򻭳�Բ
	int hitFlag=0;
   
//     ��Բ�ı����ͱ�ǩ
   public RoundButton()
   {
	   super();
	   Dimension size = getPreferredSize();
	   size.width = Math.max(size.width,
	   size.height);
	    size.height = size.width/3;
	   setPreferredSize(size);
	   //setBackground(Color.red);
//	    �������ʹJButton�������������������ǻ�һ��Բ�ı�����
	   setContentAreaFilled(false);
	   this.addMouseListener(new MouseAdapter(){
		   /*
	       public void mouseEntered(MouseEvent arg0) {    //�������Ч����Ϊ����ʾ����΢��ť    
	           setBackground(Color.GRAY);
	       }
	       /*
	       public void mouseExited(MouseEvent arg0) { //����뿪��
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
//     �����ѡһ����������ɫ��ΪԲ�ΰ�ť�������
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
//    ������ûửһ����ǩ�ͽ�����Ρ�
   //super.paintComponent(g);
   }
   

//     �ü򵥵Ļ�����ť�ı߽硣
   protected void paintBorder(Graphics g) {
       
   g.setPaintMode();
   //g.setColor(Color.gray);
   //g.drawOval(0, 0, getSize().width-1,
   //getSize().height-1);
   }

//     ������¼�
   Shape shape;
   public boolean contains(int x, int y) {
//     �����ť�ı��С������һ���µ���״����
   if (shape == null || !shape.getBounds().equals(getBounds())) {
   shape = new Ellipse2D.Float(2,2,getWidth()-4,getHeight()-4);
   }
   return shape.contains(x, y);
   }
   
   } 