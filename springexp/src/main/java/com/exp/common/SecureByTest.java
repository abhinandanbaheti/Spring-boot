package com.exp.common;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureByTest {

    String name();
    Class<? extends SecureByTestExtender> resolver();
}
