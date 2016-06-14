package org.glasma.teafriend;

import org.glasma.teafriend.matcher.ModelMatcher;
import org.glasma.teafriend.model.BaseEntity;
import org.glasma.teafriend.model.Tea;

import java.util.Objects;

public class TeaTestData {

    public final static String CATEGORY_WHITE = "Белый";
    public final static String COUNTRY_INDIA = "Индия";
    public final static String COUNTRY_CHINA = "Китай";
    public final static String CHOICE_ALL = "Все";

    public static final int WHITE_TEA_ID = BaseEntity.START_SEQ + 2;

    public static final int ULUN_TEA_ID = BaseEntity.START_SEQ + 3;

    public static final int BLACK_TEA_ID = BaseEntity.START_SEQ + 4;

    public static final Tea WHITE = new Tea(WHITE_TEA_ID,
            "Баймаохоу", "Белый", "Китай", "Очень вкусный", 0, 0);
    public static final Tea ULUN = new Tea(ULUN_TEA_ID,
            "Молочный улун", "Светлый улун", "Китай", "Очень вкусный", 0, 2);
    public static final Tea BLACK = new Tea(BLACK_TEA_ID,
            "Ассам Мангалам", "Черный", "Индия", "Очень вкусный", 0, 0);

    public final static ModelMatcher<Tea, TestTea> MATCHER = new ModelMatcher<>(
            t -> ((t instanceof TestTea) ? (TestTea) t : new TestTea(t))
    );

    public static class TestTea extends Tea {

        public TestTea(Tea t) {
            this(t.getId(), t.getName(), t.getCategory(),
                    t.getCountry(), t.getDescription(), t.getRate(), t.getCountConnoisseurs());
        }

        public TestTea(String name, String category, String country, String description) {
            this(null, name, category, country, description, 0, 0);
        }

        public TestTea(Integer id, String name, String category,
                       String country, String description, double rate, int countConnoisseurs){
            super(id, name, category, country, description, rate, countConnoisseurs);
        }

        public Tea asTea() {
            return new Tea(this);
        }

        @Override
        public String toString() {
            return "Tea{" +
                    "id=" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", category='" + category + '\'' +
                    ", country='" + country + '\'' +
                    ", description='" + description + '\'' +
                    ", rate=" + rate + '\'' +
                    ", countConnoisseurs=" + countConnoisseurs + '\'' +
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

            TestTea that = (TestTea) o;
            return Objects.equals(this.id, that.id)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.category, that.category)
                    && Objects.equals(this.country, that.country);
        }
    }
}
