/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinessLogic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Manoj
 */
public class StudentCredential {
    public boolean checkStuCredential(String Eno,String pword,Connection con) 
    {
        boolean flag=false;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from student1");
            while(rs.next())
            {
                if(rs.getString("EN_NO").equals(Eno) && rs.getString("PASSWORD").equals(pword))
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
