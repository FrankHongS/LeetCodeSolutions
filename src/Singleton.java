import java.util.List;

/**
 * Created by Frank_Hon on 2022/8/25 4:17 PM.
 * E-mail: frank_hon@foxmail.com
 */
public class Singleton {

//    private static volatile Singleton INSTANCE;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (INSTANCE == null) {
//            synchronized (Singleton.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new Singleton();
//                }
//            }
//        }
//        return INSTANCE;
//    }

    public static void main(String[] args) {

    }

    private static class Entity {
        int value;
        int weight;
    }

    private Entity getRandomEntity(List<Entity> list) {
        if (list == null) {
            return null;
        }
        int weightSum = 0;
        for (Entity entity :
                list) {
            weightSum += entity.weight;
        }
        float random = (float) Math.random();//[0,1)
        int preWeight = 0;
        for (Entity entity :
                list) {
            float temp = preWeight * 1f / weightSum;
            preWeight += entity.weight;
            float newTemp = preWeight * 1f / weightSum;
            if (random >= temp && random < newTemp) {
                return entity;
            }
        }
        return null;
    }
}
