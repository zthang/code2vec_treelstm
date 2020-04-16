	void dfs(int p, int i, int d) {
		d += dd[i];
		if (d_ < d) {
			d_ = d; i_ = i;
		}
		for (int l = ae[i]; l != 0; l = ll[l]) {
			int j = jj[l];
			if (j != p)
				dfs(i, j, d);
		}
	}