import math
T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    arr = []

    for i in range(1, int(math.sqrt(n))+1):
        # 곱해서 n이 되는 두 수 찾기
        if n % i == 0:
            arr.append((i, n//i))

    for i, (x, y) in enumerate(arr):
        arr[i] = (x-1)+(y-1)

    print(f"#{test_case} {min(arr)}")