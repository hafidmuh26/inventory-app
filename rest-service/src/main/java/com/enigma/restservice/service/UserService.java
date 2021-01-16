package com.enigma.restservice.service;

import com.enigma.restservice.entity.classentity.User;
import org.springframework.security.core.userdetails.UserDetailsService;




public interface UserService extends CommonService<User, String>, UserDetailsService {

}
