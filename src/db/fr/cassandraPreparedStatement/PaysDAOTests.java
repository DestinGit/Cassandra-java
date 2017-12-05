/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.fr.cassandraPreparedStatement;

/**
 *
 * @author yemei
 */
public class PaysDAOTests {
    public static void main(String[] args) {
        PaysDAO.insertPays("jp", "Japon");
       PaysDAO.selectOne("is");   
       PaysDAO.selectOne("jp");
    }
}
