package org.glasma.teafriend;

import org.glasma.teafriend.matcher.ModelMatcher;
import org.glasma.teafriend.model.BaseEntity;
import org.glasma.teafriend.model.UserComment;

import java.util.Objects;

public class UserCommentTestData {

    public static final int COMMENT_ID = BaseEntity.START_SEQ + 5;
    public static final int COMMENT_ID2 = BaseEntity.START_SEQ + 6;

    public static final UserComment COMMENT = new UserComment(
            COMMENT_ID, "Это жемчужина чаев", UserTestData.USER, TeaTestData.ULUN
    );

    public static final UserComment COMMENT2 = new UserComment(
            COMMENT_ID2,"Самый лучший чай", UserTestData.USER, TeaTestData.WHITE
    );

    public static final ModelMatcher<UserComment, TestUserComment> MATCHER = new ModelMatcher<>(
            c -> ((c instanceof TestUserComment) ? (TestUserComment) c : new TestUserComment(c)), UserComment.class
    );

    public static class TestUserComment extends UserComment {

        public TestUserComment(UserComment comment) {
            this(comment.getId(), comment.getMessage());
        }

        public TestUserComment(String message) {
            this(null, message);
        }

        public TestUserComment(Integer id, String message) {
            super(id, message);
        }

        public UserComment asUserComment() {
            return new UserComment(this);
        }

        @Override
        public String toString() {
            return "UserComment{" +
                    " id=" + id +
                    ", created=" + created +
                    ", message=" + message +
                    ", user_id=" + user +
                    ", tea_id=" + tea +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            UserCommentTestData.TestUserComment that = (UserCommentTestData.TestUserComment) o;
            return Objects.equals(this.message, that.message)
                    && Objects.equals(this.id, that.id)
                    && Objects.equals(this.user, that.user)
                    && Objects.equals(this.tea, that.tea);
        }
    }
}
