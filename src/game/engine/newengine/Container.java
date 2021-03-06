package game.engine.newengine;

import game.engine.gamefield.IDrawContext;

import java.util.ArrayList;
import java.util.List;

public class Container extends AbstractShape {

    private List<IShape> segments = new ArrayList<IShape>();
    private boolean isOpen = false;

    public Container() {
        segments.add(new Segment(new Vec2(-1.50f, -0.80f), new Vec2(-1.50f, 0.20f)));
        segments.add(new Segment(new Vec2(-1.50f, 0.20f), new Vec2(-0.12f, 0.90f)));
        segments.add(new Segment(new Vec2(-0.12f, 0.90f), new Vec2(-0.12f, 1.15f)));

        segments.add(new Segment(new Vec2(-0.12f, 1.15f), new Vec2(0.12f, 1.15f)));

        segments.add(new Segment(new Vec2(0.12f, 1.15f), new Vec2(0.12f, 0.90f)));
        segments.add(new Segment(new Vec2(0.12f, 0.90f), new Vec2(1.50f, 0.20f)));
        segments.add(new Segment(new Vec2(1.50f, 0.20f), new Vec2(1.50f, -0.80f)));
//        segments.add(new Segment(new Vec2(1.00f, -0.80f), new Vec2(-1.00f, -0.80f)));

    }

    public void open() {
        if (isOpen) {
            segments.get(3).move(new Vec2(0.40f, 0f));
        } else {
            segments.get(3).move(new Vec2(-0.40f, 0f));
        }
        isOpen = !isOpen;
    }

    @Override
    public void move(Vec2 coords) {
        super.move(coords);
        for (IShape segment : segments) {
            segment.move(coords);
        }
    }

    @Override
    public void rotate(float angle) {
        for (IShape shape : getSimpleShapes()) {
            shape.rotate(angle);
        }
    }

    @Override
    public void draw(IDrawContext drawContext) {
        for (IShape segment : segments) {
            segment.draw(drawContext);
        }
    }

    @Override
    public List<IShape> getSimpleShapes() {
        return segments;
    }
}
