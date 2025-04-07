# Disclaimer
It's the investigation result only, it's not a complete program or library. Just yet another thing made for fun.

# llm_conveyor
Simple demonstration how can llms standalone solve some problems with conveyor of the prompts and queries.

Here, the LLM (llama3.2:1b launched locally with ollama) creates a simple tictactoe game and solves the build issues. It iteratively analyzes the output of the g++ and re-generate the text of the program. The main idea is that instead of asking the chatbot for solving complex problems, much more effectively it may be used by combining prompts by some algorithm. Here is just a demo, as you may see in logs below, the tictactoe game was written in 4 minutes in absolutely standalone mode.

Of coarse, the result actually is far from good, but it may be improved or may be the same technique may found a place in another solution.

```
Reusing configuration cache.

> Task :app:run
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
Creating initial program.
Fixing build errors
iteration 0...
tictactoe.cpp:5:1: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 | "  + --- +  ",
      | ^~~~~~~~~~~~~
tictactoe.cpp:6:1: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    6 | "      |     |",
      | ^~~~~~~~~~~~~~~
tictactoe.cpp:7:1: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    7 | "      |     |",
      | ^~~~~~~~~~~~~~~
tictactoe.cpp:8:1: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    8 | "      |     |"
      | ^~~~~~~~~~~~~~~

iteration 1...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:6:9: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    6 |         "  + --- + ",
      |         ^~~~~~~~~~~~
tictactoe.cpp:7:9: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    7 |         "      |     |",
      |         ^~~~~~~~~~~~~~~
tictactoe.cpp:8:9: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    8 |         "      |     |"
      |         ^~~~~~~~~~~~~~~

iteration 2...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:5:26: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {"  + --- + ", "      |     |", "      |     |"};
      |                          ^~~~~~~~~~~~
tictactoe.cpp:5:40: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {"  + --- + ", "      |     |", "      |     |"};
      |                                        ^~~~~~~~~~~~~~~
tictactoe.cpp:5:57: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {"  + --- + ", "      |     |", "      |     |"};
      |                                                         ^~~~~~~~~~~~~~~

iteration 3...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:5:26: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                          ^~~~~~~~~~~
tictactoe.cpp:5:39: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                       ^~~~~~~~~~~~~~~
tictactoe.cpp:5:56: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                                        ^~~~~~~~~~~~~~~

iteration 4...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:5:26: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                          ^~~~~~~~~~~
tictactoe.cpp:5:39: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                       ^~~~~~~~~~~~~~~
tictactoe.cpp:5:56: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    5 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                                        ^~~~~~~~~~~~~~~

iteration 5...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:4:26: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                          ^~~~~~~~~~~
tictactoe.cpp:4:39: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                       ^~~~~~~~~~~~~~~
tictactoe.cpp:4:56: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                                        ^~~~~~~~~~~~~~~

iteration 6...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:4:26: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                          ^~~~~~~~~~~
tictactoe.cpp:4:39: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                       ^~~~~~~~~~~~~~~
tictactoe.cpp:4:56: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {" + --- + ", "      |     |", "      |     |"};
      |                                                        ^~~~~~~~~~~~~~~

iteration 7...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:4:27: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = { "+---+ ", "      |     |", "      |     "};  // too long initializer-string
      |                           ^~~~~~~~
tictactoe.cpp:4:37: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = { "+---+ ", "      |     |", "      |     "};  // too long initializer-string
      |                                     ^~~~~~~~~~~~~~~
tictactoe.cpp:4:54: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = { "+---+ ", "      |     |", "      |     "};  // too long initializer-string
      |                                                      ^~~~~~~~~~~~~~

iteration 8...
tictactoe.cpp: In function ‘int main()’:
tictactoe.cpp:4:26: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {"+---+", "      |     ", "      |     "};
      |                          ^~~~~~~
tictactoe.cpp:4:35: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {"+---+", "      |     ", "      |     "};
      |                                   ^~~~~~~~~~~~~~
tictactoe.cpp:4:51: error: initializer-string for ‘char [3]’ is too long [-fpermissive]
    4 |     char board[10][3] = {"+---+", "      |     ", "      |     "};
      |                                                   ^~~~~~~~~~~~~~

Done, all build issues are fixed

BUILD SUCCESSFUL in 4m 1s
2 actionable tasks: 1 executed, 1 up-to-date
Configuration cache entry reused.
```
