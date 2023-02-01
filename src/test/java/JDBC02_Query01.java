import java.sql.*;

public class JDBC02_Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        Statement st=con.createStatement();

        /*=======================================================================
         ORNEK1: Id'si 1'den buyuk firmalarin ismini ve iletisim_isim'ini isim
         ters sirali yazdirin.
        ========================================================================*/
        /*
        CREATE TABLE firmalar
        (
        id INT,
        isim VARCHAR(20),
        iletisim_isim VARCHAR(20),
        CONSTRAINT firmalar_pk PRIMARY KEY (id, isim)
        );

        INSERT INTO firmalar VALUES
        (1, 'ACB', 'Ali Can'),
        (2, 'RDB', 'Veli Gul'),
        (3, 'KMN', 'Ayse Gulmez');
         */
        String selectquery="select isim,iletisim_isim from firmalar where id>1 order by isim desc";

        ResultSet data=st.executeQuery(selectquery);

        while(data.next()){
            System.out.println(data.getString("isim")+" "+data.getString("iletisim_isim"));

        }

        System.out.println("******************ornek 2***********************");
/*=======================================================================
         ORNEK2: Iletisim isminde 'li' iceren firmalarin id'lerini ve isim'ini
          id sirali yazdirin.
        ========================================================================*/

        String selectquery2="select id,isim from firmalar where iletisim_isim like '%li%' order by id";

        ResultSet data1= st.executeQuery(selectquery2);

        while(data1.next()){
            System.out.println(data1.getInt("id")+" "+data1.getString("isim"));
        }




    }
}
