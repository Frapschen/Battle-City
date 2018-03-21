import javax.swing.JLabel;

public class Shell {
//炮弹类
//属性：炮弹图片，炮弹位置炮弹方向
	JLabel shell;
	int locationX;
	int locationY;
	int direcation;
	boolean life;
	public Shell(JLabel shell,int x,int y,int direcation)
	{
		this.shell=shell;
		this.locationX=x;
		this.locationY=y;
		this.direcation=direcation;
		this.life=true;
	}
}
