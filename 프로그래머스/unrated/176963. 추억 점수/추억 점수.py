def solution(name, yearning, photo):
    answer = []
    dic = {}
    for i in range(len(name)):
        dic[name[i]] = yearning[i]

    for i in photo:
        tmp = 0
        for j in i:
            if j in dic:
                tmp += dic[j]

        answer.append(tmp)

    return answer
