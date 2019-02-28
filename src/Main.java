import net.werdei.talelab.*;

public class Main {

    public static void main(String[] args)
    {
        // SETUP

        Scene mainScene = new Scene();

        Forest forest = new Forest("Лес", mainScene,15, "Под деревьями");
        Leaves leaves = new Leaves("Листва", forest, "Зелёное море", "Зелень");
        Human alice = new Human("Алиса", forest, "Она", "Девочка");

        Sky sky = new Sky("Небо", mainScene, 5, "Облака");

        // TALE

        alice.strall();

        Place.CreateEvent(TaleEvent.Magic, mainScene);
        alice.travelTo(sky, Creature.MoveMethod.Teleport);

        Place.CreateEvent(TaleEvent.Wind, mainScene);

        alice.armsTouchHead();
        alice.headBend();
        alice.headTwist();

        Place.CreateEvent(TaleEvent.LoudSound, mainScene);

        alice.travelTo(forest, Creature.MoveMethod.Dive);
    }
}