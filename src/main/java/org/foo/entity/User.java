package org.foo.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.foo.enums.Gender;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private boolean enabled;
    private String phone;
    private Role role;
    private Gender gender;

    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long lastUpdateUserId, Gender gender, Role role, String phone, boolean enabled, String password, String userName, String lastName, String firstName) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, lastUpdateUserId);
        this.gender = gender;
        this.role = role;
        this.phone = phone;
        this.enabled = enabled;
        this.password = password;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
