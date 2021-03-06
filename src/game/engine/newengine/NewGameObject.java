package game.engine.newengine;

import game.engine.gamefield.IDrawContext;
import game.engine.gamefield.IDrawable;

public class NewGameObject implements IDrawable {

    private IShape shape;
    private float invM;
    private float invI = 0;
    private Vec2 vel = new Vec2(0, 0);
    private Vec2 acc = new Vec2(0, 0);
    private float angleVel = 0f;

    public NewGameObject(IShape shape, float invM) {
        this.shape = shape;
        this.invM = invM;
    }

    public NewGameObject setAcceleration(Vec2 acc) {
        this.acc = acc;
        return this;
    }

    public Vec2 getVel() {
        return vel;
    }

    public IShape getShape() {
        return shape;
    }

    public float getInvM() {
        return invM;
    }

    public float getInvI() {
        return invI;
    }

    public void setVel(Vec2 vel) {
        this.vel = vel;
    }

    public void setAngleVel(float angleVel) {
        this.angleVel = angleVel;
    }

    public float getAngleVel() {
        return angleVel;
    }

    public void updateVel(float dt) {
        vel.plus(acc.mulEq(dt));
    }

    public void updatePos(float dt) {
        shape.rotate(angleVel * dt);
        shape.move(vel.mulEq(dt));
    }

    public void applyImpulse(Vec2 dVel, float dAngleVel) {
        vel.plus(dVel);
//        angleVel += dAngleVel;
    }

    public void update() {

    }

    @Override
    public void draw(IDrawContext drawContext) {
        shape.draw(drawContext);
    }
}
