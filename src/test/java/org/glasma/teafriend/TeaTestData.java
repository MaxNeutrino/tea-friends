package org.glasma.teafriend;

import org.glasma.teafriend.matcher.ModelMatcher;
import org.glasma.teafriend.model.BaseEntity;
import org.glasma.teafriend.model.Tea;

import java.util.Objects;

public class TeaTestData {

    public static final String CATEGORY_WHITE = "white";
    public static final String CATEGORY_YELLOW = "yellow";
    public static final String CATEGORY_GREEN = "green";
    public static final String CATEGORY_OOLONG = "oolong";
    public static final String CATEGORY_RED = "red";
    public static final String CATEGORY_BLACK = "black";
    public static final String CATEGORY_SHOU_PUER = "shou puer";
    public static final String CATEGORY_SHENG_PUER = "sheng puer";

    public static final String COUNTRY_CHINA = "china";
    public static final String COUNTRY_TAIWAN = "taiwan";
    public static final String COUNTRY_INDIA = "india";
    public static final String COUNTRY_CEYLON = "ceylon";
    public static final String COUNTRY_TURKEY = "turkey";
    public static final String COUNTRY_GEORGIA = "georgia";

    public static final int WHITE_TEA_ID = BaseEntity.START_SEQ + 2;

    public static final int ULUN_TEA_ID = BaseEntity.START_SEQ + 3;

    public static final int BLACK_TEA_ID = BaseEntity.START_SEQ + 4;

    public static final Tea WHITE = new Tea(WHITE_TEA_ID,
            "Баймаохоу", CATEGORY_WHITE, COUNTRY_CHINA, "Очень вкусный", 0, 0);
    public static final Tea ULUN = new Tea(ULUN_TEA_ID,
            "Молочный улун", CATEGORY_OOLONG, COUNTRY_CHINA, "Очень вкусный", 0, 2);
    public static final Tea BLACK = new Tea(BLACK_TEA_ID,
            "Ассам Мангалам", CATEGORY_BLACK, COUNTRY_INDIA, "Очень вкусный", 0, 0);

    public final static ModelMatcher<Tea, TestTea> MATCHER = new ModelMatcher<>(
            t -> ((t instanceof TestTea) ? (TestTea) t : new TestTea(t)), Tea.class
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
