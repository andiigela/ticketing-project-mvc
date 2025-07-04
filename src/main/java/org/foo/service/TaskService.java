package org.foo.service;

import org.foo.dto.TaskDTO;
import org.foo.dto.UserDTO;

import java.util.List;

public interface TaskService extends CrudService<TaskDTO, Long> {

    List<TaskDTO> findTasksByManager(UserDTO manager);
}
