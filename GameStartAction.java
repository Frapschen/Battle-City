import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class GameStartAction extends Main {
	JLabel StartJl[]=new JLabel[3];
	int mm=0;//跳出选择函数的开关
	//装载图像
	public GameStartAction(JLabel jl)
	{
		StartJl[0]=jl;
		StartJl[1]=new JLabel(new ImageIcon("select.gif"));
		StartJl[2]=new JLabel(new ImageIcon("selecttank.gif"));
	}
	//启动界面
	public void action()
	{
		for(int i=700;i>=100;i--)
		{
			StartJl[0].setBounds(70, i, 638, 213);
			StartJl[1].setBounds(300, 300+i, 146, 165);
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(8);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StartJl[2].setBounds(240, 395, 50, 45);
	}
	//选择器
	public void choice(JFrame jf)
	{
		
		int choice=0;
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		KeyListener keyl=new KeyListener() 
		{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar()=='w'||e.getKeyChar()=='W')
				{
					
					if(StartJl[2].getY()!=395)
						StartJl[2].setBounds(240, 395, 50, 45);
				}
				
				if(e.getKeyChar()=='s'||e.getKeyChar()=='S')
				{
					
					if(StartJl[2].getY()!=460)
						StartJl[2].setBounds(240, 460, 50, 45);
				}
				if(e.getKeyChar()=='g'||e.getKeyChar()=='G')
				{
					
					if(StartJl[2].getY()==395)
					{
						mm=1;
						jf.removeKeyListener(this);
					}
				}
				//结束程序
				if(e.getKeyChar()=='e'||e.getKeyChar()=='E')
					System.exit(0);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		jf.addKeyListener(keyl);
		if(mm==1)
			break;
		}
	}
}
