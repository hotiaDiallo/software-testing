package com.selftaugh.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }

    @Test
    void itShouldValidatePhoneNumber() {
        //Given
        String phoneNumber = "+33777777777";
        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertThat(isValid).isTrue();
    }

    @Test
    @DisplayName("Should fail when length is bigger than 12")
    void itShouldValidatePhoneNumberWhenLengthBiggerThanTwelve() {
        //Given
        String phoneNumber = "+33777777777222";
        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertThat(isValid).isFalse();
    }

    @Test
    @DisplayName("Should fail when does not start whith a +")
    void itShouldValidatePhoneNumberWhenDoesNotStartWithPlusSign() {
        //Given
        String phoneNumber = "33777777777";
        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertThat(isValid).isFalse();
    }
}
