	static int[] easyEratosthenes(int[] a) {
		boolean[] flags = new boolean[a.length]; Arrays.fill(flags, false);
		ArrayList<Integer> primes = new ArrayList<>((int) Math.sqrt(a.length));
		for (int i = 0; i < a.length; i++) {
			if (!flags[i]) if (isPrime(a[i])) {
				primes.add(a[i]);
				for (int j = 0; (j < i) && (a[i] * primes.get(j) < a.length); j++) {
					flags[a[i] * primes.get(j)] = true;
					if (a[i] % primes.get(j) == 0) break;
				}
			}
		}
		return primes.stream().mapToInt(Integer::intValue).toArray();
	}
