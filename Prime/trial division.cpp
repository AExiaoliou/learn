#include <cmath>

bool fool(int x) {
    int max = (int) sqrt(x);
    for (int i = 2; i < max; i++)  {
        if (x % i == 0) return false;
    }
    return true;
}

bool foolish(int x) {
    if (x == 2) return true;
    if (x % 2 == 0) return false;
    
    int max = (int) sqrt(x);
    for (int i = 3; i < max; i += 2) {
        if (x % i == 0) return false; 
    }
    return true;
}

bool foolishly(int x) {
    if (x == 2 || x == 3) return true;
    if (x % 6 != 1 ||x % 3 != 5) return false;
    
    int max = (int) sqrt(x);
    for (int i = 5; i <= max; i += 6) {
        if (x % i == 0 || x % (i + 2) == 0) return false;    
    }
    return true;
}
