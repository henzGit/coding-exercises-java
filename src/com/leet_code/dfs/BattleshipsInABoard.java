package com.leet_code.dfs;

/**
 * Given an m x n matrix board where each cell is a battleship 'X' or empty '.',
 * return the number of the battleships on board.
 *
 * Battleships can only be placed horizontally or vertically on board.
 * In other words, they can only be made of the shape 1 x k (1 row, k columns)
 * or k x 1 (k rows, 1 column), where k can be of any size.
 * At least one horizontal or vertical cell separates between two battleships
 * (i.e., there are no adjacent battleships).
 * https://leetcode.com/problems/battleships-in-a-board/
 */
public class BattleshipsInABoard {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'
                        || (i > 0 && board[i][j] == board[i-1][j])
                        || (j > 0 && board[i][j] == board[i][j-1])){
                    continue;
                }
                count++;
            }
        }
        return count;
    }
}
