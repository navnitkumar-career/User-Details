package net.javaguides.springboot.Serviceimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.Entites.Users;
import net.javaguides.springboot.Repository.UserRepository;
import net.javaguides.springboot.Service.UserService;
import net.javaguides.springboot.UserDTO.UserDTO;

@Service
public class UserServiceimpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	@Transactional
	@Override
	public List<UserDTO> getList() {

		List<Users> userList = userRepository.findAll();

		List<UserDTO> user = userList.stream().map(t -> {
			UserDTO users = new UserDTO();

			modelMapper.map(t, users);
			return users;
		}).collect(Collectors.toList());
		return user;

	}

	@Transactional
	@Override
	public boolean Add(UserDTO userAdd) {
		List<Users> userList = userRepository.findAll();

		boolean flag = false;

		for (Users user1 : userList) {
			if (user1.getEmailId().equals(userAdd.getEmailId())) {
				flag = false;
				break;
			} else {
				flag = true;
			}
		}

		if (flag) {
			Users user = new Users();
			modelMapper.map(userAdd, user);

			user.setDateTime(LocalDateTime.now());
			userRepository.save(user);
			modelMapper.map(user, userAdd);
			return flag;
		}
		return flag;
	}

	@Transactional
	@Override
	public boolean Update(UserDTO userEdit) {
		
		List<Users> userList = userRepository.findAll();
		boolean flag = false;

		for (Users user1 : userList) {
			if (user1.getEmailId().equals(userEdit.getEmailId())) {
				flag = false;
				break;
			} else {
				flag = true;
			}
		}

		if (flag) {
			Users user = userRepository.getById(userEdit.getId());
			user.setEmailId(userEdit.getEmailId());
			userRepository.save(user);
			modelMapper.map(user, userEdit);
			
		}
		return flag;
	}

	@Override
	public boolean DeleteById(String emailId) {

		Users user = userRepository.findByEmailId(emailId);

		if (user == null) {
			return false;
		} else {
			userRepository.deleteById(user.getId());
			return true;
		}

	}

	@Override
	public boolean validRequest(UserDTO user) {
		return isValidEmail(user.getEmailId());
	}

	private boolean isValidEmail(String emailId) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailId);
		return matcher.matches();
	}

}
