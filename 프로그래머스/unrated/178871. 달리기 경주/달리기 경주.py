def solution(players, callings):
    player_dict = {p: i for i, p in enumerate(players)}

    for i in range(len(callings)):
        idx = player_dict[callings[i]]
        if idx != 0:
            players[idx], players[idx-1] = players[idx-1], players[idx]
            player_dict[players[idx]] = idx
            player_dict[players[idx-1]] = idx - 1

    return players