package net.werdei.talelab;

import javax.sql.rowset.spi.SyncResolver;

public abstract class Creature extends TaleObject implements IntelligentObject{

    public enum MoveMethod
    {
        Walk,
        Run,
        Dive,
        Jump,
        Teleport,
    }

    protected boolean immobilised = false;


    public Creature(String Name, Place Location, String... Nicknames)
    {
        super(Name, Location, Nicknames);
    }


    public boolean canMove()
    {
        return !immobilised;
    }

    public boolean travelTo(Place location, MoveMethod method)
    {
        String message = toString();
        if (canMove())
        {
            switch (method)
            {
                case Run:
                    message += " вбегает в ";
                    break;
                case Dive:
                    message += " ныряет в ";
                    break;
                case Jump:
                    message += " прыгает в ";
                    break;
                case Walk:
                    message += " идёт в ";
                    break;
                case Teleport:
                    message += " оказался(лась) в ";
                    break;
            }
            message += location.toString();

            System.out.println(message);

            moveTo(location);
            return true;
        }
        else
        {
            switch (method)
            {
                case Run:
                    message += " не вбежал(ла) в ";
                    break;
                case Dive:
                    message += " не смог(ла) нырнуть в ";
                    break;
                case Jump:
                    message += " не запрыгнул(ла) в ";
                    break;
                case Walk:
                    message += " остановился(лась) на пути к ";
                    break;
                case Teleport:
                    message += " не переместился(лась) в ";
                    break;
            }
            message += location.toString();

            System.out.println(message);
            return false;
        }
    }

    public boolean strall()
    {
        if (canMove()) {
            System.out.println(toString() + " гуляет по " + getLocation());
            return true;
        }
        else
        {
            System.out.println(toString() + " не смог прогулятся");
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

        public String getOwnresName()
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
