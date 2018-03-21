import java.lang.Thread;
import java.util.Random;
import javax.swing.JPanel;
public class ThreadEnemyMe implements Runnable{
	//敌方坦克控制类
	Tank tankmain;//要控制的坦克
	Tank tank[];//坦克对象组
	boolean exit=true;
	JPanel Cenjp;
	public ThreadEnemyMe(Tank tankmain,Tank tank[],JPanel Cenjp)
	{
		this.tankmain=tankmain;
		this.tank=tank;
		this.Cenjp=Cenjp;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//敌方改变坦克消息
		while(tankmain.life)
		{
			//敌方坦克 移动  OR 开炮				
				int randomWhat=new Random().nextInt(15);
				if(randomWhat==0||randomWhat==1||randomWhat==2||randomWhat==3)//行走
				{		
					int k=0;
					while(true)
					{
						k++;
						if(k>20)															
							break;						
						tankmain.walk(randomWhat, tank);
						//System.out.println(tankmain.locationX+","+tankmain.locationY);
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();									
						}
					}
				}
				else//开炮
				{
					if(tankmain.fire)//是否炮弹还在场上
					tankmain.fire(Cenjp,tank,tankmain);
				}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
