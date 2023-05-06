T = int(input())

for test_case in range(1, T+1):
    st = input()
    ans = ''
    dic = {'a': 0, 'b': 0, 'c': 0, 'd': 0, 'e': 0, 'f': 0, 'g': 0, 'h': 0, 'i': 0, 'j': 0, 'k': 0, 'l': 0, 'm': 0, 'n': 0, 'o': 0, 'p': 0, 'q': 0, 'r': 0, 's': 0, 't': 0, 'u': 0, 'v': 0, 'w': 0, 'x': 0, 'y': 0, 'z': 0}
    arr = []

    for i in st:
        dic[i] += 1

    for key, item in dic.items():
        if item % 2 == 1:
            arr.append(key)

    if len(arr) == 0:
        ans = 'Good'
    else:
        arr.sort()
        for i in arr:
            ans += i


    print(f"#{test_case} {ans}")
