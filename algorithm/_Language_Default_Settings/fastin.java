/*
* why FastReader faster than Scanner?
* Scanner always use long regex to ignore no-match string.
* for example "edf 10 abc 20" nextInt() will return 10 and ignore edf.
* FastReader just split input with spaces and separators.
*/
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
