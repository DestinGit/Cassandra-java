/*
 PaysInsert.java
 */
package fr.pb.cassandrajavase;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 *
 * @author pascal
 */
public class PaysInsert {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Cluster cluster;
        Session session;
        try {
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
            // KeySpace ???
            session = cluster.connect("cours");

            session.execute("INSERT INTO pays(id_pays, nom_pays) VALUES('it', 'Italie')");

            cluster.close();

            System.out.println("Enregistrement ajouté !!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } /// main

} /// class
