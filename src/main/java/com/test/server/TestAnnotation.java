package com.test.server;

public @interface TestAnnotation {
    public long timeout() default 1000;
}
