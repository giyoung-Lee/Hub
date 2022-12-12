def solution(s):
    answer = []
    _list = []
    flag = True

    for i in range(len(s)):
        if s[i] not in _list:
            answer.append(-1)
            _list.append(s[i])
        else:
            for j in reversed(range(len(_list))):
                if _list[j] == s[i] and flag is True:
                    answer.append(i - j)
                    _list.append(s[i])
                    flag = False
        flag = True

    return answer