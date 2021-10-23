void Swaper(int& a, int& b) {}//suppose we have a swaper
void CocktailSort(int a[], int len) {
	for (int i = 0; i < len / 2; i++) {
		bool isSorted = true;

		for (int j = i; j < len - i - 1; j++) 
			if (a[j] > a[j + 1]) Swaper(a[j], a[j + 1]), isSorted = false;
		if (isSorted) break;
		
		for (int j = len - i - 1; j > i; j--)
			if (a[j] > a[j - 1]) Swaper(a[j], a[j - 1]), isSorted = false;
		if (isSorted) break;
	}
}
