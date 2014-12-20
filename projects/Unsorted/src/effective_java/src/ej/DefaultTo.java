package effective_java.src.ej;

import java.lang.annotation.*;

/**
 * Indicates the default implementation for a service.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefaultTo {
	Class<?> value();
}
