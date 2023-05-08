package com.sang.minishops.convert;


import com.sang.minishops.dto.UserDto;
import com.sang.minishops.entity.User;
import org.springframework.stereotype.Component;

/**
 * The type User convert.
 */
@Component
public class UserConvert {
    /**
     * Convert to dto user dto.
     *
     * @param user the user
     * @return the user dto
     */
    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }
}
