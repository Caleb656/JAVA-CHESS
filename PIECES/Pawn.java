package PIECES;

import java.util.ArrayList;
import java.util.List;

import BOARD_INFO.Board;
import BOARD_INFO.TILES.*;
import ENGINE.Move;
import ENUM.Color;;

public class Pawn extends Piece {

    public Pawn(int posX, int posY, Color color, Board board) {
        super(posX, posY, color, board);
    }

    private Tile pos;
    public int value = 1;
    private boolean firstMove = true;
    
    @Override
    public boolean move(Move move) {
        int newX = move.getNew().getCoordX();
        int newY = move.getNew().getCoordY();
        Tile newTile = move.getNew();

        if(newX < 0 || newX > 7 || newY < 0 || newY > 7){
            System.out.print("Invalid Input, Out of Bounds");
            return false;
        }
        // firstmove = false is temporary implementation, will need to be changed once Move list is working
        if(this.color == Color.BLACK){
            if(newY == this.posY-1 && newX == this.posX && newTile.getClass() != FullTile.class){
                this.firstMove = false;
                return true;
            }
            else if(newY == this.posY-2 && this.firstMove && newTile.getClass() != FullTile.class){
                this.firstMove = false;
                return true;
            }
            else if(newY == this.posY-1 && (newX == this.posX-1 || newX == this.posX+1) && newTile.getClass() == FullTile.class && newTile.getPiece().getColor() != this.color){
                return true;
            }
            else{
//                System.out.println("Invalid Pawn Move");
                return false;
            }
        }
        else if(this.color == Color.WHITE){
            if(newY == this.posY+1 && newX == this.posX && newTile.getClass() != FullTile.class){
                this.firstMove = false;
                return true;
            }
            else if(newY == this.posY+2 && this.firstMove && newTile.getClass() != FullTile.class){
                this.firstMove = false;
                return true;
            }
            else if(newY == this.posY+1 && (newX == this.posX-1 || newX == this.posX+1) && newTile.getClass() == FullTile.class && newTile.getPiece().getColor() != this.color){
                return true;
            }
            else{
//                System.out.println("Invalid Pawn Move");
                return false;
            }
        }
        return false;
    }

    public void doublePawn() {
        this.firstMove = false;
    }

    public void enPassant() {
        
    }

    @Override
    public List<Move> findMoves(Board b) {
        List<Move> moves = new ArrayList<>();

        // for(int i = 0; i < 8; i++) {
        //     for(int j = 0; j < 8; j++){
        //         if(move(i, j) && (b.getTile(i, j) instanceof EmptyTile)) {
        //             moves.add(new Move(b.getTile(this.posX, this.posY), b.getTile(i, j)));
        //         }
        //     }
        // }
        // //Pawn capture check, this may cause error for edge cases, yet to test
        // if (this.color == Color.BLACK) {
        //     if((posX != 7) && b.getTile(posX + 1, posY - 1).getColor() == Color.WHITE){
        //         moves.add(new Move(b.getTile(this.posX, this.posY), b.getTile(posX + 1, posY - 1)));
        //     }
        //     if((posX != 0) && b.getTile(posX - 1, posY - 1).getColor() == Color.WHITE){
        //         moves.add(new Move(b.getTile(this.posX, this.posY), b.getTile(posX + 1, posY - 1)));
        //     }
        // }

        // else {
        //     if((posX != 7) && b.getTile(posX + 1, posY + 1).getColor() == Color.WHITE){
        //         moves.add(new Move(b.getTile(this.posX, this.posY), b.getTile(posX + 1, posY - 1)));
        //     }
        //     if((posX != 0) && b.getTile(posX - 1, posY + 1).getColor() == Color.WHITE){
        //         moves.add(new Move(b.getTile(this.posX, this.posY), b.getTile(posX + 1, posY - 1)));
        //     }
        // }
        return moves;

    }

}