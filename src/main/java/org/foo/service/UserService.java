package org.foo.service;

import org.foo.dto.UserDTO;
import org.foo.entity.User;

import java.util.List;

public interface UserService extends CrudService<UserDTO, String> {
    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();
}
