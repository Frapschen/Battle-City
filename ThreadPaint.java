import java.util.Iterator;
import java.util.Map;
import javax.swing.JLabel;
public class ThreadPaint extends Tank implements Runnable {
	//画图类
	Tank tank[];//坦克对象组
	boolean exit=true;

	public ThreadPaint(Tank tank[])
	{
		this.tank=tank;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//主循环
		while(exit)
		{
			//刷新率
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//画所有坦克的位置
			//死亡or存活
			for(int i=0;i<tank.length;i++)
			{
				if(tank[i].life)
					tank[i].image.setBounds(tank[i].locationX,tank[i].locationY, 60, 60);
			}												
		}
	}

}
