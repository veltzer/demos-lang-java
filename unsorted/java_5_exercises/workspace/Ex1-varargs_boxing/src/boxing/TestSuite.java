/*
 * TestSuite.java
 *
 * Created on May 2, 2005, 5:17 AM
 */

package boxing;

import boxing.tests.ToStringPrimitive;
import boxing.tests.ToStringInteger;
import boxing.tests.AddInteger;
import boxing.tests.Empty;
import boxing.tests.EqualsInteger2;
import boxing.tests.AddPrimitive;
import boxing.tests.EqualsPrimitive;
import boxing.tests.EqualsInteger;

/**
 *
 * @author pix
 */
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
