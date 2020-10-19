import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.concurrent.*;

class Form
{
	private static JFrame Temp_jf;
	private static JPanel Temp_jp;
	private static JLabel Heading;
	private static JLabel Task;
	private static JLabel Desc;
	private static JLabel Date;
	private static JLabel Time;
	private static JTextField task;
	private static JTextField D;
	private static JTextField Y;
	private static JTextArea Description;
	private static JComboBox M;
	private static JComboBox HH;
	private static JComboBox MM;
	private static JComboBox AM_PM;
	private static JCheckBox AlertBefore;
	private static JButton Done;
	public Data DD;

	private static void addFrame()
	{
		Temp_jf = new JFrame("Set The Details:");
		Temp_jf.setVisible(true);
		Temp_jf.setLayout(null);
		Temp_jf.setSize(400,400);
		Temp_jf.setResizable(false);
		Temp_jf.addWindowListener(new WindowListener(){
			public void windowClosing(WindowEvent e)
			{
				Background.Update();
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
		Temp_jf.setIconImage((Toolkit.getDefaultToolkit().getImage("Icon.png")));
		Temp_jf.setLocation(200,200);		
	}
	private static void addPanel()
	{
		Temp_jp = new JPanel();
		Temp_jp.setBounds(0,0,400,400);
		Temp_jp.setLayout(null);
		Temp_jp.setBackground(new Color(7,0,0));
		Temp_jp.setForeground(Color.green);
		Temp_jp.setVisible(true);
		Temp_jf.add(Temp_jp);
		/*Temp_jp.addMouseListener(new MouseListener(){
			    public void mouseClicked(MouseEvent e)
			    {  }  
    			public void mouseEntered(MouseEvent e)
    			{  
    				int B_for_Color = (e.getX()+e.getY())%255;
    				int R_for_Color = (e.getX()) % 255;
    				int G_for_Color = (e.getY()) % 255;
					Temp_jp.setBackground(new Color(R_for_Color,G_for_Color,B_for_Color));
					Temp_jp.setVisible(false);
					Temp_jp.setVisible(true);
					AlertBefore.setBackground(new Color(R_for_Color,G_for_Color,B_for_Color));
					AlertBefore.setVisible(false);
					AlertBefore.setVisible(true);
   	 			}  
    			public void mouseExited(MouseEvent e)
    			{  }  
    			public void mousePressed(MouseEvent e) 
    			{  }  
    			public void mouseReleased(MouseEvent e) 
    			{  } 
		});*/
	}
	private static void addElements()
	{
		//adding Heading
		Heading = new JLabel();
		Temp_jp.add(Heading);
		Heading.setBounds(120,-2,200,50);
		Heading.setText(" New ToDo ");
		Heading.setFont(new Font("Chiller",Font.PLAIN,35));
		Heading.setForeground(new Color(100,0,0));
		Heading.setBackground(new Color(7,0,0));
		Heading.setVisible(true);

		//adding task
		Task = new JLabel();
		Temp_jp.add(Task);
		Task.setBounds(20,50,70,50);
		Task.setFont(new Font("magneto",Font.PLAIN,15));
		Task.setText("Task :");
		Task.setForeground(Color.blue);
		Task.setBackground(Color.black);
		Task.setVisible(true);

		//getting textforTask
		task = new JTextField("");
		task.setBackground(Color.white);
		task.setForeground(Color.black);
		task.setBounds(100,60,220,30);
		task.setFont(new Font("SimSun",Font.PLAIN,13));
		Temp_jp.add(task);
		task.setVisible(false);
		task.setVisible(true);

		//add description:
		Desc = new JLabel();
		Temp_jp.add(Desc);
		Desc.setBounds(20,90,120,50);
		Desc.setText("Description :");
		Desc.setFont(new Font("magneto",Font.PLAIN,15));
		Desc.setForeground(Color.blue);
		Desc.setBackground(Color.black);
		Desc.setVisible(false);
		Desc.setVisible(true);

		//getting textforTask
		Description = new JTextArea("");
		Temp_jp.add(Description);
		Description.setBackground(Color.white);
		Description.setForeground(Color.black);
		Description.setBounds(20,125,320,50);
		Description.setFont(new Font("SimSun",Font.PLAIN,14));
		Description.setVisible(false);
		Description.setVisible(true);

		//adding Date
		Date = new JLabel();
		Temp_jp.add(Date);
		Date.setBounds(20,170,70,50);
		Date.setText("Date :");
		Date.setFont(new Font("magneto",Font.PLAIN,15));
		Date.setForeground(Color.blue);
		Date.setBackground(Color.black);
		Date.setVisible(false);
		Date.setVisible(true);

		D = new JTextField("");
		D.setText(new java.text.SimpleDateFormat("dd").format(new java.util.Date()));
		D.setBackground(Color.white);
		D.setForeground(Color.black);
		D.setFont(new Font("Forte",Font.PLAIN,14));
		D.setBounds(20,210,30,30);
		Temp_jp.add(D);
		D.setVisible(false);
		D.setVisible(true);

		String Temp_Data[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
   		M = new JComboBox(Temp_Data);
   		Temp_jp.add(M);
   		M.setSelectedIndex(Integer.parseInt(new java.text.SimpleDateFormat("MM").format(new java.util.Date()))-1);
   		M.setBounds(52,210,90,30);
   		M.setFont(new Font("Forte",Font.PLAIN,14));

		Y = new JTextField("");
		Y.setText(new java.text.SimpleDateFormat("yyyy").format(new java.util.Date()));
		Y.setBackground(Color.white);
		Y.setForeground(Color.black);
		Y.setBounds(144,210,40,30);
		Y.setFont(new Font("Forte",Font.PLAIN,14));
		Temp_jp.add(Y);
		Y.setVisible(false);
		Y.setVisible(true);

		//adding Time
		Time = new JLabel();
		Temp_jp.add(Time);
		Time.setBounds(200,170,70,50);
		Time.setText("Time :");
		Time.setFont(new Font("magneto",Font.PLAIN,15));
		Time.setForeground(Color.blue);
		Time.setBackground(Color.black);
		Time.setVisible(true);

		Temp_Data = new String[]{"01","02","03","04","05","06","07","08","09","10","11","12"};
   		HH = new JComboBox(Temp_Data);
   		HH.setSelectedIndex(Integer.parseInt(new java.text.SimpleDateFormat("hh").format(new java.util.Date()))-1);
   		Temp_jp.add(HH);
   		HH.setBounds(200,210,40,30);
   		HH.setFont(new Font("Forte",Font.PLAIN,14));

   		Temp_Data = new String[60];
   		for(int i=0;i<60;i++)
   			if(i<10)
   				Temp_Data[i] = "0"+i;
   			else
   				Temp_Data[i] = "" + i;

   		MM = new JComboBox(Temp_Data);
   		Temp_jp.add(MM);
   		MM.setSelectedIndex(Integer.parseInt(new java.text.SimpleDateFormat("mm").format(new java.util.Date())));
   		MM.setBounds(242,210,40,30);
   		MM.setFont(new Font("Forte",Font.PLAIN,14));

   		Temp_Data = new String[]{"AM","PM"};
   		AM_PM = new JComboBox(Temp_Data);
   		Temp_jp.add(AM_PM);
   		AM_PM.setSelectedIndex(((new java.text.SimpleDateFormat("a").format(new java.util.Date())).equals("am")? 0:1));
   		AM_PM.setBounds(284,210,50,30);
   		AM_PM.setFont(new Font("Forte",Font.PLAIN,14));

   		AlertBefore = new JCheckBox("Alert Me Half an Hour Before !!");
   		AlertBefore.setBounds(100,260,200,30);
   		AlertBefore.setForeground(Color.green);
   		AlertBefore.setBackground(Color.black);  
   		Temp_jp.add(AlertBefore);
   		AlertBefore.setVisible(false);
   		AlertBefore.setVisible(true);
	}
	private void addDone()
	{
		Done = new JButton("Done");
		Done.setFont(new Font("Forte",Font.PLAIN,12));
		Temp_jp.add(Done);
		Done.setBounds(155,305,60,30);
		Done.setForeground(new Color(100,100,100));
		Done.setBackground(Color.black);
		Done.setVisible(false);	
		Done.setVisible(true);	

		//function
		Done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				//check
				boolean flag = true;

				
				// //checking Date:
				if(D.getText().equals(""))
				{
					flag = false;
				  JOptionPane.showMessageDialog(Temp_jf,"Date can't be left\nBLANK!!","Alert",JOptionPane.WARNING_MESSAGE);
				}
				if(flag&&Y.getText().equals(""))
				{
					flag = false;
				  JOptionPane.showMessageDialog(Temp_jf,"Year can't be left\nBLANK!!","Alert",JOptionPane.WARNING_MESSAGE);
				}
				if(flag)
				{
					int month_days[]={31,29,31,30,31,30,31,31,30,31,30,31};
					int date=0,month=0,year=0;
					try
					{
						date = Integer.parseInt(D.getText());
						month = M.getSelectedIndex() + 1;
						year = Integer.parseInt(Y.getText());
					}catch(Exception exception)
					{
						flag = false;
					}
					if(flag)
					{
						if(date > month_days[month-1] && date>0)
							flag = false;

						if(month == 2)
							if(!((year%400 ==0)||(year%100!=0 && year%4==0)))
							{
								if(date > 29)
									flag = false;
							}
							else 
								if(date > 28)
									flag = false;
					}
				if(!flag)
				  JOptionPane.showMessageDialog(Temp_jf,"Date is Invalid!!\nTry Again!","Alert",JOptionPane.WARNING_MESSAGE);
				}
				if(flag&&task.getText().equals(""))
				{
				  JOptionPane.showMessageDialog(Temp_jf,"Task can't be Left BLANK!!","Alert",JOptionPane.WARNING_MESSAGE);
				  flag = false;
				}
				//check for the data(it must not be a date from past)
				if(flag)
				{
					int d1=Integer.parseInt(D.getText());
					int mnth1=(M.getSelectedIndex() + 1);
					int yr1=Integer.parseInt(Y.getText());
					int hr1=(HH.getSelectedIndex() + 1);
					int min1=MM.getSelectedIndex();
					int am_pm1 = (AM_PM.getSelectedIndex()==0)? 0:1;
					String Temp = new java.text.SimpleDateFormat("hh:mm a dd/M/yyy").format(new java.util.Date());
					int d2=0,mnth2=0,yr2=0,hr2=0,min2=0,am_pm2=0;
					for(int q=0,T_Data=0,top=-1;q<Temp.length();q++)
					{
						//System.out.println(Temp.charAt(q));
						if(Temp.charAt(q)>='0'&&Temp.charAt(q)<='9')
							T_Data = (T_Data*10) + (Temp.charAt(q)-48);
						else
						{
							switch(++top)
							{
								case 0: hr2=T_Data; T_Data=0; break;
								case 1: min2=T_Data; T_Data=0; break;
								case 2: am_pm2= (Temp.charAt(q)=='a')? 0:1; break;
								case 5: d2=T_Data; T_Data=0; break;
								case 6: mnth2=T_Data; T_Data=0; break; 
								default: T_Data=0;
							}
						}

						if(q==Temp.length()-1)
							yr2 = T_Data;
					}
					if(yr2==yr1)
					{
						if(mnth2==mnth1)
						{
							if(d2==d1)
							{
								if(am_pm2==1)
									hr2+=12;
								if(am_pm1==1)
									hr1+=12;
								if(am_pm1==0&&hr1==12)
									hr1 -= 12;
								if(am_pm2==0&&hr2==12)
									hr2 -= 12;
								if(hr2==hr1)
								{
								if(am_pm2==1)
									hr2-=12;
								if(am_pm1==1)
									hr1-=12;
								if(am_pm1==0&&hr1==12)
									hr1 += 12;
								if(am_pm2==0&&hr2==12)
									hr2 += 12;
									if(min2<min1)
									{
									}else
										flag=false;
								}else if(hr2>=hr1)
									flag=false;

						// System.out.println("U--> "+d1+"/"+mnth1+"/"+yr1+" "+hr1+":"+min1+" "+((am_pm1==0)? "am":"pm"));
						// System.out.println("C--> "+d2+"/"+mnth2+"/"+yr2+" "+hr2+":"+min2+" "+((am_pm2==0)? "am":"pm"));
							}else if(d2>=d1)
								flag=false;
						}else if(mnth2>=mnth1)
							flag=false;
					}else if(yr2>=yr1)
						flag=false;
					if(!flag)
					{
				  		JOptionPane.showMessageDialog(Temp_jf,"Reminder can't be set for Past","Alert",JOptionPane.WARNING_MESSAGE);
				  		flag = false;
					}

					if(AlertBefore.isSelected())
					{
						if(flag){////minute minus:
							if(min1<30)
							{
								min1 += 60;
								min1 -= 30;

								//subtracting Hour
								if(hr1==1)
									hr1 = 12;
								else
								{
									hr1--;

									//checking for date:
									if(hr1 == 11)
									{
										if(am_pm1==1)
											am_pm1 = 0;
										else
										{
											am_pm1 = 1;

											//change date:
											if(d1==1)
											{
												if(mnth1==1||mnth1==3||mnth1==5||mnth1==7||mnth1==8||mnth1==10||mnth1==12)
												{
													d1 = 31;
													if(mnth1==1)
													{
														mnth1=12;
														yr1--;
													}
													else
														mnth1--;
												}
												else if(mnth1==3)
												{
													if((yr1%4==0&&yr1%100!=0)||(yr1%400==0))
														d1=29;
													else
														d1=28;
													mnth1--;
												}
												else
												{
													d1=30;
													mnth1--;								
												}
											}else
												d1--;
										}
								}	}

							}else
								min1 -= 30;
					}//

						// System.out.println(d1+"/"+mnth1+"/"+yr1+" "+hr1+":"+min1+" "+((am_pm1==0)? "am":"pm"));
						// System.out.println(d2+"/"+mnth2+"/"+yr2+" "+hr2+":"+min2+" "+((am_pm2==0)? "am":"pm"));
					}

					//now see whether it can be accepted!!
					if(flag){
						if(yr2==yr1)
						{
							if(mnth2==mnth1)
							{
								if(d2==d1)
								{
									if(am_pm2==1)
										hr2+=12;
									if(am_pm1==1)
										hr1+=12;
								if(am_pm1==0&&hr1==12)
									hr1 -= 12;
								if(am_pm2==0&&hr2==12)
									hr2 -= 12;
									if(hr2==hr1)
									{
										if(am_pm2==1)
											hr2-=12;
										if(am_pm1==1)
											hr1-=12;
								if(am_pm1==0&&hr1==12)
									hr1 += 12;
								if(am_pm2==0&&hr2==12)
									hr2 += 12;
										if(min2<min1)
										{
										}else
											flag=false;
									}else if(hr2>=hr1)
										flag=false;
								}else if(d2>=d1)
								flag=false;
							}else if(mnth2>=mnth1)
								flag=false;
						}else if(yr2>=yr1)
							flag=false;
						if(!flag)
						{
				  			JOptionPane.showMessageDialog(Temp_jf,"Early Alert not Possible!!\nToo Late!","Alert",JOptionPane.WARNING_MESSAGE);
				  			AlertBefore.setSelected(false);
				  			flag = false;
						}
					}
				}
				// Now Store Data:
				if(flag)
				{
					Temp_jf.dispose();
     				//adding plates: String task,String time,String Date,String Des
     				String Am_Pm = "";
     				if(AM_PM.getSelectedIndex()==0)
     					Am_Pm = "AM";
     				else
     					Am_Pm = "PM";

     				String Date_Temp = ""+Integer.parseInt(D.getText()) + "/";
     				if(M.getSelectedIndex() + 1<10)
     					Date_Temp +="0";
     				Date_Temp += (M.getSelectedIndex() + 1) +"/"+ Y.getText();

					String Time="";
					if((HH.getSelectedIndex() + 1)<10)
						Time += "0";
					Time += (HH.getSelectedIndex() + 1)+":";

					if(MM.getSelectedIndex()<10)
					Time += "0";
					Time += MM.getSelectedIndex()+" "+Am_Pm.toLowerCase();					

     				DD.setValue(task.getText(),Time,Date_Temp,Description.getText(),AlertBefore.isSelected(),getAB_DATA());
				}
			}
		});
	}
	private String getAB_DATA()
	{
		String Ans="";
		int H_ = HH.getSelectedIndex()+1;
		int M_ = MM.getSelectedIndex();
		int D_ = Integer.parseInt(D.getText());
		int MNTH = (M.getSelectedIndex() + 1);
		int Y_ = Integer.parseInt(Y.getText());
		String A_P;

		if(AM_PM.getSelectedIndex()==1)
			A_P = "pm";
		else
			A_P = "am";

		//minute minus:
		if(M_<30)
		{
			M_ += 60;
			M_ -= 30;

			//subtracting hour
			if(H_==1)
				H_ = 12;
			else
			{
				H_--;

				//checking for date:
				if(H_ == 11)
				{
					if(AM_PM.getSelectedIndex()==1)
						A_P = "am";
					else
					{
						A_P = "pm";

						//change date:
						if(D_==1)
						{
							if(MNTH==1||MNTH==3||MNTH==5||MNTH==7||MNTH==8||MNTH==10||MNTH==12)
							{
								D_ = 31;
								if(MNTH==1)
								{
									MNTH=12;
									Y_--;
								}
								else
									MNTH--;
							}
							else if(MNTH==2)
							{
								if((Y_%4==0&&Y_%100!=0)||(Y_%400==0))
									D_=29;
								else
									D_=28;
								MNTH--;
							}
							else
							{
								D_=30;
								MNTH--;								
							}
						}else
							D_--;
					}
				}
			}

		}else
			M_ -= 30;

		//Take Time
		if(H_<10)
			Ans ="0";
		Ans += H_+":";

		if(M_<10)
			Ans +="0";
		Ans += M_+" "+A_P+" ";

		///take data:
		if(D_<10)
			Ans +="0";
		Ans += D_+"/";
		Ans += MNTH+"/";

		Ans += Y_;
		return Ans;
	}
	protected void fillForm(Data D) 
	{
		DD = D;
		D.status=false;
		addFrame();
		addPanel();
		addElements();
		addDone();
	}
}
/*
Sheet,task.getText()
Description.getText()
Integer.parseInt(D.getText())
(M.getSelectedIndex() + 1)
Integer.parseInt(Y.getText())
(HH.getSelectedIndex() + 1)
MM.getSelectedIndex()
AM_PM.getSelectedIndex()
AlertBefore.isSelected()
*/