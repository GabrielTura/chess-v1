package chessgame;

import java.util.LinkedList;

public class Piece {
    int xp;
    int yp;
    int x;
    int y;
    boolean isWhite;
    String name;
    LinkedList<Piece> ps;
    
    public Piece(int xp, int yp, boolean isWhite, String n, LinkedList<Piece> ps){
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
        this.isWhite = isWhite;
        name = n;
        this.ps = ps;
        ps.add(this);
    }
    
    public void move(int xp, int yp){
        Piece p = ChessGame.getPiece(xp*64, yp*64);
        if(p != null){
            if(p.isWhite != isWhite){
                p.kill();
            }else{
                x = this.xp*64;
                y = this.yp*64;
                return;
            }
        }
        this.xp = xp;
        this.yp = yp;
        x = xp*64;
        y = yp*64;
    }
    
    public void kill(){
        ps.remove(this);
    }
}
