package com.godofparking.jeogidabackend.config.auth.dto;

import com.godofparking.jeogidabackend.dto.Role;
import com.godofparking.jeogidabackend.dto.UserDto;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        System.out.println("ofGoogle 메소드 실행");
        System.out.println("email: " + attributes.get("email"));
        System.out.println("role: " + Role.USER);
        System.out.println("==================================");
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public UserDto toUserDto() {
        return UserDto.builder()
                .email(email)
                .nickname(name)
                .role(Role.USER)
                .build();
    }
}
