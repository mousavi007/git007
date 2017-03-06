package com.example.mousavi.git007.network;

import com.example.mousavi.git007.models.pojo.AuthEntity;
import com.example.mousavi.git007.models.pojo.NetConstant;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {
    /**
     * @param CLIENT_ID
     * @param CLIENT_SECRET
     * @param code
     */

    @POST(NetConstant.API_OAUTH2_ACCESS_TOKEN)
    Observable<AuthEntity> refreshToken(
            @Query("CLIENT_ID") String CLIENT_ID,
            @Query("CLIENT_SECRET") String CLIENT_SECRET,
            @Query("code") String code);

    /**
     * @param username
     * @param password
     */
    @POST(NetConstant.API_OAUTH2_ACCESS_TOKEN)
    Observable<AuthEntity> login(
            @Query("app_key") String app_key,
            @Query("app_secret") String app_secret,
            @Query("grant_type") String grant_type,
            @Query("username") String username,
            @Query("password") String password);

    class GrantType {
        public static final String PASSWORD = "password";
        public static final String REFRESH_TOKEN = "refresh_token";
    }
}
