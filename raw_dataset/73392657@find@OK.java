public Long find(Long u) {
    if (parents.getOrDefault(u, u).equals(u)) {
        return u;
    }
    return find(parents.get(u));
}