package humanera.content;


import arc.graphics.Color;
import humanera.world.blocks.*;
import humanera.content.*;

import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.GenericSmelter;

import static mindustry.type.ItemStack.with;

public class HEBlocks implements ContentList {
    public static Block 
        
    //HoeBlock
    rotaryHoe, 
    //HoeBreaker
    woodBreaker, exMissile,
    //production
    formWork, steelForge;

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

        exMissile = new ItemTurret("missile"){{
            requirements(Category.turret, with(Items.graphite, 35, Items.titanium, 35, Items.plastanium, 45, Items.silicon, 30));
            ammo(
                    Items.blastCompound, SBullets.missile1
            );
            reloadTime = 120f;
            shots = 1;
            burstSpacing = 5;
            inaccuracy = 10f;
            range = 2000f;
            xRand = 6f;
            size = 2;
            health = 300 * size * size;
            shootSound = Sounds.missile;

        }};
    }
}
