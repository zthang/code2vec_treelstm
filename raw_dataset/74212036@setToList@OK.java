private static List<Integer> setToList(Set<Integer> s) {
    List<Integer> al = s.stream().collect(Collectors.toList());
    return al;
}