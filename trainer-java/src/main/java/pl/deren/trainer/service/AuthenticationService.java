package pl.deren.trainer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.deren.trainer.authentication.AuthenticationRequest;
import pl.deren.trainer.authentication.AuthenticationResponse;
import pl.deren.trainer.model.RegisterRequest;
import pl.deren.trainer.model.City;
import pl.deren.trainer.model.User;
import pl.deren.trainer.model.UserDetail;
import pl.deren.trainer.model.UserRole;
import pl.deren.trainer.repository.UserRepository;

import java.sql.Timestamp;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        UserRole userRole = new UserRole();
        userRole.setId(3L);

        City city = new City();
        city.setCity_name(request.getCity_name());

        UserDetail userDetail = new UserDetail();
        userDetail.setCity(city);
        userDetail.setCityId(city.getId());
        userDetail.setPhoneNumber(request.getPhone_number());
        userDetail.setSex(request.getSex());
        userDetail.setCreatedAt(Timestamp.from(Instant.now()));

        var user = User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userRole(userRole)
                .userDetail(userDetail)
                .id(54)
                .userDetailId(userDetail.getId())
                .userRoleId(userRole.getId())
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
