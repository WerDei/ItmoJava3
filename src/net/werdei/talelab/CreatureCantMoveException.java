package net.werdei.talelab;

public class CreatureCantMoveException extends Exception {

    private float recoverChance;

    public CreatureCantMoveException(String message, float chanceToRecover)
    {
        super(message);
        recoverChance = chanceToRecover;
    }

    public float getRecoverChance() {
        return recoverChance;
    }
}
