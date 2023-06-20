package com.PeerProgramming.Login.Service;

import com.PeerProgramming.Login.Entity.User;
import com.PeerProgramming.Login.Exceptions.EmailException;
import com.PeerProgramming.Login.Repository.UserRepository;
import com.PeerProgramming.Login.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender mailSender;



	@Override
	public String authenticateUser(UserDto userDto) {
	    String email = userDto.getEmail();
	    String password = userDto.getPassword();

	    if (!email.matches("^[A-Za-z0-9._%+-]+@zemosolabs.com$")) {
	        throw new EmailException("Email must end with zemosolabs.com");
	    }
	    if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()\\-_=+{};:,<.>]).{8,}$")) {
	        throw new EmailException("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
	    }

	    List<User> users = userRepository.findAll();
	    for (User user : users) {
			System.out.println(user.getEmail()+"   "+user.getPassword());
	        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
		        sendEmail(email,"Log in success","You have logged from spring boot");
	            return "Successful login";
	        }
	    }
	    return "No user with matching email and password";
	}

	public void sendEmail(String to,String subject,String text)
	{
		SimpleMailMessage message = new SimpleMailMessage();
						message.setFrom("harichandhana.bandaru@zemosolabs.com");
				           message.setTo(to);
				           message.setSubject(subject);
				           message.setText(text);
				        mailSender.send(message);
	}


}
