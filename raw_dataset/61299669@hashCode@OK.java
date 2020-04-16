@Override
public int hashCode() {
    if (a < b) {
        int c = a;
        a = b;
        b = c;
    }
    return Objects.hash(a, b);
}