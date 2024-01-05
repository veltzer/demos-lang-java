package core.random;

import java.util.Random;

/*
 * This example shows the default java.util.Random class
 * and it's workings.
 * It is based on a 48 bit internals state as per Donald Knuth's TAOCP.
 */
public abstract class Randomdemo {

	public static void main(String[] args) {
		Random r = new Random();
		r.setSeed(1);
		for (int i = 0; i < 10; i++) {
			System.out.println("value is " + r.nextInt());
		}
	}

}
