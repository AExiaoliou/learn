# Sunday

class Sunday:

    __pattern = ''
    __length = 0 
    __shift = {}

    def __init__(self, pattern):
        self.__pattern = pattern
        self.__length = len(pattern)
        for i in range(self.__length): # get shift table
            self.__shift[pattern[i]] = self.__length - i
    
    def search(self, mainStr):
        s = mainStr
        # __ is shit
        length = self.__length
        pattern = self.__pattern
        shift = self.__shift
        i = j = 0
        while j < len(s):
            if s[j] != pattern[i]:
                j = j - i; i = 0 # let sentinel revent to the head of str and pattern
                if j + length >= len(s): break
                if s[j + length] in shift:
                    j += shift[s[j + length]]
                else:
                    j += length + 1
            else:
                i += 1
                j += 1
                if i == length:
                    return j - i 
                '''
                if you need a multiply matcher
                just change return to an array
                but it could match repeatly ,like pattern='aba' str='ababa'
                if nesserary, array's value also is j - i, but let j + 1 and i revent to head
                '''
        return -1

searcher = Sunday('abc')
print(searcher.search('bcabd'))
