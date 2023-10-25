/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BussinessLogic;
import java.sql.*;
public class AddHODClass {
    boolean flag = false;
    public boolean addHOD(String eno,String name,String email,String pword,String dept,Connection con)
    {
        try{
            PreparedStatement pst = con.prepareStatement("Insert into hodcredential values(?,?,?,?,?)");
            pst.setString(1,eno);
            pst.setString(2,name);
            pst.setString(3,email);
            pst.setString(4,pword);
            pst.setString(5,dept);
            pst.executeUpdate();
            flag = true;
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
            
}
