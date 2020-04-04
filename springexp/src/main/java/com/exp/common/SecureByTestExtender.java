package com.exp.common;

public interface SecureByTestExtender {

    default boolean supports(final Class<? extends SecureByTestExtender> aClass) {
        return this.getClass()
                .equals(aClass);
    }

    default String resolveResource(String resource){
        throw new RuntimeException("Implementing class should implement resolveResource");
    }
}
