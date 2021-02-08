package humanera.content;


import humanera.world.blocks.*;
import humanera.content.*;

import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.*;

import static mindustry.type.ItemStack.with;

public class HEBlocks implements ContentList {
    public static Block 
        
    //HoeBlock
    rotaryHoe, 
    //HoeBreaker
    woodBreaker, 
    //production
    formWork,
    //units
    hut;

    public void load(){
        rotaryHoe = new HoeBlock("rotary-hoe"){{
            requirements(Category.crafting, with(Items.copper, 75, Items.lead, 30));

            outputItem = new ItemStack(HEItems.wood, 1);
            targetBlock = Blocks.pine;
            hoeTime = 1.5f * 60;
        }};

        woodBreaker = new HoeBreaker("wood-breaker"){{
            requirements(Category.crafting, with(Items.copper, 75, Items.lead, 30));

            outputItem = new ItemStack(HEItems.wood, 1);
            targetBlock = Blocks.pine;
            hoeTime = 1.5f * 60;
        }};
        
        formWork = new GenericSmelter("Formwork"){{
            requirements(Category.crafting, with(Items.wood, 100, Items.stone, 50));
            
            craftEffect = Fx.smeltsmoke;
            ouputItem = new Itemstack(HEItems.bronze, 1);
            size = 2;
            craftTime = 50f;
            hasPower = false;
            hasItems = true;
            hasLiquids = false;
            
            flameColor = Color.valueOf("e25822");
            
            consumes.items(with(Items.copper, 3, HEItems.tin, 1));
        }};
        
        hut = new UnitFactory("hut"){{
            requirements(Category.units, with(Items.wood, 100, Items.stone, 30));
            plans = Seq.with(
                new UnitPlan(UnitTypes.stoneWorker, 60f * 15, with(Items.wood, 10, Items.stone, 10)),
            );
            hasPower = false;
            rotate = false;
            size = 2;
        }};

    }
}
