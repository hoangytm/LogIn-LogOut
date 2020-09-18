package com.programming.hoangpn.Login_LogOut.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;

/**
 * @author PhanHoang
 * 9/18/2020
 */

public class SolrjExample {
    public static String SOLR_URL = "http://localhost:8983/solr/bigboxstore";

    public static void main(String[] args) throws IOException, SolrServerException {
        HttpSolrClient solr = new HttpSolrClient.Builder(SOLR_URL).build();
        solr.setParser(new XMLResponseParser());
        setData(solr);

    }

    public static void setData(HttpSolrClient solr) throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "123456");
        document.addField("name", "Kenmore Dishwasher");
        document.addField("price", "599.99");
        solr.add(document);
        solr.commit();
    }

}