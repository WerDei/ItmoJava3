package net.werdei.talelab;

public abstract class Human extends Creature{

    private BodyPart armRight;
    private BodyPart armLeft;
    private BodyPart head;


    public Human(String Name, Place Location, String... Nicknames)
    {
        super(Name, Location, Nicknames);

        armRight = new BodyPart("правая рука");
        armLeft = new BodyPart("левая рука");
        head = new BodyPart("голова");
    }


    private void transformation()
    {
        System.out.println(toString() + " чувствует себя необычно");
        armRight.setStats(5, 5);
        armLeft.setStats(5, 5);
        head.setStats(100, 40);
    }

    private void recoil()
    {
        System.out.println(toString() + " отпрянул(а)");
        immobilised = true;
    }


    public boolean armsTouchHead()
    {
        return armRight.animate(AnimationMethod.Touch, head)
                & armLeft.animate(AnimationMethod.Touch, head);
    }

    public boolean headBend()
    {
        return head.animate(AnimationMethod.Bend);
    }

    public boolean headTwist()
    {
        return head.animate(AnimationMethod.Twist);
    }


    @Override
    public void reactToEvent(TaleEvent event) {
        if(event == TaleEvent.Magic)
            transformation();
        else if (event == TaleEvent.LoudSound)
            recoil();
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ armRight.hashCode() ^ armLeft.hashCode() ^ head.hashCode();
    }
}
