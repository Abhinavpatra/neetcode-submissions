class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 sets for rows, 9 for cols, 9 for boxes
        Set<Character>[] rows  = new HashSet[9];
        Set<Character>[] cols  = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i]  = new HashSet<>();
            cols[i]  = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                if (val == '.') continue;
                // Box index: which of the 9 boxes does (r,c) belong to?
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If any set already contains val → duplicate → invalid
                if (!rows[r].add(val) || !cols[c].add(val) || !boxes[boxIndex].add(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
