def solution(t, p):
    answer = 0
    while len(t) >= len(p):
        if int(t[:len(p)]) <= int(p):
            answer += 1
            t = t[1:]
        else:
            t = t[1:]
    
    return answer