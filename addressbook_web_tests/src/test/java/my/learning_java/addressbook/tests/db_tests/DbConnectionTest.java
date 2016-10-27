package my.learning_java.addressbook.tests.db_tests;


import my.learning_java.addressbook.model.db_model.GroupDataDB;
import my.learning_java.addressbook.model.db_model.GroupsDB;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {

    @Test
    public void testDbConnection(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?serverTimezone=UTC&user=root&password=");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
            GroupsDB groups = new GroupsDB();
            while (rs.next()){
                groups.add(new GroupDataDB().withId(rs.getInt("group_id")).withName(rs.getString("group_name")).withHeader(rs.getString("group_header"))
                        .withFooter(rs.getString("group_footer")));
            }
            rs.close();
            st.close();
            conn.close();

            System.out.println(groups);

            // Do something with the Connection


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

}
