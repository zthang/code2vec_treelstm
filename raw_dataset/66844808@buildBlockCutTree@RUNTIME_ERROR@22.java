	public static int[][] buildBlockCutTree(BCDatum dat)
	{
		int n = dat.g.length;
		int m = dat.ecp;
		int[] artics = new int[n];
		Arrays.fill(artics, -1);
		int q = 0;
		for(int i = 0;i < n;i++){
			if(dat.isArtic[i]){
				artics[i] = q++;
			}
		}
		int[] from = new int[q+m-1];
		int[] to = new int[q+m-1];
		// m+q
		int p = 0;
		int[] temp = new int[n];
		for(int i = 0;i < n;i++){
			if(dat.isArtic[i]){
				int lp = 0;
				for(int[] e : dat.g[i]){
					temp[lp++] = dat.edgeClus[e[1]];
				}
				assert lp >= 2;
				Arrays.sort(temp, 0, lp);
				for(int j = 0;j < lp;j++){
					if(j == 0 || temp[j] != temp[j-1]){
						from[p] = m+artics[i]; to[p] = temp[j]; p++;
					}
				}
			}
		}
		assert p == from.length;
		return packU(q+m, from, to);
	}