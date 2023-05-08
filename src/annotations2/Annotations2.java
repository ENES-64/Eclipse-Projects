package annotations2;

import java.lang.annotation.*;
//Retention retains the annotation. There are 3 policies, class, run-time, or source.
@Retention(RetentionPolicy.CLASS)
//Documented means the annotation is documented in JavaDoc.
@Documented
//Target annotation makes user-defined annotation to target a specific element only.
@Target(value=ElementType.FIELD)
//Interface with a @ at the start means it's a user-defined annotation.
@interface MyAnno {
    String name();
    String project();
    String date() default "Today";
    String version() default "19";
}

public class Annotations2 {
	//Since target is field, user-defined annotation only works here.
	@MyAnno(name="Enes", project = "Annotations2")
    int data;
    
    //@MyAnno(name="Enes", project = "Annotations2")
    public static void main(/*@MyAnno(name="Enes", project = "Annotations2")*/ String[] args) {
    	//@MyAnno(name="Enes", project = "Annotations2")
        int x;
    }
}