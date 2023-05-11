from itertools import combinations
T = int(input())

for test_case in range(1, T+1):
    st = input()
    dic = {'SUN': 7, 'MON': 6, 'TUE': 5, 'WED': 4, 'THU': 3, 'FRI': 2, 'SAT': 1}
    
    print(f'#{test_case} {dic[st]}')
