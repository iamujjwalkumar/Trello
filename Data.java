import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;						
import java.util.Date;

class Loop implements Runnable 
{
	private String Time;
	private SimpleDateFormat sdf;
	private Date date;
	private Data Temp;

  Loop(String Time,Data D)
  {
  		this.Temp = D;
  		this.Time = Time;
		sdf = new SimpleDateFormat("hh:mm a d/MM/yyy");
  }
  public void run()
         {
         	while(Temp.status)
         	{
         	 date = new Date();
         	 if((sdf.format(date)).equals(Time.toLowerCase()))
         	 {      
         	 	String Mess="";   	 	
         	 	if(!Temp.Desc.equals(""))
         	 		Mess = "Task: " + Temp.task + "\n" + "Description:-\n" + Temp.Desc;
         	 	else
         	 		Mess = "Task: " + Temp.task;
         	 	JOptionPane.showMessageDialog(new JFrame(),Mess,"Alert",JOptionPane.WARNING_MESSAGE);
         	 	Temp.status = false;
         	 	Temp.Plate.setVisible(false);
 				Background.Update();
         	 	break;
         	 }
         	}
	 	 }
}
class AlerTBeforE implements Runnable 
{
	private String Time;
	private SimpleDateFormat sdf;
	private Date date;
	private Data Temp;

  AlerTBeforE(String Time,Data D)
  {
  		this.Temp = D;
  		this.Time = Time;
		sdf = new SimpleDateFormat("hh:mm a dd/M/yyy");
  }
  public void run()
         {
         	while(Temp.status&&Temp.AlertBefore)
         	{
         	 date = new Date();
         	 if((sdf.format(date)).equals(Time))
         	 {         	 	
         	  String Mess="";         	 	
         	 	if(!Temp.Desc.equals(""))
         	 		 Mess ="\t\tEarly Alert!!\n"+"Task: " + Temp.task + "\n" + "Description:-\n" + Temp.Desc;
         	 	else
         	 		 Mess = "\t\tEarly Alert!!\n"+"Task: " + Temp.task;
         	 	JOptionPane.showMessageDialog(new JFrame(),Mess,"Alert",JOptionPane.WARNING_MESSAGE);
         	 	Temp.AlertBefore = false;
         	 	break;
         	 }
         	}
	 	 }
}

public class Data
{
	protected JPanel Plate;
	protected JLabel Task;
	protected JLabel Time;
	protected JLabel Date;
	protected JButton Extra;
	protected boolean Flag=false;

	public String task;
	public String AB_Data;
	public boolean status = false;
	public String Desc;
	public boolean AlertBefore;

	protected void setValue(String task,String time,String D,String Des,boolean AlertBefore,String AB_Data)
	{
		this.task = task;
		this.Desc = Des;
		this.AlertBefore = AlertBefore;
		this.AB_Data = AB_Data;
		status=true;

		Plate = new JPanel();
		Background.Sheet.add(Plate);
		Plate.setLayout(null);
		Plate.setBounds(3,Background.addMoreLoc-110,388,100);
		Plate.setBackground(new Color(60,0,0));
		Plate.setVisible(false);
    	Plate.setVisible(true);

		JLabel tasK = new JLabel();
		Plate.add(tasK);
		tasK.setText("Task: ");
		tasK.setBounds(3,13,70,40);
		tasK.setFont(new Font("Chiller",Font.PLAIN,25));
		tasK.setBackground(new Color(70,0,0));
		tasK.setForeground(Color.white);
		tasK.setVisible(false);
    	tasK.setVisible(true);

		Task = new JLabel();
		Plate.add(Task);
		Task.setText(task);
		Task.setFont(new Font("Lucida Handwriting",Font.PLAIN,18));
		Task.setBounds(55,20,220,30);
		Task.setBackground(new Color(70,0,0));
		Task.setForeground(Color.white);
		Task.setVisible(false);
    	Task.setVisible(true);

		Time = new JLabel();
		Plate.add(Time);
		Time.setText(time.toUpperCase());
		Time.setFont(new Font("SimSun",Font.BOLD,15));
		Time.setBounds(318,20,70,40);
		Time.setBackground(new Color(70,0,0));
		Time.setForeground(Color.white);
		Time.setVisible(false);
    	Time.setVisible(true);

		Date = new JLabel();
		Plate.add(Date);
		Date.setFont(new Font("SimSun",Font.BOLD,15));
		Date.setText(D);
		Date.setBounds(305,60,80,30);
		Date.setBackground(new Color(70,0,0));
		Date.setForeground(Color.white);
    	Date.setVisible(false);
    	Date.setVisible(true);

		Flag = true;

		Extra = new JButton("...");
		Extra.setFont(new Font("SimSun",Font.BOLD,15));
  		Extra.setBounds(357,0,30,15);
   		Plate.add(Extra);
   		Extra.setBackground(new Color(70,0,0));
   		Extra.setForeground(Color.black);
    	Extra.setVisible(false);
    	Extra.setVisible(true);

 		//function:
 		Extra.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e)
 			{
 				status = false;
 				Plate.setVisible(false);
 				Background.Update();
 			}
 		});

 		//set loop
 		Thread Temp1=new Thread(new Loop(time+" "+D,this));
   		Temp1.start();

  		if(AlertBefore)
   		{
 			Thread Temp2=new Thread(new AlerTBeforE(AB_Data,this));
   			Temp2.start();	
   		}
	}
}