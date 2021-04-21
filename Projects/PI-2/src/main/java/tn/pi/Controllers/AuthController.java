package tn.pi.Controllers;

	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;
	import java.util.stream.Collectors;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.Authentication;
	import org.springframework.security.core.context.SecurityContextHolder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import tn.pi.Entity.ERole;
	import tn.pi.Entity.Role;
	import tn.pi.Entity.User;
	import tn.pi.Repository.RoleRepository;
	import tn.pi.Repository.UserRepository;
	import tn.pi.Security.Jwt.JwtUtils;
	import tn.pi.Security.Services.UserDetailsImpl;
	import tn.pi.payload.request.LoginRequest;
	import tn.pi.payload.request.SignupRequest;
	import tn.pi.payload.response.JwtResponse;
	import tn.pi.payload.response.MessageResponse;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RestController
	@RequestMapping("/api/auth")
	public class AuthController {
		
		@Autowired
		AuthenticationManager authenticationManager;

		@Autowired
		UserRepository userRepository;

		@Autowired
		RoleRepository roleRepository;

		@Autowired
		PasswordEncoder encoder;

		@Autowired
		JwtUtils jwtUtils;

		// http://localhost:8080/SpringMVC/servlet
		
		@PostMapping("/signin")
		public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, 
													 userDetails.getId(), 
													 userDetails.getUsername(), 
													 userDetails.getEmail(), 
													 roles));
		}

		@PostMapping("/signup")
		public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
			if (userRepository.existsByUsername(signUpRequest.getUsername())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: Username is already taken!"));
			}

			if (userRepository.existsByEmail(signUpRequest.getEmail())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Error: Email is already in use!"));
			}

			// Create new user's account
			User user = new User(signUpRequest.getUsername(), 
								 signUpRequest.getEmail(),
								 encoder.encode(signUpRequest.getPassword()));

			Set<String> strRoles = signUpRequest.getRole();
			Set<Role> roles = new HashSet<>();

			if (strRoles == null) {
				Role clientRole = roleRepository.findByName(ERole.Client)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(clientRole); 
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.Admin)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);

						break;
					case "owner":
						Role ownerRole = roleRepository.findByName(ERole.shop_owner)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(ownerRole);

						break;
					default:
						Role visitorRole = roleRepository.findByName(ERole.Visitor)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(visitorRole);
					}
				});
			}

			user.setRoles(roles);
			userRepository.save(user);

			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}

	}


