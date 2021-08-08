package com.leet_code.dfs;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int indexWord) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length
                || board[i][j] != word.charAt(indexWord)) {
            return false;
        }

        if (indexWord == word.length()-1 && board[i][j] == word.charAt(indexWord)) return true;

        indexWord++;
        char tmp = board[i][j];
        board[i][j] = ' ';
        boolean stat =  dfs(board, i-1, j, word, indexWord) ||
                        dfs(board, i, j-1, word, indexWord) ||
                        dfs(board, i+1, j, word, indexWord) ||
                        dfs(board, i, j+1, word, indexWord) ;

        board[i][j] = tmp;
        return stat;
    }

}
