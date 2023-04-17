package com.allas.api_school.controller;

import com.allas.api_school.dto.authentication.DataAuthentication;
import com.allas.api_school.dto.authentication.DataToken;
import com.allas.api_school.infra.security.AuthenticationCentral;
import com.allas.api_school.infra.security.TokenService;
import com.allas.api_school.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationCentral authenticationCentral;

    @PostMapping
    @Transactional
    public ResponseEntity<DataToken> authenticationLogin(@RequestBody DataAuthentication dataAuthentication) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dataAuthentication.getUsername(), dataAuthentication.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String token = tokenService.generateToken((User) authenticate.getPrincipal());

        return ResponseEntity.ok(new DataToken(token));
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<DataToken> signUp(@RequestBody DataAuthentication dataAuthentication) {
        User user = authenticationCentral.cryptography(dataAuthentication);
        String token = tokenService.generateToken(user);
        return ResponseEntity.ok(new DataToken(token));
    }
}
