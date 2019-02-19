static int[] easyEratosthenes(int[] a) {
	boolean[] flags = new boolean[a.length]; Arrays.fill(flags, false);
	ArrayList<Integer> primes = new ArrayList<>((int) Math.sqrt(a.length));
	for (int i = 0; i < a.length;) {
		if (!flags[i]) if(isPrime(a[i])) {
			primes.add(a[i]);
			for (int j = i + a[i]; j < a.length; j += i)
				flags[j] = true;
			i += 1;
		}
	}
	return primes.stream().mapToInt(Integer::intValue).toArray();
}
