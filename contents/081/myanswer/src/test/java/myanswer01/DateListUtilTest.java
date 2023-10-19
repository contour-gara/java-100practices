package myanswer01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.Streams;

import static org.assertj.core.api.Assertions.*;
import static java.util.Calendar.MINUTE;
import static myanswer01.DateListUtil.shallowCopyDateList;
import static myanswer01.DateListUtil.deepCopyDateList;

class DateListUtilTest {
    @Nested
    class シャローコピー {
        private List<Date> originalDates;
        private List<Date> copyDates;

        @BeforeEach
        void SetUp() {
            // setup
            originalDates = new ArrayList<>();
            originalDates.add(new Date());
            originalDates.add(new Date());
            originalDates.add(new Date());

            // execute
            copyDates = shallowCopyDateList(originalDates);

//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(new Date());
//            calendar.add(MINUTE, 5);
//            copyDates.add(0, calendar.getTime());
//            copyDates.remove(3);
        }

        @Test
        void 要素の値が同じ() {
            // setup
            // execute
            // assert
            assertThat(copyDates).containsExactlyElementsOf(originalDates);
        }

        @Test
        void 要素の参照が同じ() {
            // setup
            // execute
            // assert
            for (int i = 0; i < originalDates.size(); ++i) {
                assertThat(copyDates.get(i)).isSameAs(originalDates.get(i));
            }
        }
    }

    @Nested
    class ディープコピー {
        private List<Date> originalDates;
        private List<Date> copyDates;

        @BeforeEach
        void SetUp() {
            // setup
            originalDates = new ArrayList<>();
            originalDates.add(new Date());
            originalDates.add(new Date());
            originalDates.add(new Date());

            // execute
            copyDates = deepCopyDateList(originalDates);

//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(new Date());
//            calendar.add(MINUTE, 5);
//            copyDates.add(0, calendar.getTime());
//            copyDates.remove(3);
        }

        @Test
        void 要素の値が同じ() {
            // setup
            // execute
            // assert
            assertThat(copyDates).containsExactlyElementsOf(originalDates);
        }

        @Test
        void 要素の参照が同じ() {
            // setup
            // execute
            // assert
            for (int i = 0; i < originalDates.size(); ++i) {
                assertThat(copyDates.get(i)).isNotSameAs(originalDates.get(i));
            }
        }
    }
}
