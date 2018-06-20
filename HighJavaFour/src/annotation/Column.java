package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

	public boolean isId() default false;
	public String name() default "";
	public String caption() default "";
	public boolean nullable() default true;
	public int length() default 20;
	
}