n, m = map(int, input().split())

team_mem, mem_team = {}, {}

for i in range(n):
    team_name = input()
    num = int(input())
    team_mem[team_name] = []
    for j in range(num):
        name = input()
        team_mem[team_name].append(name)
        mem_team[name] = team_name

for i in range(m):
    name, q = input(), int(input())
    if q:
        print(mem_team[name])
    else :
        for mem in sorted(team_mem[name]):
            print(mem)