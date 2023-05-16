T = int(input())

for test_case in range(1, T+1):
    arr = list(map(str, input()))
    answer = 'No'
    dic = {}

    arr.sort()
    arr_set = set(arr)

    if len(arr_set) == 2:
        if arr[1] != arr[2]:
            answer = 'Yes'

    print(f"#{test_case} {answer}")
