package com.PeerProgramming.Login.Service;

import com.PeerProgramming.Login.dto.UserDto;

public interface UserService {

	public String authenticateUser(UserDto userDto);
}
