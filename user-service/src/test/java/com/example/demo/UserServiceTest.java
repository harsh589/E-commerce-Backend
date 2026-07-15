package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceTest {

    UserRepo repo = mock(UserRepo.class);
    PasswordEncoder encoder = mock(PasswordEncoder.class);
    JwtUtil util = mock(JwtUtil.class);

    @Test
    void login_success() {
        UserService service = new UserService(repo, encoder, util);

        // input user
        UserModel input = new UserModel();
        input.setEmail("test@gmail.com");
        input.setName("harsh");
        input.setPassword("123");

        // db user
        UserModel dbuser = new UserModel();
        dbuser.setEmail("test@gmail.com");
        dbuser.setName("harsh");
        dbuser.setPassword("encodepassword");

        // mock behaviour
        when(repo.findByEmail("test@gmail.com")).thenReturn(dbuser);
        when(encoder.matches("123", "encodepassword")).thenReturn(true);
        when(util.generateToken("test@gmail.com")).thenReturn("my-token");

        String token = service.login(input);

        assertEquals("my-token", token);
    }

    @Test
    void notLogin() {
        UserService service = new UserService(repo, encoder, util);

        // input user
        UserModel input = new UserModel();
        input.setEmail("test@gmail.com");
        input.setName("harsh");
        input.setPassword("1234");

        // db user
        UserModel dbuser = new UserModel();
        dbuser.setEmail("test@gmail.com");
        dbuser.setName("harsh");
        dbuser.setPassword("encodepassword");

        // mock behaviour
        when(repo.findByEmail("test@gmail.com")).thenReturn(dbuser);
        when(encoder.matches("1234", "encodepassword")).thenReturn(false);

        assertThrows(LoginFailed.class, () -> service.login(input));
    }
}