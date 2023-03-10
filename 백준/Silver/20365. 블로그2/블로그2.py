n = int(input())
s = input()

colors = {'B': 0, 'R': 0} 
colors[s[0]] += 1 

for i in range(1, n): 
    if s[i] != s[i-1]:
        colors[s[i]] += 1

result = min(colors['B'], colors['R']) + 1


print(result)