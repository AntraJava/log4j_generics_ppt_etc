package net.antra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc {
	public static void main(String[] args) {
		go();
	}
	public static void go() {
		final String DB_URL = "jdbc:mysql://localhost/qa";
		final String USER = "root";
		final String PASS = "1234";
		final String sql = "SELECT seq_id, question, answer FROM qa_main limit 10";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			List<QuestionAnswer> list = processResult(rs);
			showResult(list);
		} catch (Exception se) {
			se.printStackTrace();
		}
		System.out.println("Done!");
	}


	private static List<QuestionAnswer> processResult(ResultSet rs) throws SQLException {
		List<QuestionAnswer> entityList = new ArrayList<QuestionAnswer>();
		while (rs.next()) {
			int id = rs.getInt("seq_id");
			String first = rs.getString("question");
			String last = rs.getString("answer");
			entityList.add(new QuestionAnswer(id,first,last));
		}
		return entityList;
	}

	private static void showResult(List<QuestionAnswer> list) {
		//list.forEach(e->{System.out.println(e.getId() + " Question: " + e.getQuestion());});
		list.stream()
			.sorted(
				(e1,e2) -> e1.getQuestion().compareTo(e2.getQuestion()))
			.forEach(e->{System.out.println(e.getId() + " Question: " + e.getQuestion());});
	}
}
