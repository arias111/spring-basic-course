package com.spring.basics.services.impletentations;

import com.auth0.jwt.algorithms.Algorithm;
import com.spring.basics.dto.TokenDto;
import com.spring.basics.dto.forms.UserAuthForm;
import com.spring.basics.exceptions.LoginProcessErrorException;
import com.spring.basics.models.Token;
import com.spring.basics.models.User;
import com.spring.basics.repositories.TokenRepository;
import com.spring.basics.repositories.UsersRepository;
import com.spring.basics.services.interfaces.SignInService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;


import java.time.LocalDateTime;
import java.util.function.Supplier;


@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private TokenRepository tokensRepository;

    @Override
    public User signIn(UserAuthForm signInForm) throws LoginProcessErrorException {
        User user = usersRepository.findByEmail(signInForm.getEmail())
                .orElseThrow(() -> new LoginProcessErrorException("User not found"));
        boolean passwordResult = passwordEncoder.matches(signInForm.getPassword(), user.getPassword());
        if(passwordResult) return user;
        return null;
    }

    @Value("${jwt.secret}")
    private String secret;

    @SneakyThrows
    @Override
    public TokenDto signInToken(UserAuthForm userAuthForm) {
        User user = usersRepository.findByEmail(userAuthForm.getEmail())
                .orElseThrow((Supplier<Throwable>) () -> new UsernameNotFoundException("User not found"));
        if (passwordEncoder.matches(userAuthForm.getPassword(), user.getPassword())) {

            String tokenValue = JWT.create()
                    .withSubject(user.getId().toString())
                    .withClaim("role", user.getRole().toString())
                    .withClaim("state", user.getState().toString())
                    .withClaim("email", user.getEmail())
                    .withClaim("createdAt", LocalDateTime.now().toString())
                    .sign(Algorithm.HMAC256(secret));

            Token token = Token.builder()
                    .token(tokenValue)
                    .user(user)
                    .build();

            tokensRepository.save(token);

            return TokenDto.builder()
                    .token(tokenValue)
                    .build();
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }

}
