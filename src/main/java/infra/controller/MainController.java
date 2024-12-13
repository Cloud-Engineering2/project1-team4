package infra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import infra.dto.UserDto;
import infra.dto.request.UserRequest;
import infra.entity.constant.UserRoleType;
import infra.service.UserService;
import lombok.RequiredArgsConstructor;

/**
 * API
 * - 회원가입
 * - 로그인
 * 
 */
@RequiredArgsConstructor
@Controller
public class MainController {

	private final UserService userService;

	@GetMapping("/")
	public String mainPage() {
		return "forward:/posts";
	}

	@GetMapping("/guest/signup")
	public String guestSignupPage() {
		return "guest-sign-up";
	}
	@GetMapping("/host/signup")
	public String hostSignupPage() {
		return "host-sign-up";
	}

	@PostMapping("/signup")
	public String signup(UserRequest userRequest) {
		UserDto userDto = userRequest.toDto(UserRoleType.ADMIN);
		System.out.println(userDto);
		userService.registerUser(userDto);
		return "guest-sign-up";
	}

	@PostMapping("/login")
    public String loginUser(@RequestParam String uid, @RequestParam String password) {
		try {
            UserDto loggedInUser = userService.loginUser(uid, password);
            System.out.println("로그인 성공: " + loggedInUser);
            return "redirect:/dashboard"; // 로그인 성공 시 대시보드로 리다이렉트
        } catch (Exception e) {
            System.out.println("로그인 실패: " + e.getMessage());
            return "redirect:/login?error=true"; // 로그인 실패 시 에러 표시
        }
	}}
