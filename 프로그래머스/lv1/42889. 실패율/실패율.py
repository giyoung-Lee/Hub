def solution(N, stages):
    tmp = []
    result = []
    for i in range(1, N+1):
        top = stages.count(i)
        bottom = 0
        for j in range(len(stages)):
            if stages[j] >= i:
                bottom += 1

                
        if bottom != 0:
            tmp.append((i, top/bottom))
        else:
            tmp.append((i, 0))
    
    tmp.sort(key=lambda x:x[1], reverse=True)
    
    for i, j in tmp:
        result.append(i)
    
    return result