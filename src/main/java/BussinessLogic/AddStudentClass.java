
package BussinessLogic;
import java.sql.*;
import javax.servlet.http.HttpSession;
public class AddStudentClass {
    private boolean flag = false;
    public boolean addStudent(String eno,String name,String email,String pword,String dept,String sub1,String sub2,String sub3,String status,Connection con)         
    {
        
        try{
            PreparedStatement pst = con.prepareStatement("Insert into student1 values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1,eno);
            pst.setString(2,name);
            pst.setString(3,email);
            pst.setString(4,pword);
            pst.setString(5,dept);
            pst.setFloat(6,Float.parseFloat(sub1));
            pst.setFloat(7,Float.parseFloat(sub2));
            pst.setFloat(8,Float.parseFloat(sub3));
            pst.setString(9,status);
            pst.executeUpdate();
            flag = true;
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
}
