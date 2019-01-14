# Sunday

class Sunday:

    __pattern = ''
    __length = 0 
    __shift = {}

    def __init__(self, pattern):
        self.__pattern = pattern
        self.__length = len(pattern)
        for i in range(self.__length):
            self.__shift[pattern[i]] = self.__length - i
    
    def search(self, mainStr):
        s = mainStr
        length = self.__length
        pattern = self.__pattern
        shift = self.__shift
        i = j = 0
        while j < len(s): 
            if s[j] != pattern[i]:
                j = j - i; i = 0
                if s[j + length] in shift:
                    j += shift[s[j + length]]
                else:
                    j += length + 1
            else:
                i += 1
                j += 1
                if i == length:
                    return j - i
        return None

searcher = Sunday('abc')
print(searcher.search('bcabc'))
