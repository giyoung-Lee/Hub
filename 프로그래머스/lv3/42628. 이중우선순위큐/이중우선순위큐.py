def solution(operations):
    answer = []
    que = []
    for i in operations:
        if i[0] == "I":
            que.append(int(i[2:]))
        elif i[2] == "-":
            if len(que) <= 1:
                que.clear()
            else:
                min_v = min(que)
                que.remove(min_v)
        else:
            if len(que) <= 1:
                que.clear()
            else:
                max_v = max(que)
                que.remove(max_v)
    if len(que) >= 1:
        answer.append(max(que))
        answer.append(min(que))
    else:
        answer.append(0)
        answer.append(0)
        
    return answer