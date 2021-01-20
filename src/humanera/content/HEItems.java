package humanera.content;

import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class HEItems implements ContentList {
    public static Item wood, stone, cassiterite, tin;

    public void load(){
        wood = new Item("wood");
        stone = new Item("Stone");
        tin = new Item("tin");
        cassiterite = new Item("Cassiterite");
    }
}
