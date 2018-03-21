import javax.swing.*;	
import java.lang.Math;
public class Tank extends Main {
	//坦克类
	//属性：坦克图片，生命，位置，速度，朝向 炮弹图片,图片直径
	JLabel image;//坦克图片
	ImageIcon imiclib[]=new ImageIcon[4];//四个方向的坦克图标
	JLabel shellPicture=new JLabel(new ImageIcon("tankmissile.gif"));//炮弹图片
	boolean life=true;//生命
	int locationX;//x坐标
	int locationY;//y坐标
	int speed;//速度
	int direction;//方向
	double circled=2*25*Math.sqrt(2);//图片直径
	boolean fire=true;//能否开炮
	//构造方法
	public Tank(ImageIcon imiclib[],int x,int y,int speed,int direction)
	{
		this.image=new JLabel(imiclib[0]);
		this.imiclib=imiclib;
		this.locationX=x;
		this.locationY=y;
 		this.speed=speed;
		this.direction=direction;
		
	}
	public Tank() {}; 
	//行走
	void walk(int direction,Tank aimtank[])
	{
		boolean walk2=true;
		boolean walk=true;		
		//1.图片情况(new 一个图片对象出来)
		if(this.direction!=direction)
		{			
			this.direction=direction;
			this.image.setIcon(this.imiclib[this.direction]);
		}
		
		//2.边界碰撞用walk判断
		switch(this.direction)
		{
		   case 0:if(this.locationY<=0) walk=false; break;
		   case 1:if(this.locationX>=736) walk=false; break;
		   case 2:if(this.locationY>=704) walk=false; break;
		   case 3:if(this.locationX<=0) walk=false; break;
		}
		//3.行进方向坦克碰撞 用walk2判断
		for(int i=0;i<aimtank.length;i++)
		{
			if(this.equals(aimtank[i]))
				continue;			
			//方法二，把坦克看成一个圆，判断相切；
			//*********************
			//1.未相撞到相撞的判断
			//2.相撞到离开的判断
			//*********************
			int tX=this.locationX+30;//获取圆心
			int tY=this.locationY+30;
			int atX=aimtank[i].locationX+30;
			int atY=aimtank[i].locationY+30;
			double distance=Math.sqrt((Math.pow(tX-atX, 2)+Math.pow(tY-atY, 2)));//两坦克中心的距离 
			if(this.circled>=distance)
			{
				walk2=false;				
				switch(this.direction)//进行预测，往哪个方向能够离开
				{
				  case 0:
				  {
					  //System.out.println("方向0");
					  tY-=10;
					  distance=Math.sqrt((Math.pow(tX-atX, 2)+Math.pow(tY-atY, 2)));//预测后的距离 					  
						if(this.circled<=distance)
						{
							walk2=true;							
						}
					  break;
				  }
				  case 1:
				  {
					  tX+=10;
					  distance=Math.sqrt((Math.pow(tX-atX, 2)+Math.pow(tY-atY, 2)));
					  if(this.circled<=distance)
							walk2=true;
					  break;
				  }
				  case 2:
				  {
					  tY+=10;
					  distance=Math.sqrt((Math.pow(tX-atX, 2)+Math.pow(tY-atY, 2)));
					  if(this.circled<=distance)
							walk2=true;
					  break;
				  }
				  case 3:
				  {
					  tX-=10;
					  distance=Math.sqrt((Math.pow(tX-atX, 2)+Math.pow(tY-atY, 2)));
					  if(this.circled<=distance)
							walk2=true;
					  break;
				  }
				}
			}
		}

		//3.确定方向，改变数据
		if(walk&&walk2)
		{
			switch(this.direction)
			{
			case 0:this.locationY-=8; break;
			case 1:this.locationX+=8; break;
			case 2:this.locationY+=8; break;
			case 3:this.locationX-=8; break;
			}			
		}
	}
	

    //开炮
	public void fire(JPanel Cenjp,Tank tank[],Tank tankmian)
	{

		switch(this.direction)
		{
		//根据不同方向实例化一个炮弹对象并创建线程
		//把炮弹加入到窗体中
		case 0: 
			{
				//根据不同方向实例化一个炮弹对象
				Shell shell=new Shell(shellPicture, locationX+22, locationY-20,direction);
				//把炮弹加入到窗体中
				Cenjp.add(shell.shell); 
				Thread th=new Thread(new ThreadShellMe(tank,shell,tankmian));				
				th.start();
				break;
			}
		case 1:
			{
				Shell shell=new Shell(shellPicture, locationX+70, locationY+23,direction);
				Cenjp.add(shell.shell); 
				Thread th=new Thread(new ThreadShellMe(tank,shell,tankmian));				
				th.start();
				break;
			}
		case 2:
			{
				Shell shell=new Shell(shellPicture, locationX+22, locationY+70,direction);
				Cenjp.add(shell.shell); 
				Thread th=new Thread(new ThreadShellMe(tank,shell,tankmian));				
				th.start();
				break;
			}
		case 3: 
			{
				Shell shell=new Shell(shellPicture, locationX-20,locationY+22,direction);
				Cenjp.add(shell.shell); 
				Thread th=new Thread(new ThreadShellMe(tank,shell,tankmian));				
				th.start();
				break;
			}
		
		}
	}

}
