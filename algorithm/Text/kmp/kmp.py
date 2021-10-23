#kmp

class Kmp:

    __pattern = ""
    __next = []

    def __init__(self, pattern):
        self.__pattern = pattern
        #getNext
        next = [0]*len(pattern)
        next[0] = -1
        k = -1
        j = 0
        while j < len(pattern) - 1:
            if k == -1 or pattern[j] == pattern[k]:
                j += 1; k += 1
                if pattern[j] != pattern[k]:
                    next[j] = k
                else:
                    next[j] = next[k]
            else:
                k = next[k]
        self.__next = next

    def match(self, mainStr):
        s = mainStr
        pattern = self.__pattern
        next = self.__next
        p = pattern
        i = j = 0

        while i < len(s) and j < len(p):
            if j == -1 or s[i] == pattern[j]:
                i += 1; j += 1
            else:
                j = next[j]

        if j == len(p):
            return i - j
        else:
            return -1

searcher = Kmp('abcab')
print(searcher.match('ojpaowabaaadancabcabosjadwn'))






