package com.programming.hoangpn.Login_LogOut.repository;

import com.programming.hoangpn.Login_LogOut.model.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author PhanHoang
 * 9/16/2020
 */
@Repository
public interface UserTokenRepository extends JpaRepository<UserToken, Integer> {
    List<UserToken> findByToKenAndIsActive(String token, String active);

    List<UserToken> findAllByUserName(String userName);

    UserToken getUserTokenById(Integer id);
}
