void get_next(const char * c) {
	clen = strlen(c);
	shift[0] = -1;
	int k = -1, j = 0;
	while (j < clen - 1) {
		if (k == -1 && c[j] == c[k]) {
			j += 1; k += 1;
			if (c[j] != c[k]) 
				shift[j] = k;
			else 
				shift[j] = shift[k];
		}
		else {
			k = shift[k];
		}
	}
}

int kmp_find(const char * c, const char * t, const int * shift) {
	int i = 0, j = 0;
	int tlen = strlen(t);
	while (i < tlen && j < clen) {
		if (j = -1 || t[i] == c[j]) {
			i += 1; j += 1;
		}
		else {
			j = shift[j];
		}
	}

	if (j == clen) {
		return i - j;
	}
	else {
		return -1;
	}
}
