a, b = map(int, input().split())
a_list = list(map(int, input().split()))
b_list = set(map(int, input().split()))

result = [i for i in a_list if i not in b_list]

if len(result) == 0:
    print(0)
else:
    print(len(result))
    result.sort()
    for i in result:
        print(i, end=" ")