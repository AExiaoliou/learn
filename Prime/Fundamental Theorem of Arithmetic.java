static boolean isPrime(int x) {
	if (x == 2) return true;
	
	int max = (int) Math.sqrt(x);
	for (int i = 0, prime = primeTable[i]; prime < max; i++) {
		if (x % prime == 0) return false;
	}
	return true;
}
