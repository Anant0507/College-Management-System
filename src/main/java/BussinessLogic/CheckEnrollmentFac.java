/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinessLogic;

import java.sql.*;


/**
 *
 * @author Manoj
 */
public class CheckEnrollmentFac {
    private boolean flag = false;
    public boolean checkEno(String eno,Connection con)
    {
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from facultycredentials");
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
