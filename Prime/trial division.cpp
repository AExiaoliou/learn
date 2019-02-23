#include <cmath>

bool fool(int x) {
    bool isPrime = true;
    for (int i = 2; i < sqrt(x); i++)  {
        if (x % i == 0) {
            isPrime = false;
            break;
        }
    }
    return isPrime;
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
