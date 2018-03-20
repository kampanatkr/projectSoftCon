package sample.Controller;

import sample.Models.Crab;

public class KeyAction {
    private Crab crab;
    private boolean isMoveUp;
    private boolean isMoveDown;
    private boolean isMoveLeft;
    private boolean isMoveRight;

    public KeyAction(Crab crab) {
        this.crab = crab;
    }

    public void setMoveUp(boolean moveUp) {
        isMoveUp = moveUp;
    }

    public void setMoveDown(boolean moveDown) {
        isMoveDown = moveDown;
    }

    public void setMoveLeft(boolean moveLeft) {
        isMoveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        isMoveRight = moveRight;
    }

    public void action(){
        if (isMoveUp) crab.goUp();
        if (isMoveDown) crab.goDown();
        if (isMoveLeft) crab.goLeft();
        if (isMoveRight) crab.goRight();
    }

    public void setCrab(Crab crab) {
        this.crab = crab;
    }
}
