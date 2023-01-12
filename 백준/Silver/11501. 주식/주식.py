for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    
    max_v = arr[n-1]
    target = [0] * n
    for i in range(n-1, -1, -1):
        max_v = max(max_v, arr[i])
        target[i] = max_v
        
    result = 0
    for i in range(n):
        result += max(0, target[i] - arr[i])
    print(result)