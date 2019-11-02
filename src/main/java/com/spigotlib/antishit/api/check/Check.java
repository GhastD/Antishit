package com.spigotlib.antishit.api.check;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ghast
 * @since 02-Nov-19
 * Ghast CC © 2019
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Check {
    String name();
    String id();
}
