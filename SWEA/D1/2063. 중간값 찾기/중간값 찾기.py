T = int(input())

arr = list(map(int, input().split()))
arr.sort()

length = int((len(arr)+1)/2)

answer = arr[length-1]
print(answer)