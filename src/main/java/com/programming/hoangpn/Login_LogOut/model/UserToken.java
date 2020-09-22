package com.programming.hoangpn.Login_LogOut.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author PhanHoang
 * 9/16/2020
 */
@Entity
@Table(name = "USER_TOKEN")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "TOKEN", length = 300)
    private String toKen;
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Column(name = "IP")
    private String ip;
    @Column(name = "DEVICE")
    private String device;
    @Column(name = "BROWSER")
    private String browser;
    @Column(name = "IS_ACTIVE")
    private String  isActive;

}
