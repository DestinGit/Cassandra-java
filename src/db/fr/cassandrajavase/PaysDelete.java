/*
 PaysDelete.java
 */
package fr.pb.cassandrajavase;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 *
 * @author pascal
 */
public class PaysDelete {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Cluster cluster;
        Session session;
        try {
            cluster = Cluster.builder().addContactPoint("127.0.0.1").build();

            session = cluster.connect("cours");
            session.execute("DELETE FROM pays WHERE id_pays = 'it'");

            cluster.close();

            System.out.println("Pays supprimé !!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } /// main

} /// class

