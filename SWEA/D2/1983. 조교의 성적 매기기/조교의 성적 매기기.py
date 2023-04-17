T = int(input())

for test_case in range(1, T+1):
    n, k = map(int, input().split())

    arr = []
    for i in range(1, n+1):
        a, b, c = map(int, input().split())

        score = (a*0.35) + (b*0.45) + (c*0.2)
        arr.append([i, score])

    arr.sort(key=lambda x: -x[1])
    
    count = n/10
    tmp = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]
    result = 0

    for i in range(len(arr)):
        if arr[i][0] == k:
            result = i
            break

    print(f"#{test_case} {tmp[int(result//count)]}")
