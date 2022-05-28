package com.selftaugh.testing.utils;

import java.util.function.Predicate;

public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {
        // TODO use library to validate phone number
        return phoneNumber.startsWith("+33") && phoneNumber.length()==12;
    }
}
