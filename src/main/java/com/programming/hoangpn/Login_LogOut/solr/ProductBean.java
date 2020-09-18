package com.programming.hoangpn.Login_LogOut.solr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

/**
 * @author PhanHoang
 * 9/18/2020
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBean {

    String id;
    String name;
    String price;

    @Field("id")
    protected void setId(String id) {
        this.id = id;
    }

    @Field("name")
    protected void setName(String name) {
        this.name = name;
    }

    @Field("price")
    protected void setPrice(String price) {
        this.price = price;
    }

    // getters and constructor omitted for space
}
