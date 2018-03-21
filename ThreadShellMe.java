import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadShellMe implements Runnable {
	//炮弹控制线程：
	Tank tank[];//坦克对象组
	Shell shell;//炮弹对象
	Tank tankmain;//开炮的坦克

	//构造方法
	public ThreadShellMe(Tank tank[],Shell shell,Tank tankmain)
	{
		this.tank=tank;
		this.shell=shell;
		this.tankmain=tankmain;

	}
	@Override
	public void run() {

		// TODO Auto-generated method stub
		//主循环
		tankmain.fire=false;
		while(shell.life)
		{			
			//炮弹越界清除
			if(shell.locationX>=800||shell.locationY>=800||shell.locationX<=-15||shell.locationY<=-15)
			{
				shell.life=false;
				break;
			}					
					switch(shell.direcation)
					{
					case 0:
						{				
							shell.locationY-=1;
							shell.shell.setBounds(shell.locationX, shell.locationY, 17, 17);
								for(int i=0;i<tank.length;i++)
								{
									if(tank[i]==tankmain)
										continue;

										if(tank[i].locationY<=shell.locationY&&shell.locationY<=(tank[i].locationY+60))
										{
											tank[i].image.setIcon(new ImageIcon("E:\\img\\blast8.gif"));										
											shell.shell.setBounds(1000, 1000, 0, 0);
											tank[i].life=false;
											shell.life=false;
											break;
										}
								}							
							break;
						}
					case 1:
						{
							shell.locationX+=1;
							shell.shell.setBounds(shell.locationX, shell.locationY, 17, 17);
							for(int i=0;i<tank.length;i++)
							{
								if(tank[i]==tankmain)
									continue;
								if(tank[i].locationX<=shell.locationX&&shell.locationX<=(tank[i].locationX+60))
									if(tank[i].locationY<=shell.locationY&&shell.locationY<=(tank[i].locationY+60))
									{
										tank[i].life=false;
										shell.life=false;
										tank[i].image.setIcon(new ImageIcon("E:\\img\\blast8.gif"));
										shell.shell.setBounds(1000, 1000, 0, 0);
										break;
									}
							}
							break;
						}
					case 2:
						{
							shell.locationY+=1;
							shell.shell.setBounds(shell.locationX, shell.locationY, 17, 17);
							for(int i=0;i<tank.length;i++)
							{
								if(tank[i]==tankmain)
									continue;
								if(tank[i].locationX<=shell.locationX&&shell.locationX<=(tank[i].locationX+60))
									if(tank[i].locationY<=shell.locationY&&shell.locationY<=(tank[i].locationY+60))
									{
										tank[i].life=false;
										shell.life=false;
										tank[i].image.setIcon(new ImageIcon("E:\\img\\blast8.gif"));
										shell.shell.setBounds(1000, 1000, 0, 0);
										break;
									}
							}
							break;
						}
					case 3:
						{
							shell.locationX-=1;
							shell.shell.setBounds(shell.locationX, shell.locationY, 17, 17);
							for(int i=0;i<tank.length;i++)
							{
								if(tank[i]==tankmain)
									continue;
								if(tank[i].locationX<=shell.locationX&&shell.locationX<=(tank[i].locationX+60))
									if(tank[i].locationY<=shell.locationY&&shell.locationY<=(tank[i].locationY+60))
									{
										tank[i].life=false;
										shell.life=false;
										tank[i].image.setIcon(new ImageIcon("E:\\img\\blast8.gif"));
										shell.shell.setBounds(1000, 1000, 0, 0);
										break;
									}
							}
							break;
						}
					}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		tankmain.fire=true;
		}
}
