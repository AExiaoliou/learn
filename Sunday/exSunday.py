# exSunday

class Sunday:

    __pattern = ''
    __length = 0 
    __shift = {}

    def __init__(self, pattern):
        self.__pattern = pattern
        self.__length = len(pattern)
        for i in range(self.__length):
            self.__shift[pattern[i]] = self.__length - i
    '''
    we also can use Sunday algorithm to solve the max prefix problem
    '''
    def search(self, mainStr):
        s = mainStr
        length = self.__length
        pattern = self.__pattern
        shift = self.__shift
        i = j = 0
        prefix = -1
        while j < len(s): 
            if s[j] != pattern[i]:
                prefix = max(prefix, i)
                j = j - i; i = 0 # let sentinel revent to the head of str and pattern
                if j + length >= len(s): 
                    j += 1; break
                if s[j + length] in shift:
                    j += shift[s[j + length]]
                else:
                    j += length + 1
            else:
                i += 1
                j += 1
                if i == length: # the length of pattern is the best
                    return length
        # when progarm run to here, must be mismatched.
        while j < len(s) + length and prefix < len(s) - j: # now, we had to match them one by one
            while i < len(s) - j:
                if s[i] != s[j + i]: break  
                i += 1
            prefix = max(prefix, i + 1); j += 1
        return prefix

searcher = Sunday('sandoinad')
#                                    1    1
print(searcher.search('ahsodoiidajdowsandosandoiajja'))
