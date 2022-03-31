package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	// write your code here

        Class.forName ("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://msz-test.chq8qedm9jee.eu-west-1.rds.amazonaws.com/postgres",
                "postgres",
                "1dQxvBLTEpKTfgxQGD5FN"
        );
        Statement st = con.createStatement();
        st.execute("DROP table if exists students_sobolewski");
        st.execute("CREATE TABLE students_sobolewski(" +
                "first_name text," +
                "last_name text," +
                "class_id int)");
        st.execute("INSERT into students_sobolewski values ('Dominik', 'Sobolewski',1 )");
        ResultSet ds = st.executeQuery("SELECT last_name, class_id FROM students_sobolewski");
        while(ds.next()){
            System.out.println(ds.getString("last_name"));
            System.out.println(ds.getInt("class_id"));
        }
        con.close();
    }

}
