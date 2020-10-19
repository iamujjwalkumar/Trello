import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.concurrent.*;

class TIME implements Runnable
{
	private static Date date;
	private static SimpleDateFormat sdf;
	private static JLabel Time;

  TIME(JLabel Time)
  {
  		this.Time = Time;
		date = new Date();
		sdf = new SimpleDateFormat("hh:mm a");
        Time.setFont(new Font("SimSun",Font.BOLD,15));
  }
  public void run()
         {
          String Temp = ""; 
         	while(true)
         	{
         	 date = new Date();
         	 if(!(sdf.format(date)).equals(Temp))
         	 {
         	    Temp = sdf.format(date);	
        		Time.setText(sdf.format(date).toUpperCase());
				Time.setVisible(false);
				Time.setVisible(true);
         	 }
         	}
	 	 }
}

class Background
{
	public static JFrame Frame;
	public static JPanel Cover;
	private static JPanel Board;
	public static JPanel Sheet;
	public static Scrollbar S;
	public static JButton addMore;
	private static JLabel Time;
	private static JLabel Trello;
	public static Data DATA[]=new Data[0];
	public static final String Sign = "- Arcon Steve";
	public static JLabel SIGN;

	public static int SheetLength=394;
	public static int addMoreLoc=10;
	public static int B_for_Color=0;

	private static void setFrame()
	{
		Frame = new JFrame("Trello");
		Frame.setVisible(true);
		Frame.setLayout(null);
		Frame.addWindowListener(new WindowListener(){
			public void windowClosing(WindowEvent e)
			{
				close();
			}

		    public void windowClosed(WindowEvent e)
		    {
    	     	//displayMessage("Window closed", e);
    		}

    		public void windowOpened(WindowEvent e)
    		{
    		  //  displayMessage("Window opened", e);
    		}

    		public void windowIconified(WindowEvent e)
    		{
        	//	displayMessage("Window iconified", e);
    		}

   			public void windowDeiconified(WindowEvent e)
   			{
        		//displayMessage("Window deiconified", e);
    		}

		    public void windowActivated(WindowEvent e)
		    {
        	//	displayMessage("Window activated", e);
    		}

    		public void windowDeactivated(WindowEvent e)
    		{
        	//	displayMessage("Window deactivated", e);
 		   	}
		});
		Frame.setSize(500,500);
		Frame.setResizable(false);
		Frame.setIconImage((Toolkit.getDefaultToolkit().getImage("Icon.png")));
		Frame.setLocation(150,150);
	}
	private static void setCover()
	{
		Cover = new JPanel();
		Frame.add(Cover);
		Cover.setLayout(null);
		Cover.setBounds(0,0,500,500);
		Cover.setBackground(new Color(7,0,0));
		Cover.setVisible(false);
		Cover.setVisible(true);
	}
	private static void setBoard()
	{
		Board = new JPanel();
		Cover.add(Board);
		Board.setLayout(null);
		Board.setBounds(45,40,400,400);
		Board.setBackground(new Color(7,0,0));
		Board.setVisible(false);
		Board.setVisible(true);


		//adding Trello
		Trello = new JLabel();
		Cover.add(Trello);
		Trello.setBounds(210,-3,100,50);
		Trello.setText("Trello");
		Trello.setFont(new Font("Chiller",Font.PLAIN,35));
		Trello.setForeground(new Color(100,80,0));
		Trello.setBackground(Color.black);
		Trello.setVisible(true);
	}
	private static void addClock()
	{
		Time = new JLabel();
		Cover.add(Time);
		Time.setBounds(405,10,100,30);
		Time.setBackground(Color.black);
		Time.setForeground(new Color(100,0,0));

 		Thread T1=new Thread(new TIME(Time));
   		T1.start();
	}
	public static void addSheet()
	{
		Sheet = new JPanel();
		Board.add(Sheet);
		Sheet.setLayout(null);
		Sheet.setBounds(3,3,394,SheetLength);
		Sheet.setBackground(new Color(7,0,0));
		Sheet.setVisible(false);
		Sheet.setVisible(true);
	}
	private static void addScroller()
	{
    	S = new Scrollbar(JScrollBar.VERTICAL);
   		S.setBounds(-50,10,16,350);
    	S.setBackground(Color.black);
    	Frame.add(S);
    	S.setVisible(false);
    	S.setVisible(true);

   		// adding function:
    	S.addAdjustmentListener(new AdjustmentListener(){
  		public void adjustmentValueChanged(AdjustmentEvent e)
        {    
	 		Sheet.setBounds(3,3+(int)((float)(S.getValue()/90.0)*(SheetLength-394)*(-1)),394,SheetLength);
	 		Sheet.setVisible(false);
	 		Sheet.setVisible(true);
        }});
	}
	private static void addMoreButton()
	{
  		addMore = new JButton("Add");
  		addMore.setFont(new Font("Forte",Font.PLAIN,12));
  		addMore.setBounds(165,addMoreLoc,60,25);
   		Sheet.add(addMore);
   		addMore.setBackground(Color.black);
   		addMore.setForeground(new Color(100,100,100));
    	addMore.setVisible(false);
    	addMore.setVisible(true);

 		//function:
 		addMore.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e)
 			{
 				addMoreLoc += 104;
 				if(addMoreLoc > 312)
	 				SheetLength += 104;
		  		addMore.setBounds(165,addMoreLoc,60,30);
				Sheet.setBounds(3,3,394,SheetLength);
				S.setValue(75);
		    	addMore.setVisible(false);
	    		addMore.setVisible(true);
		    	Sheet.setVisible(false);
	    		Sheet.setVisible(true);

	    		//adding Data;
	    		{
	    			Data Temp[] = new Data[DATA.length+1];
	    			for(int i=0;i<DATA.length;i++)
	    				Temp[i] = DATA[i];
	    			DATA = Temp;
	    			DATA[DATA.length-1] = new Data();
	    		}
	    		new Form().fillForm(DATA[DATA.length-1]);
 			}
 		});
	}
	public static void Update()
	{
		//count
		int count=0;
		for(int i=0;i<DATA.length;i++)
			if(DATA[i].status)
				count++;

		//assigning new memory
		int top = -1;

		Data Temp[] = new Data[count];
		for(int i=0;i<DATA.length;i++)
			if(DATA[i].status)
			Temp[++top] = DATA[i];
		DATA = Temp;

		for(int i=0;i<count;i++)
			DATA[i].Plate.setBounds(3,103*i+3,400,100);

		addMoreLoc -= 104;
  		addMore.setBounds(165,addMoreLoc,60,30);

	}
	public static void addSignature()
	{
		SIGN = new JLabel();
		Cover.add(SIGN);
		SIGN.setText(Sign);
		SIGN.setFont(new Font("magneto",Font.PLAIN,15));
		SIGN.setBounds(360,438,150,30);
		SIGN.setBackground(Color.black);
		SIGN.setForeground(Color.yellow);
		SIGN.setVisible(false);
		SIGN.setVisible(true);		
	}
	public static void close()
	{//String task,String time,String D,String Des,boolean AlertBefore,String AB_Data
		String Data="";
		for(int i=0;i<DATA.length;i++)
		{
			Data +=DATA[i].task+"\n";
			{
				String Temp_Des="";
				String Temp_D=DATA[i].Desc;
				int Len = Temp_D.length();
				for(int j=0;j<Len;j++)
					if(Temp_D.charAt(j)=='\n')
						Temp_Des += "\t";
					else
						Temp_Des += Temp_D.charAt(j);
				Data +=Temp_Des+"\n";
			}
			Data +=DATA[i].Time.getText()+"\n";
			Data +=DATA[i].Date.getText()+"\n";
			Data +=DATA[i].AlertBefore+"\n";
			Data +=DATA[i].AB_Data+"\n";
		}
		File file=new File("DataFile.txt");
		try{
				if(!file.exists()) file.createNewFile();
				FileWriter fw=new FileWriter(file,true);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(Data);
				bw.close();
				 }catch(Exception e){ }

		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private static void addSensor()
	{
		Cover.addMouseListener(new MouseListener(){
			    public void mouseClicked(MouseEvent e)
			    {  }  
    			public void mouseEntered(MouseEvent e)
    			{  
    				B_for_Color = (B_for_Color + 50 )%255;
    				int R_for_Color = (e.getX()) % 255;
    				int G_for_Color = (e.getY()) % 255;
					Cover.setBackground(new Color(R_for_Color,G_for_Color,B_for_Color));
					Cover.setVisible(false);
					Cover.setVisible(true);
					Board.setBackground(new Color(R_for_Color,G_for_Color,B_for_Color));
					Board.setVisible(false);
					Board.setVisible(true);
					Sheet.setBackground(new Color(R_for_Color,G_for_Color,B_for_Color));
					Sheet.setVisible(false);
					Sheet.setVisible(true);
   	 			}  
    			public void mouseExited(MouseEvent e)
    			{  }  
    			public void mousePressed(MouseEvent e) 
    			{  }  
    			public void mouseReleased(MouseEvent e) 
    			{  } 
		});
	}
	public void setUp()
	{
		setFrame();
		setCover();
		setBoard();
		addClock();
		addSheet();
		addScroller();
		addMoreButton();
		addSignature();
		//addSensor();
	}
}