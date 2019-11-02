package com.spigotlib.antishit.api.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ghast
 * @since 18-Oct-19
 * Ghast CC © 2019
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SubCommand {
    String name();
    String permission();
    String[] aliases();
}
