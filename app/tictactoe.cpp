#include <iostream>

int main() {
    char board[10][3] = {'+', '-', '+'};  // Fix: Initialize with single character instead of string
    
    int player = 'X';
    int turn = 1;
    bool check = true;

    while (check) {
        std::cout << "Player " << turn << ", enter the number of your move (1-9): ";
        int turn;
        std::cin >> turn;
        
        if(turn < 1 || turn > 10){
            std::cout << "Invalid Input" << std::endl;
            continue;
        }

        char c = board[turn - 2][1];
        if(c == '+')
            board[turn - 1][1] = 'X';
        else
            board[turn - 1][1] = 'O';

        for(int i=0;i<10;i++)
            std::cout << board[i][1];
        std::cout << "\n";
        
        if(turn % 2 == 0)
            check = false;
    }

    if (player == 'Q') {
        std::cout << "Game Over, Player X wins!" << std::endl;
    }

    return 0;
}