package org.foo.converter;

import org.foo.dto.UserDTO;
import org.foo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDtoConverter implements Converter<String, UserDTO> {

    UserService userService;
    @Autowired
    public UserDtoConverter(UserService userService){
        this.userService=userService;
    }
    @Override
    public UserDTO convert(String userName) {
        return this.userService.findById(userName);
    }
}
