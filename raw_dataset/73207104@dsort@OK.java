static void dsort() {
    Arrays.parallelSort(co, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
}