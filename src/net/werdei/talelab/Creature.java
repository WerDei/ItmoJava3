package net.werdei.talelab;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Creature extends TaleObject implements IntelligentObject{

    public enum MoveMethod
    {
        Walk("%1$s идёт в %2$s"),
        Run("%1$s бежит в %2$s"),
        Dive("%1$s ныряет в %2$s"),
        Jump("%1$s прфгает в %2$s"),
        Teleport("%1$s переносится в %2$s");

        private String travelMessage;

        MoveMethod(String message)
        {
            travelMessage = message;
        }
    }

    protected boolean confused = false;


    public Creature(String Name, Place Location, String... Nicknames)
    {
        super(Name, Location, Nicknames);
    }


    public boolean canMove() throws CreatureCantMoveException
    {
        if (confused)
            throw new CreatureCantMoveException("в растерянности", 0.75f);
        return true;
    }

    private void tryToRecover(float chance)
    {
        if (ThreadLocalRandom.current().nextFloat() <= chance)
        {
            System.out.println(toString() + "пришёл(ла) в себя");
            confused = false;
        }
    }

    public boolean travelTo(Place location, MoveMethod method)
    {
        try
        {
            System.out.println(String.format(method.travelMessage, toString(), location.toString()));
            canMove();
            return true;
        }
        catch (CreatureCantMoveException e)
        {
            System.out.println(toString() + " " + e.getMessage() + " и не может двигаться!");
            tryToRecover(1 * e.getRecoverChance());

            return false;
        }
    }

    public boolean strall() {
        try
        {
            canMove();
            System.out.println(toString() + " гуляет по " + getLocation());
            return true;
        }
        catch (CreatureCantMoveException e)
        {
            System.out.println(toString() + " " + e.getMessage() + " - он/она застыл(ла) на месте");
            tryToRecover(0.5f * e.getRecoverChance());
            return false;
        }

    }

    public class BodyPart {

        private String name;
        // values from 0 to 100
        private float flexibility;
        private float strength;


        public BodyPart(String Name)
        {
            this(Name, 35, 35);
        }

        public BodyPart(String Name, float Flexibility, float Strength)
        {
            name = Name;

            flexibility = Flexibility;
            strength = Strength;
        }


        public boolean animate(AnimationMethod method)
        {
            return method.performAction(this, "себя");
        }

        public boolean animate(AnimationMethod method, TaleObject interactWith)
        {
            return method.performAction(this, interactWith.toString());
        }

        public boolean animate(AnimationMethod method, BodyPart interactWith)
        {
            return method.performAction(this, interactWith.name);
        }

        public void setStats(float Flexibility, float Strength)
        {
            flexibility = Flexibility;
            strength = Strength;
        }

        public String getName()
        {
            return name;
        }

        public String getOwnersName()
        {
            return Creature.this.toString();
        }

        public float getFlexibility() {
            return flexibility;
        }

        public float getStrength() {
            return strength;
        }

        @Override
        public String toString() {
            return name + ", принадлежащая " + Creature.this.toString();
        }

        @Override
        public int hashCode() {
            return name.hashCode() ^ Float.floatToIntBits(flexibility) ^ Float.floatToIntBits(strength);
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }
    }
}
