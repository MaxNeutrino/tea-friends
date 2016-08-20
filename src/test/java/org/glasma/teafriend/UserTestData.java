package org.glasma.teafriend;

import org.glasma.teafriend.matcher.ModelMatcher;
import org.glasma.teafriend.model.BaseEntity;
import org.glasma.teafriend.model.Role;
import org.glasma.teafriend.model.User;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class UserTestData {

    public static final int USER_ID = BaseEntity.START_SEQ;
    public static final int ADMIN_ID = BaseEntity.START_SEQ + 1;

    public static final User USER = new User(USER_ID, "User", "user@gmail.com", "password", Role.ROLE_USER);
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);

    public static final ModelMatcher<User, TestUser> MATCHER = new ModelMatcher<>(
            u -> ((u instanceof TestUser) ? (TestUser) u : new TestUser(u)), User.class
    );

    public static class TestUser extends User {

        public TestUser(User u) {
            this(u.getId(), u.getName(), u.getEmail(), u.getPassword(), u.getRoles());
        }

        public TestUser(String name, String email, String password, Role role, Role... roles) {
            this(null, name, email, password, EnumSet.of(role, roles));
        }

        public TestUser(Integer id, String name, String email, String password, Set<Role> roles) {
            super(id, name, email, password, roles);
        }

        public User asUser() {
            return new User(this);
        }

        @Override
        public String toString() {
            return "User (" +
                    "id=" + id +
                    ", email=" + email +
                    ", name=" + name +
                    ", password=" + password +
                    ", authorities=" + roles +
                    ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            TestUser that = (TestUser) o;
            return Objects.equals(this.password, that.password)
                    && Objects.equals(this.id, that.id)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.email, that.email);
        }
    }
}
