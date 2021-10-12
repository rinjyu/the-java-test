package com.study.thejavatest;

import com.study.thejavatest.domain.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatTest {

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalREpetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/"
                + repetitionInfo.getTotalRepetitions());
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    void parameterizedTest(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} limit={0}")
    @ValueSource(ints = {10, 20, 40})
    void valueSource(Integer limit) {
        System.out.println(limit);
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @EmptySource
    void emptySource(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @NullSource
    void nullSource(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @NullAndEmptySource
    void nullAndEmptySource(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @CsvSource({"a,b,c,d,e,f,g"})
    void csvSource(String message) {
        System.out.println(message);
    }

    @ParameterizedTest(name = "{index} {displayName} limit={0}")
    @ValueSource(ints = {10, 20, 40})
    void converterWith(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println(study.getLimitCount());
    }

    static class StudyConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study.");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    @ParameterizedTest(name = "{index} {displayName} limit={0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void csvSource(Integer limit, String name) {
        Study study = new Study(limit, name);
        System.out.println(study);
    }

    @ParameterizedTest(name = "{index} {displayName} limit={0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void argumentsAccessor(ArgumentsAccessor argumentsAccessor) {
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println(study);
    }

    @ParameterizedTest(name = "{index} {displayName} limit={0}")
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void argumentsAccessor(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
            return null;
        }
    }
}
