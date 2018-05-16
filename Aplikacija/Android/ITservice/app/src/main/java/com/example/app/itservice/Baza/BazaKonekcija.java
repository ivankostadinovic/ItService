package com.example.app.itservice.Baza;

import android.util.Log;

import com.example.app.itservice.Klijent;
import com.example.app.itservice.Korisnik;
import com.example.app.itservice.Serviser;
import com.example.app.itservice.Problem;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.Properties;

import oracle.jdbc.driver.OracleConnection;
import oracle.jdbc.*;


public class BazaKonekcija

{
    private Korisnik korisnik;
    private String user;
    private String pass;
    private  String connectionUrl;
    private Connection con;
    private  Statement stmt;
    private Problem problem;
    private Properties dbProperties;
    public BazaKonekcija()
    {
        korisnik=null;
        connectionUrl= "jdbc:oracle:thin:@//projekat.dyndns-free.com:1522";
        user="servis";
        pass="servis";
        con = null;
        stmt = null;
        problem=new Problem();
        dbProperties=new Properties();
    }
    public boolean updatePass(Korisnik k)
    {
        korisnik=k;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(connectionUrl,user,pass);
            String SQL ="UPDATE KORISNIK SET PASSWORD='"+korisnik.getPassword()+"'"+ "WHERE ID='"+korisnik.getID()+"'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


        }
        catch (Exception e) {
            e.printStackTrace();
            int error = Log.e("Error", e.toString());


        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}

        }
        return true;

    }

    public boolean unesiKlijenta(Korisnik k)
    {
        boolean flag=true;
        korisnik=k;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(connectionUrl,user,pass);
            String SQL ="INSERT INTO KORISNIK(IME,PREZIME,USERNAME,PASSWORD,EMAIL,TELEFON,FLAG_KLIJENT,NAZIV_FIRME,TOKEN) VALUES(" +"'"+korisnik.getIme()+"'"+","+"'"+korisnik.getPrezime()
                    +"'"+","+"'"+korisnik.getUsername()+"'"+","+"'"+korisnik.getPassword()+"'"+","+"'"+korisnik.getEmail()+"'"+","+"'"+korisnik.getBrojtelefona()
                    +"'"+","+"'"+"1"+"'"+","+"'"+((Klijent)korisnik).getNazivFirme()+"'"+","+"'"+korisnik.getToken()+"'"+")";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);


        }
        catch (Exception e) {
            e.printStackTrace();
            int error = Log.e("Error", e.toString());
            flag=false;


        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}

        }
        return flag;

    }
    public Korisnik proveriEmailToken(String email,String token) {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(connectionUrl, user, pass);
            String SQL = "SELECT * FROM KORISNIK WHERE EMAIL='" + email + "'" + "AND TOKEN='" + token + "'";
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int flagKlijent = rs.getInt("FLAG_KLIJENT");
                if (flagKlijent == 0) {
                    korisnik = new Serviser();
                    ((Serviser) korisnik).setJmbg(rs.getString("JMBG"));
                    ((Serviser) korisnik).setDatumZaposljenja(rs.getDate("DATUM_ZAPOSLENJA"));
                } else {
                    korisnik = new Klijent();
                    ((Klijent) korisnik).setNazivFirme(rs.getString("NAZIV_FIRME"));
                }
                korisnik.setID(rs.getInt("ID"));
                korisnik.setIme(rs.getString("IME"));
                korisnik.setPrezime(rs.getString("PREZIME"));
                korisnik.setUsername(rs.getString("USERNAME"));
                korisnik.setPassword(rs.getString("PASSWORD"));
                korisnik.setEmail(rs.getString("EMAIL"));
                korisnik.setBrojtelefona(rs.getString("TELEFON"));
                korisnik.setToken(rs.getString("TOKEN"));

            }
        }


        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            int error = Log.e("Error", e.toString());
            korisnik = null;
        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}

        }
        return  korisnik;
    }
    public Korisnik  proveriLogin(String email,String password)
    {

    try {
        // Establish the connection.
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con = DriverManager.getConnection(connectionUrl,user,pass);
        //Get information from EditText

        /*dbProperties.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
        dbProperties.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");

        oracle.jdbc.dcn.DatabaseChangeRegistration dbChangeRegistration=((OracleConnection)con).registerDatabaseChangeNotification(dbProperties);

        DBListener listener = new DBListener();
        dbChangeRegistration.addListener(listener);


        //associate the statement with the registration:
        ((OracleStatement) stmt).setDatabaseChangeRegistration(dbChangeRegistration);
        */

         //Create and execute an SQL statement that returns some data.

        String SQL = "SELECT * FROM KORISNIK WHERE EMAIL='"+email+"'"+"AND PASSWORD='"+password+"'";
         stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(SQL);

         while(rs.next())
         {
             int flagKlijent= rs.getInt("FLAG_KLIJENT");
             if(flagKlijent==0)
             {
                 korisnik = new Serviser();
                 ((Serviser)korisnik).setJmbg(rs.getString("JMBG"));
                 ((Serviser)korisnik).setDatumZaposljenja(rs.getDate("DATUM_ZAPOSLENJA"));
             }
             else
             {
                 korisnik = new Klijent();
                 ((Klijent)korisnik).setNazivFirme(rs.getString("NAZIV_FIRME"));
             }
             korisnik.setID(rs.getInt("ID"));
             korisnik.setIme(rs.getString("IME"));
             korisnik.setPrezime(rs.getString("PREZIME"));
             korisnik.setPassword(rs.getString("PASSWORD"));
             korisnik.setEmail(rs.getString("EMAIL"));
             korisnik.setBrojtelefona(rs.getString("TELEFON"));
             korisnik.setToken(rs.getString("TOKEN"));




         }

        Log.e("govno", "Success");

    }

    // Handle any errors that may have occurred.
    catch (Exception e) {
        e.printStackTrace();
        int error = Log.e("Error", e.toString());
        korisnik=null;
    }
    finally {
        if (stmt != null) try { stmt.close(); } catch(Exception e) {}
        if (con != null) try { con.close(); } catch(Exception e) {}

    }
    return korisnik;
}

    public boolean upisiProblem()
    {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(connectionUrl, user, pass);
            stmt = con.createStatement();

            dbProperties.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
            dbProperties.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");

            oracle.jdbc.dcn.DatabaseChangeRegistration dbChangeRegistration=((OracleConnection)con).registerDatabaseChangeNotification(dbProperties);

            DBListener listener = new DBListener();
            dbChangeRegistration.addListener(listener);


            //associate the statement with the registration:
            ((OracleStatement) stmt).setDatabaseChangeRegistration(dbChangeRegistration);


            String SQL = "SELECT SERVISER_ID,KLIJENT_ID,PROBLEM_ID FROM ZAHTEV WHERE KLIJENT_ID=2";

            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                //problem.setVremePolaska(rs.getTimestamp("VREME_POLASKA"));



            }
        }


        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
            int error = Log.e("Error", e.toString());
            korisnik = null;
        }
        finally {
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}

        }
        return  true;

    }
}
