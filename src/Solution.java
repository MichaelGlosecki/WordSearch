public class Solution {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int columnLength = board.length;
        int rowLength = board[0].length;
        boolean[][] visited = new boolean[columnLength][rowLength];
        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (depthFirstSearch(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean depthFirstSearch(char[][] board, String word, boolean[][] visited, int row, int column, int index) {
        if (word.length() == index) {
            return true;
        }

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return false;
        }

        char characterToFind = word.charAt(index);
        if (!visited[row][column] && characterToFind == board[row][column]) {
            visited[row][column] = true;
            index++;
            boolean found = depthFirstSearch(board, word, visited, row - 1, column, index) ||
                    depthFirstSearch(board, word, visited, row + 1, column, index) ||
                    depthFirstSearch(board, word, visited, row, column - 1, index) ||
                    depthFirstSearch(board, word, visited, row, column + 1, index);
            visited[row][column] = false;
            return found;
        }

        return false;
    }
}
