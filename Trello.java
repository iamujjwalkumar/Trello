import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.concurrent.*;
public class Trello
{
	private static boolean Check(String D,String task,String Des)
	{
		//Check for past dates:
		int d1=0,m1=0,y1=0,h1=0,min1=0,d2=0,m2=0,y2=0,h2=0,min2=0,am_pm1=0,am_pm2=0;
		String Temp = new java.text.SimpleDateFormat("hh:mm a d/MM/yyyy").format(new java.util.Date());

		//breaking Present time:
		String Temp_str="";
		for(int i=0,q=0;i<Temp.length();i++)
		{
			if(Temp.charAt(i)==':'||Temp.charAt(i)=='/'||Temp.charAt(i)==' ')
			{
				switch(q)
				{
					case 0: h1=Integer.parseInt(Temp_str); break;
					case 1: min1=Integer.parseInt(Temp_str); break;
					case 2: h1 += (Temp_str.equals("am")? 0:12); am_pm1=(Temp_str.equals("am")? 0:1); break;
					case 3: d1=Integer.parseInt(Temp_str); break;
					case 4: m1=Integer.parseInt(Temp_str); break;
				}
				Temp_str="";
				q++;
			}
			else
				Temp_str += Temp.charAt(i);
			if(i==Temp.length()-1)
				y1=Integer.parseInt(Temp_str);
		}
		Temp=D;
		Temp_str="";
		for(int i=0,q=0;i<Temp.length();i++)
		{
			if(Temp.charAt(i)==':'||Temp.charAt(i)=='/'||Temp.charAt(i)==' ')
			{
				switch(q)
				{
					case 0: h2=Integer.parseInt(Temp_str); break;
					case 1: min2=Integer.parseInt(Temp_str); break;
					case 2: h2 += (Temp_str.equals("am")? 0:12); am_pm2=(Temp_str.equals("am")? 0:1); break;
					case 3: d2=Integer.parseInt(Temp_str); break;
					case 4: m2=Integer.parseInt(Temp_str); break;
				}
				Temp_str="";
				q++;
			}
			else
				Temp_str += Temp.charAt(i);
			if(i==Temp.length()-1)
				y2=Integer.parseInt(Temp_str);
		}
			boolean flag=true;
			if(y1==y2)
			{
				if(m1==m2)
				{
					if(d2==d1)
					{
									if(am_pm2==1)
										h2+=12;
									if(am_pm1==1)
										h1+=12;
								if(am_pm1==0&&h1==12)
									h1 -= 12;
								if(am_pm2==0&&h2==12)
									h2 -= 12;
						if(h2==h1)
						{
									if(am_pm2==1)
										h2-=12;
									if(am_pm1==1)
										h1-=12;
								if(am_pm1==0&&h1==12)
									h1 -= 12;
								if(am_pm2==0&&h2==12)
									h2 -= 12;
							if(min1<min2)
							{
							}else
								flag=false;
						}else if(h1>=h2)
									flag=false;
					}else if(d1>=d2)
								flag=false;
				}else if(m1>=m2)
							flag=false;
			}else if(y1>=y2)
						flag=false;

		if(!flag)
		{
			if(!Des.equals(""))
			  	JOptionPane.showMessageDialog(new JFrame(),"You Missed :-\nTask: "+task+"\nDescription:-\n"+Des,"Alert",JOptionPane.WARNING_MESSAGE);
			  else
			  	JOptionPane.showMessageDialog(new JFrame(),"You Missed :-\nTask: "+task,"Alert",JOptionPane.WARNING_MESSAGE);
		}
	
		return flag;
	}
	private static void UPDATE()
	{
		File file=new File("DataFile.txt");
		String Data="";
		int D=0;
				try{
				    if(!file.exists()) file.createNewFile();
				    FileReader fr=new FileReader(file);
				    BufferedReader br=new BufferedReader(fr);
				    StringBuffer sb=new StringBuffer();
				    String line;
					while((line=br.readLine())!=null)
						if(++D!=0)
						  Data += line+"\n";
					fr.close();
				   }catch(Exception z){ }

				try{
				    file.delete();
				   }catch(Exception z){ }
		D/=5;
		int Loc=-1;
		int Len = Data.length();
		while((D--)>=1)
		{ 
			String task="",time="",d="",Des="",AB_Data="";
			boolean AlertBefore=false;

			//task:
			int Count_n=0;
			String line="";
			while(Count_n!=6)
			{
				Loc++;
				if(Loc<Len&&Data.charAt(Loc)!='\n')
					line+=Data.charAt(Loc);
				else
				{
					switch(Count_n)
					{
						case 0: task = line; line=""; break;
						case 1: Des = line; line="";
								{
									{
										String Temp_Des="";
										String Temp_D=Des;
										int len = Temp_D.length();
										for(int i=0;i<len;i++)
											if(Temp_D.charAt(i)=='\t')
												Temp_Des += "\n";
											else
												Temp_Des += Temp_D.charAt(i);
										Des =Temp_Des;
									}
								} break;
						case 2: time = line; line=""; break;
						case 3: d = line; line=""; break;
						case 4: AlertBefore = Boolean.parseBoolean(line); line=""; break;
						case 5: AB_Data = line; line="";
									if(Check(time.toLowerCase()+" "+d,task,Des))
										Add(task,time,d,Des,AlertBefore,AB_Data);
								break;
					}
					Count_n++;
				}
			}
		}
	}
	private static void Add(String task,String time,String D,String Des,boolean AlertBefore,String AB_Data)
	{

		Data Temp[] = new Data[Background.DATA.length+1];

		//updating Data:
		for(int i=0;i<Background.DATA.length;i++)
			Temp[i] = Background.DATA[i];

		Background.addMoreLoc+=104;
		Temp[Background.DATA.length] = new Data();
		Temp[Background.DATA.length].setValue(task,time,D,Des,AlertBefore,AB_Data);
		Background.DATA = Temp;

		if(Background.addMoreLoc > 312)
			Background.SheetLength += 104;
  		Background.addMore.setBounds(165,Background.addMoreLoc,60,30);
  		Background.addMore.setVisible(false);
  		Background.addMore.setVisible(true);
		Background.Sheet.setBounds(3,3,394,Background.SheetLength);
		Background.S.setValue(75);
	}
	public static void main(String args[])
	{
		new Background().setUp();
		UPDATE();
		try{
			if(Background.DATA.length==0)
				Background.DATA[0].Plate.setBounds(3,4,388,100);
		}catch(Exception q){}
	}
}