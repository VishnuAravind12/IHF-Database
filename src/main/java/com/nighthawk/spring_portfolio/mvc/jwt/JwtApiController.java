package com.nighthawk.spring_portfolio.mvc.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nighthawk.spring_portfolio.mvc.person.Person;
import com.nighthawk.spring_portfolio.mvc.person.PersonDetailsService;

@RestController
@CrossOrigin

// PURPOSE
// Handles user login/authentication 
// Generates & issues JWTs upon successful authentication 

public class JwtApiController {

    // Three important dependencies

    @Autowired
    // Authenticate users
    private AuthenticationManager authenticationManager;

    @Autowired
    // Validate JWTs
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    // Retrieve user info
    private PersonDetailsService personDetailsService;

    // Controller method handles HTTP POST requests to this endpoint
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Person authenticationRequest) throws Exception {
        // Authenticate the user
        authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

        // Load user details
        final UserDetails userDetails = personDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        // Generate JWT
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Create an HTTP-only secure cookie with the JWT
        final ResponseCookie tokenCookie = ResponseCookie.from("jwt", token)
            .httpOnly(true)
            .secure(true)
            .path("/")
            .maxAge(3600)
            .sameSite("None; Secure")
            // .domain("example.com") // Set to backend domain if needed
            .build();

        // Return HTTP response with JWT cookie
        System.out.println(tokenCookie.toString());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, tokenCookie.toString()).build();
    }

    // Called internally to authenticate the user
    private void authenticate(String username, String password) throws Exception {
        try {
            // Use AuthenticationManager to authenticate the user based on provided credentials
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            // Handle if the user account is disabled
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            // Handle if provided credentials are invalid
            throw new Exception("INVALID_CREDENTIALS", e);
        } catch (Exception e) {
            // Handle other authentication exceptions
            throw new Exception(e);
        }
    }
}
