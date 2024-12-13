package infra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import infra.dto.UserDto;
import infra.entity.User;
import infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder; // 비밀번호 암호화
	
	public void registerUser(UserDto userDto) {
		User user = userDto.toEntity();
		userRepository.save(user);
		
	}
	
	public Optional<UserDto> searchUser(String uid) {
		return userRepository.findById(uid)
				.map(UserDto::from);
	}
	
//로그인 로직
	public UserDto loginUser(String uid, String password) {
        User user = userRepository.findByUid(uid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }

        return UserDto.from(user); // 로그인 성공 시 UserDto 반환
    }

}
