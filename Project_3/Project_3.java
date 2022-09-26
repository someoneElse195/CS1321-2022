import java.util.Scanner;

public class Project_3 {

    public static void main(String[] args) {
        

        //Initial variables
        Scanner scnr = new Scanner(System.in);

        boolean gameActive = true;
        boolean xWin = false;
        boolean oWin = false;

        int player = 1;
        int inputColumn;
        int inputRow;
        int roundsPlayed = 0;

        //Initializes the array as 2D and fills each value with "E" to indicate the space is empty.
        String[][] ticTac = new String[3][3];
        
        for(int row = 0; row < ticTac.length; row++) {
            
            for (int column = 0; column < ticTac.length; column ++) {
                ticTac[row][column] = "E";
            }
        }

        //Prints out the initial Tic Tac Toe square.
        System.out.println("Welcome to 2 Player Tic Tac Toe."); 
        System.out.println("--------------------------------");  
        System.out.println("/-----|-----|-----\\"); 
        System.out.println("|  " + ticTac[0][0] + "  |  " + ticTac[0][1] + "  |  " + ticTac[0][2] + "  |"); 
        System.out.println("|-----------------|"); 
        System.out.println("|  " + ticTac[1][0] + "  |  " + ticTac[1][1] + "  |  " + ticTac[1][2] + "  |"); 
        System.out.println("|-----------------|"); 
        System.out.println("|  " + ticTac[2][0] + "  |  " + ticTac[2][1] + "  |  " + ticTac[2][2] + "  |"); 
        System.out.println("/-----|-----|-----\\");
        System.out.println("X's will play first. Enter the slot coordinates to place X in:");

        //Game Loop
        while(gameActive == true) {

            //Player 1 Loop
            while(player == 1) {
                System.out.println("Player1's turn ");
                inputRow = scnr.nextInt();
                inputColumn = scnr.nextInt();
                
                //Checking if input is invalid. i.e. invalid row or already taken
                if((inputRow < 0 || inputRow > 2) || (inputColumn < 0 || inputColumn > 2)) {
                    System.out.println("Please enter the correct slot coordinates ");
                    continue;
                }
                else if(ticTac[inputRow][inputColumn] != "E") {
                    System.out.println("The slot is already taken: re-enter slot number:");
                    continue;

                    
                }

                //Putting character in array
                ticTac[inputRow][inputColumn] = "X";
                roundsPlayed += 1;

                //Testing if win or tie conditions fulfilled
                if((ticTac[0][0] == "X" && ticTac[0][1] == "X" && ticTac[0][2] == "X") || (ticTac[1][0] == "X" && ticTac[1][1] == "X" && ticTac[1][2] == "X") || (ticTac[2][0] == "X" && ticTac[2][1] == "X" && ticTac[2][2] == "X") || (ticTac[0][0] == "X" && ticTac[1][0] == "X" && ticTac[2][0] == "X") || (ticTac[0][1] == "X" && ticTac[1][1] == "X" && ticTac[2][1] == "X") || (ticTac[0][2] == "X" && ticTac[1][2] == "X" && ticTac[2][2] == "X") || (ticTac[0][0] == "X" && ticTac[1][1] == "X" && ticTac[2][2] == "X") || (ticTac[0][2] == "X" && ticTac[1][1] == "X" && ticTac[2][0] == "X")) {
                    gameActive = false;
                    xWin = true;
                    break;
    
                }
                else if(roundsPlayed == 9) {
                    gameActive = false;
                    break;
                }

                System.out.println("--------------------------------");  
                System.out.println("/-----|-----|-----\\"); 
                System.out.println("|  " + ticTac[0][0] + "  |  " + ticTac[0][1] + "  |  " + ticTac[0][2] + "  |"); 
                System.out.println("|-----------------|"); 
                System.out.println("|  " + ticTac[1][0] + "  |  " + ticTac[1][1] + "  |  " + ticTac[1][2] + "  |"); 
                System.out.println("|-----------------|"); 
                System.out.println("|  " + ticTac[2][0] + "  |  " + ticTac[2][1] + "  |  " + ticTac[2][2] + "  |"); 
                System.out.println("/-----|-----|-----\\");

                player = 2;

            
            }
            //Player 2 Loop
            while(player == 2) {
                System.out.println("Player2's turn ");
                inputRow = scnr.nextInt();
                inputColumn = scnr.nextInt();
                
                //Checking if input is invalid. i.e. invalid row or already taken
                if((inputRow < 0 || inputRow > 2) || (inputColumn < 0 || inputColumn > 2)) {
                    System.out.println("Please enter the correct slot coordinates ");
                    continue;
                }
                else if(ticTac[inputRow][inputColumn] != "E") {
                    System.out.println("The slot is already taken: re-enter slot number:");
                    continue;
                }

                //Putting character in array
                ticTac[inputRow][inputColumn] = "O";
                roundsPlayed += 1;

                //Checking to see if win or tie conditions fulfilled
                if((ticTac[0][0] == "O" && ticTac[0][1] == "O" && ticTac[0][2] == "O") || (ticTac[1][0] == "O" && ticTac[1][1] == "O" && ticTac[1][2] == "O") || (ticTac[2][0] == "O" && ticTac[2][1] == "O" && ticTac[2][2] == "O") || (ticTac[0][0] == "O" && ticTac[1][0] == "O" && ticTac[2][0] == "O") || (ticTac[0][1] == "O" && ticTac[1][1] == "O" && ticTac[2][1] == "O") || (ticTac[0][2] == "O" && ticTac[1][2] == "O" && ticTac[2][2] == "O") || (ticTac[0][0] == "O" && ticTac[1][1] == "O" && ticTac[2][2] == "O") || (ticTac[0][2] == "O" && ticTac[1][1] == "O" && ticTac[2][0] == "O")) {
                    gameActive = false;
                    oWin = true;
                    break;
                }
                else if(roundsPlayed == 9) {
                    gameActive = false;
                    break;
                }
                System.out.println("--------------------------------");  
                System.out.println("/-----|-----|-----\\"); 
                System.out.println("|  " + ticTac[0][0] + "  |  " + ticTac[0][1] + "  |  " + ticTac[0][2] + "  |"); 
                System.out.println("|-----------------|"); 
                System.out.println("|  " + ticTac[1][0] + "  |  " + ticTac[1][1] + "  |  " + ticTac[1][2] + "  |"); 
                System.out.println("|-----------------|"); 
                System.out.println("|  " + ticTac[2][0] + "  |  " + ticTac[2][1] + "  |  " + ticTac[2][2] + "  |"); 
                System.out.println("/-----|-----|-----\\");

                player = 1;

            }
        }   
        //Win conditions
        if(xWin) {
            System.out.println("Congratulations! X's have won! Thanks for playing.");
            System.out.println("The final result of Tic Tac Toe game is.");
            System.out.println("--------------------------------");  
            System.out.println("/-----|-----|-----\\"); 
            System.out.println("|  " + ticTac[0][0] + "  |  " + ticTac[0][1] + "  |  " + ticTac[0][2] + "  |"); 
            System.out.println("|-----------------|"); 
            System.out.println("|  " + ticTac[1][0] + "  |  " + ticTac[1][1] + "  |  " + ticTac[1][2] + "  |"); 
            System.out.println("|-----------------|"); 
            System.out.println("|  " + ticTac[2][0] + "  |  " + ticTac[2][1] + "  |  " + ticTac[2][2] + "  |"); 
            System.out.println("/-----|-----|-----\\");            
        } 
        else if (oWin) {
            System.out.println("Congratulations! O's have won! Thanks for playing.");
            System.out.println("The final result of Tic Tac Toe game is.");
            System.out.println("--------------------------------");  
            System.out.println("/-----|-----|-----\\"); 
            System.out.println("|  " + ticTac[0][0] + "  |  " + ticTac[0][1] + "  |  " + ticTac[0][2] + "  |"); 
            System.out.println("|-----------------|"); 
            System.out.println("|  " + ticTac[1][0] + "  |  " + ticTac[1][1] + "  |  " + ticTac[1][2] + "  |"); 
            System.out.println("|-----------------|"); 
            System.out.println("|  " + ticTac[2][0] + "  |  " + ticTac[2][1] + "  |  " + ticTac[2][2] + "  |"); 
            System.out.println("/-----|-----|-----\\");
        }
        else {
            System.out.println("It's a draw! Thanks for playing");
            System.out.println("The final result of Tic Tac Toe game is.");
            System.out.println("--------------------------------");  
            System.out.println("/-----|-----|-----\\"); 
            System.out.println("|  " + ticTac[0][0] + "  |  " + ticTac[0][1] + "  |  " + ticTac[0][2] + "  |"); 
            System.out.println("|-----------------|"); 
            System.out.println("|  " + ticTac[1][0] + "  |  " + ticTac[1][1] + "  |  " + ticTac[1][2] + "  |"); 
            System.out.println("|-----------------|"); 
            System.out.println("|  " + ticTac[2][0] + "  |  " + ticTac[2][1] + "  |  " + ticTac[2][2] + "  |"); 
            System.out.println("/-----|-----|-----\\");
        }
        scnr.close();

    }   
}