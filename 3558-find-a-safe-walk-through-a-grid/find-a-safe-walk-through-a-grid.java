import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        // Directions array for 4-way movement (Up, Right, Down, Left)
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // minCost[i][j] stores the minimum health lost to reach cell (i, j)
        int[][] minCost = new int[m][n];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Initialize the starting position
        minCost[0][0] = grid.get(0).get(0);
        
        // Double-ended queue for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0, 0});
        
        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];
            
            // If we reached the destination, we can stop early
            if (r == m - 1 && c == n - 1) {
                break;
            }
            
            // Explore all 4 adjacent neighbors
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                // Check grid boundaries
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextCost = minCost[r][c] + grid.get(nr).get(nc);
                    
                    // If a safer path to (nr, nc) is found
                    if (nextCost < minCost[nr][nc]) {
                        minCost[nr][nc] = nextCost;
                        
                        // 0-1 BFS optimization
                        if (grid.get(nr).get(nc) == 0) {
                            deque.offerFirst(new int[]{nr, nc}); // Cost 0: High priority
                        } else {
                            deque.offerLast(new int[]{nr, nc});  // Cost 1: Low priority
                        }
                    }
                }
            }
        }
        
        // We must arrive at the final cell with at least 1 health point remaining
        return minCost[m - 1][n - 1] < health;
    }
}