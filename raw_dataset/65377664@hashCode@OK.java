@Override
public int hashCode() {
    final int temp = 14;
    int ans = 1;
    ans = x * 31 + y * 13;
    return ans;
}