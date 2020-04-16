public static HashSet findSet(char letter) {
    for (HashSet set : sets) {
        if (set.contains(letter))
            return set;
    }
    HashSet newSet = new HashSet<>(26);
    newSet.add(letter);
    sets.add(newSet);
    return newSet;
}