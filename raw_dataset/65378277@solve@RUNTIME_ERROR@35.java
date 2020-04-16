	void solve() {
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt(), m = scn.nextInt();
			int[][] arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				arr[i][0] = scn.nextInt();
				arr[i][1] = i + 1;
			}
			if (n == 2 || m < n) {
				out.println(-1);
				continue;
			}

			Arrays.parallelSort(arr, (o1, o2) -> o1[0] - o2[0]);
			int[][] ans = new int[m][2];
			int pos = 0;

			long cost = 0;
			int[] size = new int[n];
			size[0] = size[1] = size[2] = 2;
			cost += 2 * (arr[0][0] + arr[1][0] + arr[2][0]);
			ans[pos++] = new int[] {arr[0][1], arr[1][1]};
			ans[pos++] = new int[] {arr[1][1], arr[2][1]};
			ans[pos++] = new int[] {arr[2][1], arr[0][1]};
			for (int i = 3; i < n; i++) {
				if(size[i] >= 2) {
					continue;
				}
				for (int j = 0; j < 3; j++) {
					if (size[i] < 2 && i != j) {
						size[j]++;
						size[i]++;
						cost += arr[i][0] + arr[j][0];
						ans[pos++] = new int[] { arr[i][1], arr[j][1] };
					}
				}
			}

			while (pos < ans.length) {
				ans[pos++] = new int[] { arr[0][1], arr[1][1] };
				cost += arr[0][0] + arr[1][0];
			}
			
			out.println(cost);
			for(int[] e : ans) {
				out.println(e[0] + " " + e[1]);
			}
		}
	}