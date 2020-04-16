public boolean cross(long ax, long ay, long bx, long by, long cx, long cy, long dx, long dy) {
    long ta = (cx - dx) * (ay - cy) + (cy - dy) * (cx - ax);
    long tb = (cx - dx) * (by - cy) + (cy - dy) * (cx - bx);
    long tc = (ax - bx) * (cy - ay) + (ay - by) * (ax - cx);
    long td = (ax - bx) * (dy - ay) + (ay - by) * (ax - dx);
    return ((tc >= 0 && td <= 0) || (tc <= 0 && td >= 0)) && ((ta >= 0 && tb <= 0) || (ta <= 0 && tb >= 0));
}