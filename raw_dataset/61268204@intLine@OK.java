public List<Integer> intLine(int size) {
    List<Integer> ls = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
        ls.add(nextInt());
    }
    return ls;
}