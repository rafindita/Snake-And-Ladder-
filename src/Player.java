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

public class Player {
    private String name;
    private int position;
    private SnL game;

    Player(String name, SnL game){
        this.name=name;
        this.position=0;
        this.game = game;;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPosition(int position){
        this.position = position;
    }
    public String getName(){
        return this.name;
    }
    public int getPosition(){
        return this.position;
    }

    public int[] rollDice() {
        int dice1 = (int)(Math.random() * 6 + 1);
        if (game.isMap3()) {
            int dice2 = (int)(Math.random() * 6 + 1);
            return new int[]{dice1, dice2};
        }
        return new int[]{dice1};
    }

    public void moveAround(int y, int boardSize) {
        if(this.position + y>boardSize) {
            this.position = boardSize-(this.position + y)%boardSize;
        } else {
            this.position = this.position + y;
        }



    }
}