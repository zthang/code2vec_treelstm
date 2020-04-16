public int hashCode() {
    return (first == null ? 0 : first.hashCode() * 31) + (second == null ? 0 : second.hashCode());
}