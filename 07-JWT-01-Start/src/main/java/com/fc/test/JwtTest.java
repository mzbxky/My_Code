package com.fc.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void encoding(){
        Map<String ,Object> header = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,10);
        header.put("alg","HS256");//加密算法
        header.put("typ","JWT");//类型\
        //载荷
        Map<String ,Object> payload = new HashMap<>();
        payload.put("id",1);
        payload.put("username","黑小虎");
        payload.put("info","加点东西");
        payload.put("createTime",new Date());
        payload.put("lastAccessTime",new Date());
        payload.put("exp",instance.getTime());

       String token = JWT
                .create()
                .withHeader(header)//携带头部
                .withPayload(payload)
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(token);
    }
    @Test
    public void decode(){
        //获取验证器
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256("123456")).build();
        DecodedJWT decodedJWT = verifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsYXN0QWNjZXNzVGltZSI6MTY0OTEyMjEwMywiY3JlYXRlVGltZSI6MTY0OTEyMjEwMywiaWQiOjEsInVzZXJuYW1lIjoi6buR5bCP6JmOIiwiaW5mbyI6IuWKoOeCueS4nOilvyJ9.cEfaNml5GxDeEV3TY_nBU9g-NOPzkxp4Buy-lzX6W5Y");

        System.out.println(decodedJWT.getHeader());
        System.out.println(decodedJWT.getPayload());
        System.out.println(decodedJWT.getAlgorithm());
        System.out.println(decodedJWT.getSignature());
        System.out.println(decodedJWT.getClaim("username"));

    }
}
