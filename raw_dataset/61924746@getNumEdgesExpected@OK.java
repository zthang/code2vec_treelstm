private static long getNumEdgesExpected(List<Set<Integer>> partition) {
    long group1Size = partition.get(0).size();
    long group2Size = partition.get(1).size();
    long group3Size = partition.get(2).size();
    return (group1Size * group2Size) + (group2Size * group3Size) + (group3Size * group1Size);
}