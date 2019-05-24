import java.util.ArrayList;

public class Scene {

    private static ArrayList<Rectangle> houseObjects;

    public static ArrayList<Rectangle> getHouseSceneObjects(Rectangle background){
       houseObjects = new ArrayList<Rectangle>();
       Rectangle firePlace1, firePlace2, workshopTable, table, fence1, fence2, picket, exit;
       firePlace1 = new Rectangle(182 + background.getX(), 128 + background.getY(), 25, 30, false);
       firePlace2 = new Rectangle(250 + background.getX(), 128 + background.getY(), 29, 30, false);
       workshopTable = new Rectangle(75 + background.getX(), 70 + background.getY(), 44, 36, false);
       table = new Rectangle(scale(160, 1.875) + background.getX() - 5, scale(80,2) + background.getY(), scale(207, 1.875) - scale(160, 1.875), scale(110,2) - scale(80,2), false);
       fence1 = new Rectangle(scale(32, 1.875) + background.getX(), scale(80,2) + background.getY(), scale(86, 1.875) - scale(32, 1.875), scale(87,2) - scale(80,2), false);
       picket = new Rectangle(scale(80, 1.875) + background.getX(), scale(88,2) + background.getY(), scale(86, 1.875) - scale(80, 1.875), scale(95,2) - scale(88,2), false);
       fence2 = new Rectangle(scale(80, 1.875) + background.getX(), scale(128,2) + background.getY(), scale(86, 1.875) - scale(80, 1.875), scale(143,2) - scale(128,2), false);
       exit = new Rectangle(scale(111, 1.875) + background.getX(), scale(143,2) + background.getY(), scale(128, 1.875) - scale(111, 1.875), scale(159,2) - scale(143,2), false);
       houseObjects.add(firePlace1);
       houseObjects.add(firePlace2);
       houseObjects.add(workshopTable);
       houseObjects.add(table);
       houseObjects.add(fence1);
       houseObjects.add(picket);
       houseObjects.add(fence2);
       houseObjects.add(exit);
       return houseObjects;
    }
    //1.875

    private static int scale(int x, double scale){
        return (int)(x * scale);
    }

}
