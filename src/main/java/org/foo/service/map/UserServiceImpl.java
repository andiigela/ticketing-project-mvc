package org.foo.service.map;

import org.foo.dto.UserDTO;
import org.foo.service.UserService;

import java.util.List;

public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }
}
