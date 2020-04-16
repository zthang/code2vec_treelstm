public int hashCode() {
    return new Double(x).hashCode() * 31 + new Long(y).hashCode();
}