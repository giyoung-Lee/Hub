def solution(scores):
    answer = 1
    wan = scores[0]
    scores.sort(key=lambda x : (-x[0], x[1]))
    maxB = 0
    

    for a, b in scores:
        if wan[0] < a and wan[1] < b:
            return -1

        if b >= maxB:
            maxB = b
            if a + b > sum(wan):
                answer += 1
    return answer