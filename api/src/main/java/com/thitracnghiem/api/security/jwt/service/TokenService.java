package com.thitracnghiem.api.security.jwt.service;
import com.thitracnghiem.api.entities.user.repos.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public boolean isValidToken(String jti) {
        return tokenRepository.findByTokenId(jti) != null;
    }

}
