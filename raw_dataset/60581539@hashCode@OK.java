public int hashCode() {
    int result = Integer.hashCode(x);
    result = 31 * result + Integer.hashCode(y);
    result = 31 * result + Integer.hashCode(z);
    return result;
}