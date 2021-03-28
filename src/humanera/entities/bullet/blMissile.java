package humanera.entities.bullet;

import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Bullet;
import mindustry.world.blocks.defense.turrets.Turret;

public class blMissile extends BasicBulletType {
    public float maxDamage = damage * 2;
    public float accelScl = 1;
    public float bullDst;
    public Vec2 ownerTargetVec;
    public blMissile(float speed, float damage){
        this.speed = speed;
        this.damage = damage;
        hitEffect = Fx.blockExplosionSmoke;
        despawnEffect = Fx.massiveExplosion;
    }

    @Override
    public void update(Bullet b) {
        float bulletRange = speed * lifetime * (1f - drag);
        super.update(b);
        if(b.owner() != null && b.owner() instanceof Turret.TurretBuild){
            Vec2 ownerTargetVec = ((Turret.TurretBuild)b.owner()).targetPos;
        }

        bullDst = Mathf.dst(ownerTargetVec.x, ownerTargetVec.y, b.x, b.y);

        if (bullDst <= 0.5*bulletRange){
            b.vel().scl(0.98f * Time.delta);
        }else{
            b.vel().scl(1.035f * Time.delta);
        }
    }

    @Override
    public void hit(Bullet b, float x, float y){
        float scl1 = b.vel().len();
        b.damage += Math.min(maxDamage, accelScl * scl1 * scl1);
        super.hit(b,x,y);
    }
}
