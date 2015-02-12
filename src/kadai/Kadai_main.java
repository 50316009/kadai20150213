package kadai;

import java.sql.ResultSet;
import java.sql.SQLException;

import framesystem.FrameSystemController;
import framesystem.FrameSystemView;

public class Kadai_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int id;
		double percentage;
		String year;
		ResultSet rs;
		MySQL mysql = new MySQL();
		rs = mysql.selectAll();
			try {
				while(rs.next()){
				    id = rs.getInt("id");
				    year = rs.getString("year");
				    percentage = rs.getDouble("percentage");
				    System.out.println("ID�F" + id);
				    System.out.println("�N�F" + year);
				    System.out.println("�p�[�Z���g�F" + percentage);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FrameSystemController controller = new FrameSystemController();
			FrameSystemView frame = new FrameSystemView(controller);
			frame.setBounds(5,5,655,455);
			frame.setVisible(true);





	
	
	
	}

}
