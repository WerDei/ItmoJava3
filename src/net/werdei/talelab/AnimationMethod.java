package net.werdei.talelab;

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

    private float neededFlexibility;
    private float neededStrength;

    AnimationMethod(float flexibility, float strength)
    {
        neededFlexibility = flexibility;
        neededStrength = strength;
    }

    public boolean performAction(Creature.BodyPart part, String targetName)
    {
        if (part.getFlexibility() >= neededFlexibility && part.getStrength() >= neededStrength)
        {
            System.out.println(String.format(successLine(), part.getOwnresName(), targetName, part.getName()));
            return true;
        }
        else
        {
            System.out.println(String.format(failureLine(), part.getOwnresName(), targetName, part.getName()));
            return false;
        }
    }

    protected abstract String successLine();

    protected abstract String failureLine();
}