def solution(n, m, section):
    paint = section[0]-1
    answer = 0
    
    for v in section:
        if paint < v:
            paint = v+m-1
            answer += 1

    return answer