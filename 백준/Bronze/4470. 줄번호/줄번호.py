n = int(input())

arr = []

for i in range(n):
    arr.append(input())

for index, i in enumerate(arr):
    print(f"{index+1}. {i}")