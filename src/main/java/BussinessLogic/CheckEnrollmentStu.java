package BussinessLogic;
import java.sql.*;

public class CheckEnrollmentStu {
    private boolean flag = false;
    public boolean checkEno(String eno,Connection con)
    {
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from student1");
            System.out.println("Inside CheckEnrollmentStu...");
            while(rs.next())
            {
                if(eno.equals(rs.getString("EN_NO")))
                {
                    flag = true;
                    break;
                }
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
}
