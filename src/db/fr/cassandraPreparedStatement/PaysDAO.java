/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.fr.cassandraPreparedStatement;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.util.Iterator;

/**
 *
 * @author yemei
 */
public class PaysDAO {
//    private static Session session = null;

    public static void selectOne(String id_pays) {
        Cluster cluster;
        Session session;

        String query = "SELECT * FROM pays WHERE id_pays = ? ";

        try {
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

            // KeySpace ???
            session = cluster.connect("cours");

            PreparedStatement stmt = session.prepare(query);
            BoundStatement bind = stmt.bind(id_pays);

            ResultSet results = session.execute(bind);

            for (Row row : results) {
                System.out.format("%s %s\n", row.getString("id_pays"), row.getString("nom_pays"));
            }

            cluster.close();

            System.out.println("C'est fini !");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertPays(String id_pays, String nom_pays) {
        Cluster cluster;
        Session session;

        String query = "INSERT INTO pays(id_pays, nom_pays) VALUES(?,?)";

        try {
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
            // KeySpace ???
            session = cluster.connect("cours");

            PreparedStatement stmt = session.prepare(query);
            BoundStatement bind = stmt.bind(id_pays, nom_pays);
            
            ResultSet results = session.execute(bind);
            System.out.println("tototo : " + results);
            
            cluster.close();

            System.out.println("Enregistrement ajouté !!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
