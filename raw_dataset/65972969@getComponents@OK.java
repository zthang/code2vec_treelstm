public Collection<Set<Integer>> getComponents() {
    compressAll();
    return Collections.unmodifiableCollection(Utils.invert(ArrayUtils.asList(arr)).values());
}