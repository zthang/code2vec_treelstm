	static SortedSet<Integer> buildQueue(SortedSet<Integer> q, int current){
		q.add(current);
		alreadyCovered.add(current);
		for(int each: map.get(current)) {
			if(!alreadyCovered.contains(each))
				buildQueue(q, each);
		}
		return q;
	}