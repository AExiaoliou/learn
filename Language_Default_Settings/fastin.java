class FastReader {
	private BufferedReader in;
	private StringTokenizer tokenizer;

	FastReader() {
		in = new BufferedReader(new InputStreamReader(System.in), 23333);
		tokenizer = null;
	}

	String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(in.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	int[] nextInts(int len) {
		int[] a = new int[len];
		for (int i = 0; i < a.length; i++) {
			a[i] = cd.nextInt();
		}
		return a;
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	void close() {
		try {
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
