static int[] easyEratosthenes(int[] a) {
	boolean[] flags = new boolean[a.length]; Arrays.fill(flags, false);
	ArrayList<Integer> primes = new ArrayList<>((int) Math.sqrt(a.length));
	for (int i = 2, pi = 0; i < a.length; i++) {
		if (!flags[i]) {
			a[pi] = i;
			primes.add(a[pi]);
			pi += 1;
			for (int j = i; j < a.length; j++)
				flags[j] = true;
		}
	}
	return primes.stream().mapToInt(Integer::intValue).toArray();
}
