private void switchToMap() {
    map = new HashMap<>(2 * useHashMapAt);
    for (int i = 0; i < inds.size(); i++) {
        map.put(inds.get(i), values.get(i));
    }
    inds = null;
    values = null;
}