/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.fr.cassandrajavase;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import db.fr.cassandraPreparedStatement.PaysDAO;

public class ConnexionEtSelect {

    public static void main(String[] args) {

        Cluster cluster;
        Session session;

        try {
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

            // KeySpace ???
            session = cluster.connect("cours");

            ResultSet results = session.execute("SELECT * FROM pays");

            for (Row row : results) {
                System.out.format("%s %s\n", row.getString("id_pays"), row.getString("nom_pays"));
            }

            cluster.close();
            
            System.out.println("C'est fini !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    } /// main
} /// class
