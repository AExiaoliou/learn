static int[] foolEratosthenes(int[] a) {
	boolean[] flags = new boolean[a.length]; Arrays.fill(flags, false);
	ArrayList<Integer> primes = new ArrayList<>((int) Math.sqrt(a.length));
	for (int i = 0; i < a.length; i++) {
		if (!flags[i]) if(isPrime(a[i])) {
			primes.add(a[i]);
			for (int j = i + a[i]; j < a.length; j += a[i])
				flags[j] = true;
		}
	}
	return primes.stream().mapToInt(Integer::intValue).toArray();
}
