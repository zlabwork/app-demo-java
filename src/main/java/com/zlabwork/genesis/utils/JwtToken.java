package com.zlabwork.genesis.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtToken {

    private String secret = "secret";

    private String iss = "zlab";

    public String generateToken() throws JWTCreationException {

        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            String token = JWT.create()
                    .withIssuer(this.iss)
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw exception;
        }
    }

    public DecodedJWT verifyToken(String token) throws JWTVerificationException {

        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify an specific claim validations
                    .withIssuer(this.iss)
                    // reusable verifier instance
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
            return decodedJWT;
        } catch (JWTVerificationException exception) {
            throw exception;
        }

    }

}