
/**
 * Created by loody 6/30/17 3:05 PM .
 */
package me.loody.extra.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * anomation for inject param
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface ExtraParam {
    //key in bundle
    String value() default "";
}
