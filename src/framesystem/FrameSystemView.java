package framesystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import kadai.MySQL;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class FrameSystemView extends Frame implements ActionListener,WindowListener{


	private Button button1 = new Button("グラフ");
	CardLayout cardlayout;
	Panel panel;
	Panel btnpanel;
	

	public FrameSystemView(FrameSystemController controller) {
		// TODO Auto-generated constructor stub
		panel =new Panel();
		btnpanel = new Panel();
		addWindowListener(this);
		setTitle("Graph");
		cardlayout= new CardLayout();
		setLayout(cardlayout);
		btnpanel.add(button1,BorderLayout.CENTER);
		add(btnpanel); 
		add(panel); 
		button1.addActionListener(this); 

		

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1){
			int id;
			double percentage;
			String year;
			ResultSet rs;
			MySQL mysql = new MySQL();
			rs = mysql.selectAll();
			DefaultCategoryDataset data = new DefaultCategoryDataset();
			try {
				
				while(rs.next()){
				id = rs.getInt("id");
				year = rs.getString("year");
			    percentage = rs.getDouble("percentage");
			    data.addValue(percentage,"year",year); 
	 			panel.add(new Label("id:"+id+" / year"+year+" / percentage"+percentage)); 
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			    JFreeChart chart = 
			      ChartFactory.createLineChart("大学進学率",
			                                   "年度",
			                                   "パーセント(%)",
			                                   data,
			                                   PlotOrientation.VERTICAL,
			                                   true,
			                                   false,
			                                   false);

			    ChartPanel cpanel = new ChartPanel(chart);
			    panel.add(cpanel);
			    cardlayout.next(this);

		}
	}

}

