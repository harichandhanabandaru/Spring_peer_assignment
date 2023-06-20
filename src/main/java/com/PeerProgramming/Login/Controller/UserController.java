package com.PeerProgramming.Login.Controller;

import com.PeerProgramming.Login.Service.UserService;
import com.PeerProgramming.Login.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/login")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/checklogin")
	public String checkLogin(@RequestBody UserDto userDto)
	{
		return userService.authenticateUser(userDto);
	}
}
