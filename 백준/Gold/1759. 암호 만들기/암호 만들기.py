from itertools import combinations

vowels = ('a', 'e', 'i', 'o', 'u')
l, c = map(int, input().split(' '))

array = input().split(' ')
array.sort()

for pw in combinations(array, l):

    # count = 모음의 개수
    count = 0
    for i in pw:
        if i in vowels:
            count += 1

    if count >= 1 and count<= l -2:
        print(''.join(pw))