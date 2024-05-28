A, B = map(int, input().split())

if A == B:
    print(0)
    pass
else:
    temp = max((B-A-1), (A-B-1))
    start = min(B, A)
    end = max(A, B)

    print(temp)

    for i in range(1, temp+1):
        print(start+i, end=" ")