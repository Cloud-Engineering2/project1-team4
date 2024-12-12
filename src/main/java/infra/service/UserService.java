package infra.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import infra.dto.UserDto;
import infra.entity.User;
import infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;

	public void registerUser(UserDto userDto) {
		User user = userDto.toEntity();
		userRepository.save(user);
		
	}
	
	public Optional<UserDto> searchUser(Long uid) {
		return userRepository.findById(uid)
				.map(UserDto::from);
	}

}
