package toms.aplisens1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener {

	int c;
	String x;
	String[] kolumny = {"id", "opis", "nazwa"};
	
	JTable tab,tab2;
	JLabel naglowek,naglowek2;
	JButton przycisk,przycisk2;
	JTextField pole,pole2;
	
	Window tablica;
	Object[][] tablica1;

	Statement myStmt;
	Ogolna axx= new Ogolna();
	
	
	String getXlal() {
		return x;
	}

	public Window(){
		
		setLayout(new FlowLayout());
		setTitle("Aplisens Aparatura");
		setLocation(250, 200);
		setSize(800,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void oknoTabeli(Object tabelka[][],Statement myStmt){
		this.myStmt=myStmt;
		tablica= new Window();
		tablica1=tabelka;
		
		tab = new JTable(tabelka,kolumny);
		tab.setPreferredScrollableViewportSize(new Dimension(400,50));
		tab.setFillsViewportHeight(true);
		tab2 = new JTable(axx.getTablica1(),kolumny);
		tab2.setPreferredScrollableViewportSize(new Dimension(400,50));
		tab2.setFillsViewportHeight(true);
		
		naglowek = new JLabel("Lista produktów :");
		naglowek2 = new JLabel("Lista produktów "+x+":");
		
		JScrollPane scroll= new JScrollPane(tab);
		JScrollPane scroll2= new JScrollPane(tab2);
		
		przycisk= new JButton("Dalej");
		przycisk.addActionListener(this);
		przycisk2= new JButton("Zatwierdz");
		przycisk2.addActionListener(this);
		
		tablica.add(naglowek);
		tablica.add(scroll);
		tablica.add(przycisk);
		tablica.add(naglowek2);
		tablica.add(scroll2);
		tablica.add(przycisk2);
		tablica.setVisible(true);
	}
	
	public void parametry()
	{
		tablica= new Window();
//		tablica.setLayout(null);

		c= tab2.getSelectionModel().getLeadSelectionIndex();
		tablica1=axx.getTablica1();
		naglowek = new JLabel("SG/0..");
//		naglowek.setBounds(50, 50, 90, 55);
		pole = new JTextField();
//		pole.setBounds(90, 50, 91, 55);
		naglowek2 = new JLabel("/4..20mA/L=");
		pole2 = new JTextField();
		
		tablica.add(naglowek);
		tablica.add(pole);
		tablica.add(naglowek2);
		tablica.add(pole2);
		
		tablica.setVisible(true);
		System.out.println("wybrano w parametrach "+tablica1[c][1]+" : "+tablica1[c][2]);
		
	}
		
	public void actionPerformed(ActionEvent a) 
	{	
		Object zrodlo = a.getSource();
		if (zrodlo==przycisk)
		{
			tablica.setVisible(false);
			c= tab.getSelectionModel().getLeadSelectionIndex();
			x=String.valueOf(tablica1[c][2]);
			String polecenieSql="SELECT * FROM "+x;
			try 
			{
				axx.listaSQL(myStmt, polecenieSql);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			oknoTabeli(tablica1 ,myStmt);
		}
		if (zrodlo==przycisk2)
		{
			tablica.setVisible(false);
			parametry();
		}
	}
}	
	
	
// cos z polimrfizemem pomy�le�
// po co klasy og�lna ? czy abstrakcyjna ma sens byc abstrakcyjna