package com.programming.hoangpn.Login_LogOut.solr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

/**
 * @author PhanHoang
 * 9/18/2020
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Field
    private String id;

    @Field
    private String description;

    @Field
    private String category;

    @Field
    private float price;
}
