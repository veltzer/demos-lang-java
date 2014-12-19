package ej;

import java.lang.annotation.*;

/**
 * Indicates the default implementation for a service.
 * @date: Sep 20, 2008 1:50:17 PM
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultTo {
  Class<?> value();
}
