package johnbryce.lab7.exercise;

	import java.awt.*;
	import java.util.*;
	import javax.swing.*;

	public class BadUI {
		JFrame f;
		public BadUI(){
			f=new JFrame();
			f.setLocation(100,250);
			f.setSize(230,300);
			f.add(new JLabel(" "),BorderLayout.EAST);
			f.add(new JLabel(" "),BorderLayout.WEST);
			f.getContentPane().setFont(new Font("Arial",Font.PLAIN,12));
			setComponents("aaa",23);
			f.setVisible(true);
		}
		
		//edit this method to use resource bundles
		//this method takes the chosen item and the no' of pieces to generage a complete order view
		private void setComponents(String itemID, int units ){
			
			//title
			JLabel title=new JLabel("Order Details",SwingConstants.CENTER);     //not locale sensitive !
			Font header=new Font("Arial",Font.BOLD,20);
			title.setFont(header);
			f.getContentPane().add(BorderLayout.NORTH,title);
			
			//center
			//date & time of order
			JPanel center=new JPanel(new GridLayout(8,2));
			JLabel dateLabel=new JLabel("Date of issue");     //not locale sensitive !
			center.add(dateLabel);
			center.add(new JLabel(""));
			JLabel date=new JLabel("Date");     //not locale sensitive !
			GregorianCalendar calendar=new GregorianCalendar();
			JLabel dateVal=new JLabel((calendar.get(Calendar.MONTH)+1)+"."+calendar.get(Calendar.YEAR));    //not locale sensitive !
			center.add(date);
			center.add(dateVal);
			JLabel time=new JLabel("Time");     //not locale sensitive !
			JLabel timeVal=new JLabel(calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE));    //not locale sensitive !
			center.add(time);
			center.add(timeVal);
			//order item details
			JLabel orderLabel=new JLabel("Item details");    //not locale sensitive !
			center.add(orderLabel);
			center.add(new JLabel(""));
			JLabel item=new JLabel("Item ID");     //not locale sensitive !
			JLabel itemVal=new JLabel(itemID);
			center.add(item);
			center.add(itemVal);
			JLabel unitsLabel=new JLabel("Units");     //not locale sensitive !
			JLabel unitsVal=new JLabel(units+"");      //not locale sensitive !
			center.add(unitsLabel);
			center.add(unitsVal);
			JLabel unitPrice=new JLabel("Unit Price");      //not locale sensitive !
			double unitPriceValue=getUnitPrice();
			JLabel unitPriceVal=new JLabel(unitPriceValue+"");   //not locale sensitive !
			center.add(unitPrice);
			center.add(unitPriceVal);
			JLabel total=new JLabel("Total");
			JLabel totalVal=new JLabel(unitPriceValue*units+"");
			center.add(total);
			center.add(totalVal);
			f.getContentPane().add(center);
			
			//buttons
			JButton okButton=new JButton("OK");            //not locale sensitive !
			JButton cancelButton=new JButton("Cancel");    //not locale sensitive !
			JPanel panel =new JPanel();
			panel.add(okButton);
			panel.add(cancelButton);
			f.getContentPane().add(BorderLayout.SOUTH,panel);
		}
		 
		@SuppressWarnings("unused")
		private void flip(Container cont) {
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
			new BadUI();
		}
}
