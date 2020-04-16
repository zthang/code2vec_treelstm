	public void run(FastScanner sc, FastPrinter out) throws Exception {
		int N = sc.nextInt();
		char[] init = sc.next().toCharArray();
		int[][] arr = new int[N][];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextIntArray(2);
		}
		int ans = 0;

		for (int t = 0; t < MAXN; t++) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				if (t >= arr[i][1]) {
					if ((t - arr[i][1]) % arr[i][0] == 0) {
						if (init[i] == '1') {
							init[i] = '0';
						} else {
							init[i] = '1';
						}
					}
				}
				if (init[i] == '1') {
					temp++;
				}
			}
			if (temp > ans) ans = temp;
		}
		out.println(ans);
	}