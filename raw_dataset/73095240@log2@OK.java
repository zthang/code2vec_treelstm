// Return floor log2n
public static // returns 0 for bits=0
long log2(// returns 0 for bits=0
long bits) {
    int log = 0;
    if ((bits & 0xffff0000) != 0) {
        bits >>>= 16;
        log = 16;
    }
    if (bits >= 256) {
        bits >>>= 8;
        log += 8;
    }
    if (bits >= 16) {
        bits >>>= 4;
        log += 4;
    }
    if (bits >= 4) {
        bits >>>= 2;
        log += 2;
    }
    return log + (bits >>> 1);
}