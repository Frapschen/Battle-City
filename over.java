import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class over implements Runnable {
	Tank tank[];
	Tank tankmain;
	JPanel jp;
	int i=0;
	public over(Tank tank[],Tank tankmain,JPanel jp)
	{
		this.jp=jp;
		this.tank=tank;
		this.tankmain=tankmain;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			//System.out.println("结束了");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if((!(tank[1].life)&&!(tank[2].life))||!(tank[0].life))
			{
				JLabel overjl=new JLabel(new ImageIcon("over.gif"));
				for(int j=700;j>=100;j--)
				{					
					jp.add(overjl);
					overjl.setBounds(70, j, 638, 213);				
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
				i=1;
		    }
			if(i==1)
				break;
	}

}
}
