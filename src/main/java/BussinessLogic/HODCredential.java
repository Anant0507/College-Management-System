package BussinessLogic;

import java.sql.*;
public class HODCredential {
    private boolean flag=false;
    public boolean checkCredential(String eno,String pword,Connection con)
    {
        System.out.println(eno);
        System.out.println(pword);
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from hodcredential");
            while(rs.next())
            {
                if(rs.getString("EN_NO").equals(eno) && rs.getString("PASSWORD").equals(pword))
                {
                    flag = true;
                }
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println(flag);
        return flag;
    }
}
