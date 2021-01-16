package humanera.world.blocks;

import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.math.Mathf;
import arc.util.Time;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.content.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.ItemStack;
import mindustry.world.*;
import mindustry.gen.*;

public class HoeBlock extends Block{
    public ItemStack outputItem;
    public Block targetBlock;
    public float hoeTime;

    public HoeBlock(String name){
        super(name);
        rotate = true;
        update = true;
        solid = true;
        hasItems = true;
        sync = true;
        breakable = true;
        health = 40 * size * size;
    }

    public class HoeBlockBuild extends Building{
        public float progress;
        public float totalProgress;
        public float warmup;

        @Override
        public void updateTile() {
            super.updateTile();
            if(foundBlock()) {
                progress += getProgressIncrease(hoeTime);
                totalProgress += delta();
                warmup = Mathf.lerpDelta(warmup, 1f, 0.02f);
            }else warmup = Mathf.lerp(warmup, 0f, 0.02f);

            if(progress >= 1f){
                if(outputItem != null) doHoe();
                progress = 0f;
            }
        }

        @Override
        public void draw() {
            Draw.z(Layer.blockUnder - 0.01f);
            Draw.rect("block-1", this.x, this.y);
            Draw.z(Layer.blockOver);
            float r = Mathf.sin(Time.time + Mathf.randomSeed(this.id)*70, 20, 18) + 90;
            float rScl = foundBlock() ? Mathf.absin(2, 18) : rotation;
            Draw.color(Pal.gray);
            Drawf.tri(this.x, this.y, 6, 12.5f, r + rScl);
            Drawf.tri(this.x, this.y, 6, 12.5f, r - rScl);
            Drawf.tri(this.x, this.y, 6.5f, 7, r + 180 + rScl + 20);
            Drawf.tri(this.x, this.y, 6.5f, 7, r  + 180 - rScl - 20);
            Draw.color(Pal.heal);
            Drawf.tri(this.x, this.y, 3.5f, 10, r + rScl);
            Drawf.tri(this.x, this.y, 3.5f, 10, r - rScl);
            Drawf.tri(this.x, this.y, 4, 4.5f, r + 180 + rScl + 20);
            Drawf.tri(this.x, this.y, 4, 4.5f, r  + 180 - rScl - 20);
            Draw.color(Pal.gray);
            Fill.square(this.x, this.y, 2, r + 45);
            Draw.color(Pal.engine);
            Fill.square(this.x, this.y, 1.2f, r + 45);
            Draw.color();

        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.f(progress);
            write.f(warmup);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            progress = read.f();
            warmup = read.f();
        }

        public boolean foundBlock() {
            return front().block == targetBlock;
        }

        public void doHoe() {
            for(int i = 0; i < outputItem.amount; i++) offload(outputItem.item);
        }
    }
}
