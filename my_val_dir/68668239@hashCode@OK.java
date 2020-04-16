@Override
public int hashCode() {
    int result = (int) (a ^ (a >>> 32));
    result = 31 * result + (int) (b ^ (b >>> 32));
    return result;
}