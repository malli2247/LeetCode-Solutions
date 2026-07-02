from collections import deque

class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        n, m = len(grid), len(grid[0])

        INF = float("inf")
        dist = [[INF] * m for _ in range(n)]
        dist[0][0] = grid[0][0]

        dq = deque([(0, 0)])

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        while dq:
            x, y = dq.popleft()

            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < n and 0 <= ny < m:
                    w = grid[nx][ny]

                    if dist[x][y] + w < dist[nx][ny]:
                        dist[nx][ny] = dist[x][y] + w

                        if w == 0:
                            dq.appendleft((nx, ny))
                        else:
                            dq.append((nx, ny))

        return dist[n - 1][m - 1] <= health - 1