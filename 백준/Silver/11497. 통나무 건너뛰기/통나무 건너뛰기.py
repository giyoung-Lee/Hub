import sys
input = sys.stdin.readline

for test_case in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort(reverse=True)

    max_dif = arr[-1] - arr[-2]
    for i in range(n-2):
        dif = abs(arr[i] - arr[i + 2])
        max_dif = max(max_dif, dif)

    print(max_dif)

## ex) 길이가 7인 배열을 정렬한다면
## arr[5] arr[3] arr[1] arr[0] arr[2] arr[4] arr[6] 순으로 두고,
## 각각 abs(arr[0] - arr[2]), abs(arr[1] - arr[3]), ..... 이런식으로 2칸씩 띄워서
## 계산한것중 최댓값을 비교하면 됨. 초기 max_dif는 비교하지 못한 중앙값(arr[0])과 arr[1] 값의 차이를 계산