/**
 * -----------------------------------------------------
 * ES234211 - Programming Fundamental
 * Genap - 2023/2024
 * Group Capstone Project: Snake and Ladder Game
 * -----------------------------------------------------
 * Class    : D
 * Group    : 06
 * Members  :
 * 1. 5026231105 Mirza Fathi Taufiqurrahman
 * 2. 5026231072 Arrivo Arsa Mevano
 * 3. 5026231129 Rafindita Sumar Ramadhan
 * ------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SnL{
    private ArrayList<Player> players;
    private ArrayList<Snake> snakes;
    private ArrayList<Ladder> ladders;
    private int boardSize;
    private int gameStatus;
    private int nowPlaying;
    private boolean isMap3;

    public SnL(int s){
        this.boardSize = s;
        this.players = new ArrayList<Player>();
        this.snakes = new ArrayList<Snake>();
        this.ladders = new ArrayList<Ladder>();
        this.gameStatus = 0;
        this.isMap3 = false;
    }
    public void setBoardSize(int s){
        this.boardSize = s;
    }
    public void setGameStatus(int s){
        this.gameStatus = s;
    }
    public int getGameStatus(){
        return this.gameStatus;
    }
    public void play(){
        Player playerInTurn;
        Scanner read=new Scanner(System.in);
        System.out.println("Please enter Player 1: ");
        String player1 = read.nextLine();
        System.out.println("Please enter Player 2: ");
        String player2 = read.nextLine();

        //object instantiation
        Player p1 = new Player(player1, this);
        Player p2 = new Player(player2, this);
        System.out.println("Select Map: ");
        System.out.println("1. 100 Steps");
        System.out.println("2. Nightmare");
        System.out.println("3. Long Run");
        int numMap = read.nextInt();
        if (numMap == 1){
            System.out.println("Map 100 Steps Selected");
            map1();
        }
        else if (numMap == 2){
            System.out.println("Map Nightmare Selected");
            map2();
        }
        else if (numMap == 3){
            System.out.println("Map Long Run Selected");
            map3();
        }
        addPlayer(p1);
        addPlayer(p2);

        do {
            playerInTurn =getWhoseTurn();
            System.out.println("Now Playing "+ playerInTurn.getName());
            int x = 0;
            boolean rollAgain;
            do {
                rollAgain = false;
                System.out.println(playerInTurn.getName() + " please press enter to roll the dice");
                String enter = read.nextLine();
                int[] diceResults = new int[0];
                if (enter.isEmpty()) {
                    diceResults = playerInTurn.rollDice();
                }
                int totalDice = 0;
                if (diceResults.length == 2) {
                    System.out.println("Dice 1: " + diceResults[0]);
                    System.out.println("Dice 2: " + diceResults[1]);
                    totalDice = diceResults[0] + diceResults[1];
                    if (totalDice == 12 || (diceResults[0] == 6 && diceResults[1] == 6)) {
                        rollAgain = true;
                        System.out.println(playerInTurn.getName() + " Rolled double sixes! Roll again!");
                    }
                } else {
                    System.out.println("Dice Number: " + diceResults[0]);
                    totalDice = diceResults[0];
                    if (totalDice == 6) {
                        rollAgain = true;
                        System.out.println(playerInTurn.getName() + " Rolled a six! Roll again!");
                    }
                }
                movePlayerAround(playerInTurn, totalDice);
                System.out.println("New Position:  " + playerInTurn.getPosition());
                System.out.println("==============================================");
            } while(rollAgain && getGameStatus() !=2);

        }
        while (getGameStatus()!=2);

        System.out.println("The winner is:"+ playerInTurn.getName());

    }
    public void addPlayer(Player s){
        this.players.add(s);
    }
    public ArrayList<Player> getPlayers(Player s){
        return this.players;
    }
    public void addSnake(Snake s){
        this.snakes.add(s);
    }

    public void addSnakes(int [][] s){
        for (int r = 0; r < s.length; r++){
            Snake snake = new Snake(s[r][0], s[r][1]);
            this.snakes.add(snake);
        }
    }


    public void addLadder(Ladder l){
        this.ladders.add(l);
    }

    public void addLadders(int [][] l){
        for (int r = 0; r < l.length; r++){
            Ladder ladder = new Ladder(l[r][1], l[r][0]);
            this.ladders.add(ladder);
        }

    }
    public int getBoardSize(){
        return this.boardSize;
    }
    public ArrayList<Snake> getSnakes(){
        return this.snakes;
    }
    public ArrayList<Ladder> getLadders(){
        return this.ladders;
    }
    public void map1(){
        this.boardSize = 100;
        int [][] l = {
                {2,23},
                {8,34},
                {20,77},
                {32,68},
                {41,79},
                {74,88},
                {82,100},
                {85,95}

        };
        addLadders(l);

        int[][] s = {
                {5, 47},
                {9, 29},
                {15, 38},
                {25, 97},
                {33, 53},
                {37, 62},
                {54, 86},
                {70, 92}
        };

        addSnakes(s);
    }
    public void map2(){
        this.boardSize = 200;
        int [][] l = {
                {4, 17},
                {10, 35},
                {20, 50},
                {30, 65},
                {40, 75},
                {55, 90},
                {63, 110},
                {70, 125},
                {80, 140},
                {90, 150},
                {99, 160},
                {115, 170},
                {125, 180},
                {135, 190},
                {145, 195},
                {155, 199}

        };
        addLadders(l);

        int[][] s = {
                {5, 15},
                {12, 28},
                {18, 37},
                {22, 45},
                {34, 58},
                {42, 67},
                {55, 78},
                {60, 85},
                {72, 95},
                {82, 105},
                {89, 115},
                {100, 128},
                {112, 138},
                {120, 148},
                {130, 161},
                {140, 170}
        };

        addSnakes(s);
    }
    public void map3(){
        this.boardSize = 300;
        this.isMap3 = true;
        int [][] l = {
                {2, 14},
                {11, 66},
                {25, 33},
                {42, 73},
                {55, 88},
                {63, 110},
                {70, 125},
                {84, 144},
                {99, 150},
                {115, 179},
                {133, 187},
                {157, 202},
                {175, 262},
                {195, 244},
                {211, 232},
                {245, 267},
                {255, 272},
                {269, 299},
                {289, 296}

        };
        addLadders(l);

        int[][] s = {
                {4, 19},
                {24, 62},
                {39, 77},
                {57, 86},
                {67, 104},
                {73, 138},
                {95, 158},
                {117, 169},
                {130, 183},
                {159, 200},
                {171, 222},
                {195, 234},
                {244, 260},
                {255, 275},
                {277, 298},
                {280, 291}
        };

        addSnakes(s);
    }

    public boolean isMap3() {
        return this.isMap3;
    }
    public void movePlayerAround(Player p, int x){
        p.moveAround(x, this.boardSize);
        for(Ladder l:this.ladders){
            if(p.getPosition()== l.getBottomPosition()) {
                System.out.println(p.getName() + "you got Ladder from: " + l.getBottomPosition() + " To: " + l.getTopPosition());
                p.setPosition(l.getTopPosition());
            }
        }
        for(Snake s:this.snakes){
            if(p.getPosition()== s.getHeadPosition()){
                p.setPosition(s.getTailPosition());
                System.out.println(p.getName()+" you get snake head from "+ s.getHeadPosition() + " slide down to " + s.getTailPosition());
            }
        }
        if(p.getPosition()==this.boardSize){
            this.gameStatus=2;
        }


    }
    public Player getWhoseTurn(){

        if(this.gameStatus==0){
            this.gameStatus=1;
            double r= Math.random();
            if(r<=0.5){
                this.nowPlaying = 0;
                return this.players.get(0);
            }
            else {
                this.nowPlaying = 1;
                return this.players.get(1);
            }
        }
        else{
            if(this.nowPlaying == 0){
                this.nowPlaying = 1;
                return this.players.get(1);
            }

            else {
                this.nowPlaying = 0;
                return this.players.get(0);

            }
        }
    }
}