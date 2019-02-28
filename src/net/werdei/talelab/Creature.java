package net.werdei.talelab;

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
        if (canMove())
        {
            String message = toString();
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
            String message = toString();
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
            System.out.printf(toString() + " не смог прогулятся");
            return false;
        }
    }
}
