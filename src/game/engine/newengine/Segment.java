package game.engine.newengine;

import game.engine.gamefield.IDrawContext;

public class Segment extends AbstractShape {
    private Vec2[] coords = new Vec2[2];

    public Segment(Vec2 point1, Vec2 point2) {
        coords[0] = point1;
        coords[1] = point2;
        aabb = new AABB(this);
    }

    public Vec2 getCoord(int i) {
        return centerCoords.plusEq(coords[i]);
    }

    @Override
    public void rotate(float angle) {
        for (Vec2 vertex : coords) {
            vertex.rotate(angle);
        }
    }

    @Override
    public void draw(IDrawContext drawContext) {
        Vec2 p1 = getCoord(0);
        Vec2 p2 = getCoord(1);
        drawContext.drawLine(p1.x() * 100f, p1.y() * 100f, p2.x() * 100f, p2.y() * 100f);

//        if (aabb != null) {
//            aabb.draw(drawContext);
//        }

    }
}
