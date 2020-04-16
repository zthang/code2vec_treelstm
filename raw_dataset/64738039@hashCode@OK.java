@Override
public int hashCode() {
    int result = a;
    result = 31 * result + (int) (b ^ (b >>> 32));
    return result;
}