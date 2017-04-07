package pl.ndt.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ndt.manager.dto.UserDTO;

import pl.ndt.manager.model.User;
import pl.ndt.manager.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Creates application user
	 * 
	 * @param email
	 *            user's email
	 * @param password
	 *            user's password
	 * @return user
	 */

	public UserDTO createUser(String email, String password) {

		User user = userRepository.findByEmail(email);
		if (user.equals(null)) {
			return null;
		} else {
			if (user.getPassword().equals(password)) {
				UserDTO userDto = new UserDTO(user.getEmployee().getFirstName(), user.getEmployee().getLastName(),
						user.getRole());
				return userDto;
			} else {
				return null;
			}
		}
	}

}
