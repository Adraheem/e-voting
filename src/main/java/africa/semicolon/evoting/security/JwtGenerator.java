package africa.semicolon.evoting.security;

import africa.semicolon.evoting.data.models.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@AllArgsConstructor
public class JwtGenerator {

    private SecurityConstants securityConstants;

    public String generateToken(UserEntity user) {
        String username = user.getUsername();
        return generateToken(username);
    }

    public String generateToken(Authentication authentication) {
        AuthenticatedUser authenticatedUser = (AuthenticatedUser) authentication.getPrincipal();
        String username = authenticatedUser.getUsername();
        return generateToken(username);
    }

    public String generateToken(String username) {
        Date currentDate = new Date();
        Date expirationDate = new Date(currentDate.getTime() + securityConstants.getJwtExpirationTime());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, securityConstants.getJwtSecretKey())
                .compact();
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(securityConstants.getJwtSecretKey())
                .parseClaimsJws(token).getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        System.out.println(token);
        try {
            Jwts.parser()
                    .setSigningKey(securityConstants.getJwtSecretKey())
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationCredentialsNotFoundException("Invalid token");
        }
    }
}
