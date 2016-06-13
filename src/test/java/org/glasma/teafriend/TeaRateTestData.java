package org.glasma.teafriend;

import org.glasma.teafriend.matcher.ModelMatcher;
import org.glasma.teafriend.model.BaseEntity;
import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.model.TeaRate;
import org.glasma.teafriend.model.User;

import java.util.Objects;

public class TeaRateTestData {

    public static final int USER_TEA_RATE_ID = BaseEntity.START_SEQ + 7;
    public static final int ADMIN_TEA_RATE_ID = BaseEntity.START_SEQ + 8;

    public static final TeaRate USER_TEA_RATE = new TeaRate(USER_TEA_RATE_ID, 5, UserTestData.USER, TeaTestData.ULUN);
    public static final TeaRate ADMIN_TEA_RATE = new TeaRate(ADMIN_TEA_RATE_ID, 5, UserTestData.ADMIN, TeaTestData.ULUN);

    public static final ModelMatcher<TeaRate, TestTeaRate> MATCHER = new ModelMatcher<>(
            tr -> ((tr instanceof TestTeaRate) ? (TestTeaRate) tr : new TestTeaRate(tr))
    );

    public static class TestTeaRate extends TeaRate{

        public TestTeaRate(int rate) {
            this(null, rate);
        }

        public TestTeaRate(Integer id, int rate) {
            super(id, rate);
        }

        public TestTeaRate(TeaRate tr) {
            this(tr.getId(), tr.getRate(), tr.getUser(), tr.getTea());
        }

        public TestTeaRate(int rate, User user, Tea tea) {
            this(null, rate, user, tea);
        }

        public TestTeaRate(Integer id, int rate, User user, Tea tea) {
            super(id, rate, user, tea);
        }

        public TeaRate asTeaRate() {
            return new TeaRate(this);
        }

        @Override
        public String toString() {
            return "TeaRate{" +
                    "rate=" + rate +
                    ", user=" + user +
                    ", tea=" + tea +
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

            TestTeaRate that = (TestTeaRate) o;
            return Objects.equals(this.id, that.id)
                    && Objects.equals(this.rate, that.rate)
                    && Objects.equals(this.user, that.user)
                    && Objects.equals(this.tea, that.tea);
        }
    }
}
