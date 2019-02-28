package net.werdei.talelab;

public class BodyPart {

    public enum AnimationMethod
    {
        Touch,
        Hit,
        Twist,
        Bend,
        Straighten,
        Push,
    }

    private String name;
    private Creature owner;

    // values from 0 to 100
    private float flexibility;
    private float strength;


    public BodyPart(String Name, Creature Owner)
    {
        this(Name, Owner, 35, 35);
    }

    public BodyPart(String Name, Creature Owner, float Flexibility, float Strength)
    {
        name = Name;
        owner = Owner;

        flexibility = Flexibility;
        strength = Strength;
    }


    public boolean animate(AnimationMethod method)
    {
        return animate(method, "себя");
    }

    public boolean animate(AnimationMethod method, TaleObject interactWith)
    {
        return animate(method, interactWith.getName());
    }

    public boolean animate(AnimationMethod method, BodyPart interactWith)
    {
        return animate(method, interactWith.name);
    }

    private boolean animate(AnimationMethod method, String interactWithName)
    {
        switch (method)
        {
            case Hit:
                if (strength >= 30) {
                    System.out.println(owner.toString() + " ударил(а) " + interactWithName + " своей " + name);
                    return true;
                }
                else
                {
                    System.out.println(owner.toString() + " не смог(ла) ударить " + interactWithName + " своей " + name);
                    return false;
                }

            case Bend:
                if (flexibility >= 10) {
                    System.out.println(owner.toString() + " согнул(а) свою " + name);
                    return true;
                }
                else
                {
                    System.out.println(owner.toString() + " не согнул(а) " + name);
                    return false;
                }

            case Push:
                if (strength >= 50) {
                    System.out.println(owner.toString() + " толкнул(а) " + interactWithName + " своей " + name);
                    return true;
                }
                else
                {
                    System.out.println(owner.toString() + " не смог(ла) толкнуть " + interactWithName + " своей " + name);
                    return false;
                }

            case Touch:
                if (flexibility >= 10) {
                    System.out.println(owner.toString() + " дотронулся(лась) до " + interactWithName + " своей " + name);
                    return true;
                }
                else
                {
                    System.out.println(owner.toString() + " не смог(ла) дотронуться до " + interactWithName + " своей " + name);
                    return false;
                }

            case Twist:
                if (flexibility >= 50) {
                    System.out.println(owner.toString() + " изогнул(а) " + name);
                    return true;
                }
                else
                {
                    System.out.println(owner.toString() + " не смог(ла) изогнуть) " + name);
                    return false;
                }

            case Straighten:
                if (flexibility >= 30) {
                    System.out.println(owner.toString() + " выпрямил(а) " + name);
                    return true;
                }
                else
                {
                    System.out.println(owner.toString() + " не смог(ла) выпрямить " + name);
                    return false;
                }
        }
        return true;
    }

    public void setStats(float Flexibility, float Strength)
    {
        flexibility = Flexibility;
        strength = Strength;
    }

}
