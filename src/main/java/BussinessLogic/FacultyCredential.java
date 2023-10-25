package BussinessLogic;

import java.sql.*;

public class FacultyCredential {
    private boolean flag=false;
    public boolean checkCredential(String eno,String pword,Connection con)
    {
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from facultycredentials");
            while(rs.next())
            {
                if(rs.getString("EN_NO").equals(eno) && rs.getString("Password").equals(pword))
                {
                    flag = true;
                }
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
}
