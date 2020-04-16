public int hashCode() {
    return new Long(x).hashCode() * 3 + new Long(y).hashCode();
}