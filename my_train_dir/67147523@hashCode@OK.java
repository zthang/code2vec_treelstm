public int hashCode() {
    return (u == null ? 0 : u.hashCode() * 31) + (v == null ? 0 : v.hashCode());
}