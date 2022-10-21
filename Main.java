import java.sql.*;
import java.util.Scanner;

class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college","root","");
            Statement stmt=con.createStatement();
            //String s="select * from teacher";
            String s1="select * from teacher where Subject='PHYSICS'";
            ResultSet rs=stmt.executeQuery(s1);
            PreparedStatement pt = con.prepareStatement("INSERT INTO teacher(Name,Id,Salary,Subject) VALUES(?,?,?,?)");
            Scanner sc=new Scanner(System.in);
            int i=4;
            try {
                while (i < 5) {
                    i++;
                    String name = sc.next();
                    int id = sc.nextInt();
                    int salary = sc.nextInt();
                    sc.nextLine();
                    String subject=sc.nextLine();
                    pt.setString(1, name);
                    pt.setString(4, subject);
                    pt.setInt(3, salary);
                    pt.setInt(2, id);
                    pt.execute();
                }

            }catch(Exception e) { System.out.println("Exception");}
            while(rs.next()){
               // i++;

                System.out.println(rs.getString(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + " " + rs.getString(4));
              //  if(i==6)break;
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
