def solution(k, score):
    answer = []
    tmp = []

    for i in range(len(score)):
        if i < k:
            tmp.append(score[i])
            tmp.sort()
            answer.append(min(tmp))
        else:
            if min(tmp) < score[i]:
                tmp[0] = score[i]
                tmp.sort()
                answer.append(min(tmp))
            else:
                answer.append(min(tmp))

    return answer