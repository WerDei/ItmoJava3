package net.werdei.talelab;

public class Human extends Creature{

    private BodyPart armRight;
    private BodyPart armLeft;
    private BodyPart head;


    public Human(String Name, Place Location, String... Nicknames)
    {
        super(Name, Location, Nicknames);

        armRight = new BodyPart("правая рука", this);
        armLeft = new BodyPart("левая рука", this);
        head = new BodyPart("голова", this);
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
        boolean result;
        result = armRight.animate(BodyPart.AnimationMethod.Touch, head);
        result = result & armLeft.animate(BodyPart.AnimationMethod.Touch, head);
        return result;
    }

    public boolean headBend()
    {
        return head.animate(BodyPart.AnimationMethod.Bend);
    }

    public boolean headTwist()
    {
        return head.animate(BodyPart.AnimationMethod.Twist);
    }


    @Override
    public void reactToEvent(TaleEvent event) {
        if(event == TaleEvent.Magic)
            transformation();
        else if (event == TaleEvent.LoudSound)
            recoil();
    }

    @Override
    public void think(TaleObject about) {
        System.out.println(toString() + " понял(ла), что " + about.getNickname() + " - это " + about.getName());
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ armRight.hashCode() ^ armLeft.hashCode() ^ head.hashCode();
    }
}
