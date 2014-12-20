package java_five_exercises.varargs_boxing;

import java_five_exercises.varargs_boxing.tests.AddInteger;
import java_five_exercises.varargs_boxing.tests.AddPrimitive;
import java_five_exercises.varargs_boxing.tests.Empty;
import java_five_exercises.varargs_boxing.tests.EqualsInteger;
import java_five_exercises.varargs_boxing.tests.EqualsInteger2;
import java_five_exercises.varargs_boxing.tests.EqualsPrimitive;
import java_five_exercises.varargs_boxing.tests.ToStringInteger;
import java_five_exercises.varargs_boxing.tests.ToStringPrimitive;

public class TestSuite {

    public void execute(Test... tests) {
        for (int i = 0; i < tests.length; i++) {
			tests[i].run();
		}
    }

    public static void main(String... argv) {
        TestSuite suite = new TestSuite();
        suite.execute(
                new Empty(),
                new AddInteger(),
                new AddPrimitive(),
                new EqualsInteger(),
                new EqualsInteger2(),
                new EqualsPrimitive(),
                new ToStringInteger(),
                new ToStringPrimitive()
                );

    }
}
