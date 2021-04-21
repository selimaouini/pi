package tn.pi.Controllers;

	import org.springframework.security.access.prepost.PreAuthorize;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RestController
	@RequestMapping("/api/test")
	public class TestController {
		
		@GetMapping("/all")
		public String allAccess() {
			return "Public Content.";
		}
		
		@GetMapping("/client")
		@PreAuthorize("hasRole('CLIENT') or hasRole('SHOPOWNER') or hasRole('ADMIN') or hasRole('VISITOR')")
		public String clientAccess() {
			return "Clientr Content.";
		}

		@GetMapping("/shopowner")
		@PreAuthorize("hasRole('SHOPOWNER')")
		public String shopownerAccess() {
			return "Shop Owner Board.";
		}

		@GetMapping("/admin")
		@PreAuthorize("hasRole('ADMIN')")
		public String adminAccess() {
			return "Admin Board.";
		}
		
		@GetMapping("/visitor")
		@PreAuthorize("hasRole('VISITOR')")
		public String visitorAccess() {
			return "Visitor Content.";
		}

	}

