package net.werdei.talelab;

public class BodyPart {

    public enum AnimationMethod
    {
        Touch(10, 10)
                {
                    @Override
                    protected String successLine() { return "%1$s дотронулся(лась) до %2$s своей %3$s"; }

                    @Override
                    protected String failureLine() { return "%1$s не смог(ла) дотронуться до %2$s своей %3$s"; }
                },
        Hit(30, 30)
                {
                    @Override
                    protected String successLine() { return "%1$s ударил(а) %2$s своей %3$s"; }

                    @Override
                    protected String failureLine() { return "%1$s не смог(ла) ударить %2$s своей %3$s"; }
                },
        Twist(50, 20)
                {
                    @Override
                    protected String successLine() { return "%1$s изогнул(а) свою %3$s"; }

                    @Override
                    protected String failureLine() { return "%1$s не смог(ла) изогнуть %3$s"; }
                },
        Bend(10, 10)
                {
                    @Override
                    protected String successLine() { return "%1$s согнул(ла) свою %3$s"; }

                    @Override
                    protected String failureLine() { return "%1$s не смог(ла) согнуть %3$s"; }
                },
        Straighten(30, 30)
                {
                    @Override
                    protected String successLine() { return "%1$s выпрямил(а) свою %3$s"; }

                    @Override
                    protected String failureLine() { return "%1$s не смог(ла) выпрямить %3$s"; }
                },
        Push(20, 50)
                {
                    @Override
                    protected String successLine() { return "%1$s толкнул(а) %2$s своей %3$s"; }

                    @Override
                    protected String failureLine() { return "%1$s не смог(ла) толкнуть %2$s своей %3$s"; }
                };

        public float neededFlexibility;
        public float neededStrength;

        AnimationMethod(float flexibility, float strength)
        {
            neededFlexibility = flexibility;
            neededStrength = strength;
        }

        public boolean performAction(BodyPart part, String targetName)
        {
            if (part.flexibility >= neededFlexibility && part.strength >= neededStrength)
            {
                System.out.println(String.format(successLine(), part.owner.toString(), targetName, part.name));
                return true;
            }
            else
            {
                System.out.println(String.format(failureLine(), part.owner.toString(), targetName, part.name));
                return false;
            }
        }

        protected abstract String successLine();

        protected abstract String failureLine();
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

    @Override
    public String toString() {
        return name + ", принадлежащая " + owner.toString();
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
