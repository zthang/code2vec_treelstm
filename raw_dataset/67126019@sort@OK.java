private void sort(long[] arr) {
    List<Long> list = new ArrayList<>();
    for (long object : arr) list.add(object);
    Collections.sort(list);
    for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
}