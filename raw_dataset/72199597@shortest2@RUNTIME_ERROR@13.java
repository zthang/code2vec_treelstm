	private int shortest2(int start, int end, HashMap<Integer, HashSet<Integer>> edges, int[] path, int pathIndex) {
		ArrayList<Integer> starts = new ArrayList<Integer>();
		HashSet<Integer> done = new HashSet<Integer>();
		starts.add(start);
		done.add(start);
		int length = 1;
		while(!starts.isEmpty()) {
			ArrayList<Integer> ends = new ArrayList<Integer>();
			for (int s: starts) {
				HashSet<Integer> paths = edges.get(s);
				for (int e: paths) {
					if (!done.contains(e)) {
						if (e == path[pathIndex+length]) {
							return length;
						}
						if (e == end) {
							return length;
						}
						ends.add(e);
					}
				}
			}
			starts = ends;
			length++;
		}
		return -1;
	}