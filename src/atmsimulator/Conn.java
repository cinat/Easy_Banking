/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmsimulator;

import java.sql.*;
/**
 *
 * @author Olleh
 */
public class Conn {
 Connection c;
 Statement s;
 public Conn(){
  try{
      Class.forName("com.mysql.cj.jdbc.Driver");//loading the driver
      c=DriverManager.getConnection("jdbc:mysql:///projectjava","root","");
      s=c.createStatement();
  }   
  catch(Exception e)
  {
      System.out.println(e);
  }
 }
}
