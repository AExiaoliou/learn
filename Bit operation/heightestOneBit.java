//from java.lang.Integer.hightestOneBit()
static int highestOneBit(int i) {
    i |= (i >>  1);
    i |= (i >>  2);
    i |= (i >>  4);
    i |= (i >>  8);
    i |= (i >> 16);
    return i - (i >>> 1);
}
//from java.lang.Long.hightestOneBit()
public static long highestOneBit(long i) {
    i |= (i >>  1);
    i |= (i >>  2);
    i |= (i >>  4);
    i |= (i >>  8);
    i |= (i >> 16);
    i |= (i >> 32);
    return i - (i >>> 1);
}
