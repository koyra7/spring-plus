package org.example.expert.config;

import lombok.Getter;
import org.example.expert.domain.user.enums.UserRole;

@Getter
public class Security {

    private Long userId;
    private String email;
    private String nickName;
    private UserRole userRole;

    public Security(Long userId, String email, String nickName, UserRole userRole) {
        this.userId = userId;
        this.email = email;
        this.nickName = nickName;
        this.userRole = userRole;
    }
}
