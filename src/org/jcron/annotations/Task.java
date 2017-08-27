
package org.jcron.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author jmorla
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Task {
    String name();
    int minute() default -1;
    int hour() default -1;
    int dayOfMonth() default -1;
    int month() default -1;
    int dayOfWeek() default -1;
    int seconds() default -1;
}
