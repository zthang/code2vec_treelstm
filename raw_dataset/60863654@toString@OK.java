// private long h(long x)
// {
// x ^= x>>>33;
// x *= 0xff51afd7ed558ccdL;
// x ^= x>>>33;
// x *= 0xc4ceb9fe1a85ec53L;
// x ^= x>>>33;
// return x;
// }
@Override
public String toString() {
    itrreset();
    int[] vals = new int[size];
    int p = 0;
    while (true) {
        int y = next();
        if (end())
            break;
        vals[p++] = y;
    }
    return Arrays.toString(vals);
}