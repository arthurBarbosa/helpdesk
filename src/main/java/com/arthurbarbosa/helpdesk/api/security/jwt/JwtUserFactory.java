package com.arthurbarbosa.helpdesk.api.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.arthurbarbosa.helpdesk.api.entity.User;
import com.arthurbarbosa.helpdesk.api.enums.ProfileEnum;



public class JwtUserFactory {

	private JwtUserFactory() {
	}

	/**
	 * converte o o JwtUser com base nos dados do usuario.
	 * 
	 * @param user
	 * @return
	 */
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(),
				mapToGrantedAuthorities(user.getProfile()));
	}

	/**
	 * converte o perfil do usuario pro formato utilizado pelo spring security.
	 * 
	 * @param profileEnum
	 * @return
	 */
	private static List<GrantedAuthority> mapToGrantedAuthorities(ProfileEnum profileEnum) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
