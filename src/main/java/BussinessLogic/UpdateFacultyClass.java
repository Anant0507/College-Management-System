
package BussinessLogic;

import java.sql.*;


public class UpdateFacultyClass {
    public boolean updateFaculty(String en_no, String name, String email, String pass, String Dept, String Quali, String Scode, String SubName,Connection con) 
    {
        boolean flag=false;
        try{
            Statement st = con.createStatement();  
            ResultSet rs = st.executeQuery("Select * from facultycredentials");
            PreparedStatement pst = con.prepareStatement("UPDATE facultycredentials SET Name = ?, Email = ?, Password = ?, Department = ?, Qualification = ?, SubjectCode = ?, SubjectName = ? WHERE EN_NO = ?");
            pst.setString(8, en_no);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);
            pst.setString(4, Dept);
            pst.setString(5, Quali);
            pst.setString(6, Scode);
            pst.setString(7, SubName);
            pst.executeUpdate();
            flag=true;
        }catch(Exception e)
        {
            System.out.println(e);
        }
       return flag;
    }

}
