	private int find(int p) {
		if(id[p]!=p) {
			id[p]=find(p);
		}
		return id[p];
	}