package johnbryce.lab7.solution;

import java.awt.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class FormApproval {
	JFrame f;
	public FormApproval(){
		f=new JFrame();
		f.setLocation(100,250);
		f.setSize(230,300);
		f.add(new JLabel(" "),BorderLayout.EAST);
		f.add(new JLabel(" "),BorderLayout.WEST);
		f.getContentPane().setFont(new Font("Arial",Font.PLAIN,12));
		setComponents("aaa",23);
		f.setVisible(true);
	}

	private void setComponents(String itemID, int units ){
		
		ResourceBundle labels = ResourceBundle.getBundle("uiBundle.FormBundle");
	
		//title
		JLabel title=new JLabel(labels.getString("title"),SwingConstants.CENTER);
		Font header=new Font("Arial",Font.BOLD,20);
		title.setFont(header);
		f.getContentPane().add(BorderLayout.NORTH,title);
		
		//center
		//date & time of order
		JPanel center=new JPanel(new GridLayout(8,2));
		JLabel dateLabel=new JLabel(labels.getString("dateMsg"),(Integer)labels.getObject("align"));
		center.add(dateLabel);
		center.add(new JLabel(""));
		JLabel date=new JLabel(labels.getString("date"),(Integer)labels.getObject("align"));
		JLabel dateVal=new JLabel(((DateFormat)labels.getObject("dateVal")).format(new Date()),(Integer)labels.getObject("align"));
		center.add(date);
		center.add(dateVal);
		JLabel time=new JLabel(labels.getString("time"),(Integer)labels.getObject("align"));
		JLabel timeVal=new JLabel(((DateFormat)labels.getObject("timeVal")).format(new Date()),(Integer)labels.getObject("align"));
		center.add(time);
		center.add(timeVal);
		//order item details
		JLabel orderLabel=new JLabel(labels.getString("orderMsg"),(Integer)labels.getObject("align"));
		center.add(orderLabel);
		center.add(new JLabel(""));
		JLabel item=new JLabel(labels.getString("item"),(Integer)labels.getObject("align"));
		JLabel itemVal=new JLabel(itemID,(Integer)labels.getObject("align"));
		center.add(item);
		center.add(itemVal);
		JLabel unitsLabel=new JLabel(labels.getString("units"),(Integer)labels.getObject("align"));
		JLabel unitsVal=new JLabel(((NumberFormat)labels.getObject("unitsVal")).format(units),(Integer)labels.getObject("align"));
		center.add(unitsLabel);
		center.add(unitsVal);
		JLabel unitPrice=new JLabel(labels.getString("unitPrice"),(Integer)labels.getObject("align"));
		double unitPriceValue=getUnitPrice();
		JLabel unitPriceVal=new JLabel(((NumberFormat)labels.getObject("unitPriceVal")).format(unitPriceValue),(Integer)labels.getObject("align"));
		center.add(unitPrice);
		center.add(unitPriceVal);
		JLabel total=new JLabel(labels.getString("total"),(Integer)labels.getObject("align"));
		JLabel totalVal=new JLabel(((NumberFormat)labels.getObject("unitPriceVal")).format(unitPriceValue*units),(Integer)labels.getObject("align"));
		center.add(total);
		center.add(totalVal);
		if((Integer)labels.getObject("align")==SwingConstants.RIGHT)
			flip(center);
		f.getContentPane().add(center);
		
		//buttons
		JButton okButton=new JButton(labels.getString("ok"));
		JButton cancelButton=new JButton(labels.getString("cancel"));
		JPanel panel =new JPanel();
		panel.add(okButton);
		panel.add(cancelButton);
		f.getContentPane().add(BorderLayout.SOUTH,panel);
	}
	 
	private void flip(Container cont){
		//returns a mirror view of the given grid component
		Component[] comp=cont.getComponents();
		cont.removeAll();
		for(int i=1;i<comp.length;i=i+2){
			cont.add(comp[i]);
			cont.add(comp[i-1]);
		}
		
	}
	private double getUnitPrice(){
		return Math.random()*300;
	}
	public static void main(String[] args) throws Exception{
		Locale[] supportedLocales = {
				new Locale ("iw","IL"),
			    new Locale ("en","US")
			};
		Locale currentLocale=supportedLocales[0];
		Locale.setDefault(currentLocale);
		new FormApproval();
		

	}

}
