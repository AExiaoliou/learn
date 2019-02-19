import org.junit.jupiter.api.Test;
import org.apache.commons.math3.*;

import java.util.Arrays;

import static java.lang.Math.*;

class TaskTest {
	@Test
	void test() {
		int[] testdata = new int[1 << 10];
		for (int i = 0; i < testdata.length; i++) testdata[i] = i;
		Arrays.stream(YourPackage.foolEratosthenes(testdata))
				.forEach(System.out::println);
	}
}
