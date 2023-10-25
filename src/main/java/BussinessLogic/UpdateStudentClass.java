
package BussinessLogic;

import java.sql.*;

public class UpdateStudentClass {
    
    public boolean updateStudent(String eno,String name,String email,String pword,String dept,String sub1,String sub2,String sub3,String status,Connection con)
    {  
        boolean flag = false;
        try{
            PreparedStatement pst = con.prepareStatement("UPDATE student1 SET NAME=?,EMAIL=?,PASSWORD=?,DEPARTMENT=?,SUB1=?,SUB2=?,SUB3=?,STATUS=? WHERE EN_NO=?");
            pst.setString(1,name);
            pst.setString(2,email);
            pst.setString(3,pword);
            pst.setString(4,dept);
            pst.setFloat(5,Float.parseFloat(sub1));
            pst.setFloat(6,Float.parseFloat(sub2));
            pst.setFloat(7,Float.parseFloat(sub3));
            pst.setString(8,status);
            pst.setString(9,eno);
            pst.executeUpdate();
            flag = true;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
}
