import net.werdei.talelab.*;

public class Main {

    public static void main(String[] args)
    {
        // SETUP

        Scene mainScene = new Scene();

        Forest forest = new Forest("Лес", mainScene, 15, "Под деревьями");
        Forest.Leaves leaves = forest.growLeaves();

        Human alice = new Human("Алиса", forest, "Она", "Девочка") {
            @Override
            public void think(TaleObject about) {
                System.out.println(toString() + " понял(ла), что " + about.getNickname() + " - это " + about.getName());
            }
        };

        Sky sky = new Sky("Небо", mainScene, 5, "Облака");

        // TALE

        alice.strall();

        Place.CreateEvent(TaleEvent.Magic, mainScene);
        alice.travelTo(sky, Creature.MoveMethod.Teleport);

        alice.armsTouchHead();

        Place.CreateEvent(TaleEvent.Wind, mainScene);
        alice.think(leaves);

        alice.headBend();
        alice.headTwist();

        Place.CreateEvent(TaleEvent.LoudSound, mainScene);

        alice.travelTo(forest, Creature.MoveMethod.Dive);
    }
}
