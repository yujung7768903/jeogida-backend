package com.godofparking.jeogidabackend.config.auth;

import com.godofparking.jeogidabackend.config.auth.dto.OAuthAttributes;
import com.godofparking.jeogidabackend.config.auth.dto.SessionUser;
import com.godofparking.jeogidabackend.dto.Role;
import com.godofparking.jeogidabackend.dto.UserDto;
import com.godofparking.jeogidabackend.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserMapper userMapper;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // OAuth2 서비스 id (구글, 카카오, 네이버)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("registration Id: " + registrationId);
        // OAuth2 로그인 진행 시 키가 되는 필드 값(PK)
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        System.out.println("userNameAttr: " + userNameAttributeName);

        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());
        UserDto userDto = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(userDto));



        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(userDto.getRoleKey())), attributes.getAttributes(), attributes.getNameAttributeKey());
    }

    private UserDto saveOrUpdate(OAuthAttributes attributes) {
        UserDto userDto;
        userDto = userMapper.findByEmail(attributes.getEmail());

        if(userDto!=null){
            userDto.update(attributes.getEmail(), attributes.getName(), Role.USER, attributes.getPicture());
            userMapper.updateUser(userDto);
        }
        else {
            userDto = attributes.toUserDto();
            userMapper.insertUser(userDto);
        }

        return userMapper.findByEmail(attributes.getEmail());
    }
}
