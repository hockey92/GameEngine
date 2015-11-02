package test;

import game.engine.geometry.GeometryObject;
import game.engine.physics.PhysicsHandler;
import game.engine.physics.PhysicsObject;
import game.engine.gamefield.Drawable;
import game.engine.gamefield.GameField;
import game.engine.geometry.figures.ShapeFactory;
import game.engine.myutils.Matrix;

import java.util.ArrayList;
import java.util.List;

public class PhysicsObjectTest {
    public static void main(String args[]) throws Exception {
        List<Drawable> gameObjects = new ArrayList<Drawable>();
        PhysicsHandler physicsHandler = new PhysicsHandler();

        float[] xs1 = {-50f, 50f, -50f};
        float[] ys1 = {-50f, -50f, 50f};

        float[] xs2 = {-50f, 50f, -50f};
        float[] ys2 = {-50f, -50f, 50f};

        float invM = 0.001f;
        int n = 30;

        PhysicsObject pos[] = new PhysicsObject[n];

        for (int i = 0; i < n; i++) {
            pos[i] = (new PhysicsObject.PhysicsObjectBuilder())
                    .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(50f, 50f, 100 + 5 * i, 200 + (i / 50) * 70, 0.5f), null))
                    .setV(Matrix.createCoords(4f, 0f))
                    .setA(Matrix.createCoords(0f, 0.05f))
                    .setAV(0)
                    .setInvM(1f)
                    .setInvI(invM)
                    .createPhysicsObject();
        }

//        PhysicsObject.PhysicsObjectBuilder builder = (new PhysicsObject.PhysicsObjectBuilder())
//                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(100f, 100f, 300f, 200f, 0.5f), null))
//                .setV(Matrix.createCoords(4f, 0f))
//                .setA(Matrix.createCoords(0f, 0.05f))
//                .setAV(0)
//                .setInvM(1f)
//                .setInvI(invM);
//
//        PhysicsObject.PhysicsObjectBuilder builder2 = (new PhysicsObject.PhysicsObjectBuilder())
//                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(100f, 100f, 300f, 200f, 0.5f), null))
//                .setV(Matrix.createCoords(4f, 0f))
//                .setA(Matrix.createCoords(0f, 0.05f))
//                .setAV(0)
//                .setInvM(1f)
//                .setInvI(invM);
//
//        PhysicsObject.PhysicsObjectBuilder builder3 = (new PhysicsObject.PhysicsObjectBuilder())
//                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(100f, 100f, 300f, 200f, 0.5f), null))
//                .setV(Matrix.createCoords(4f, 0f))
//                .setA(Matrix.createCoords(0f, 0.05f))
//                .setAV(0)
//                .setInvM(1f)
//                .setInvI(invM);
//
//        PhysicsObject.PhysicsObjectBuilder builder4 = (new PhysicsObject.PhysicsObjectBuilder())
//                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(100f, 100f, 300f, 200f, 0.5f), null))
//                .setV(Matrix.createCoords(4f, 0f))
//                .setA(Matrix.createCoords(0f, 0.05f))
//                .setAV(0)
//                .setInvM(1f)
//                .setInvI(invM);
//
//        PhysicsObject.PhysicsObjectBuilder builder5 = (new PhysicsObject.PhysicsObjectBuilder())
//                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(100f, 100f, 300f, 200f, 0.5f), null))
//                .setV(Matrix.createCoords(4f, 0f))
//                .setA(Matrix.createCoords(0f, 0.05f))
//                .setAV(0)
//                .setInvM(1f)
//                .setInvI(invM);

        PhysicsObject.PhysicsObjectBuilder gPlatformBuilder = (new PhysicsObject.PhysicsObjectBuilder())
                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(3000f, 10f, 500f, 550f, 0f), null))
                .setV(Matrix.createCoords(0f, 0f))
                .setA(Matrix.createCoords(0f, 0f))
                .setAV(0f);

        PhysicsObject.PhysicsObjectBuilder gPlatformBuilder2 = (new PhysicsObject.PhysicsObjectBuilder())
                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(3000f, 10f, 500f, 20f, 0f), null))
                .setV(Matrix.createCoords(0f, 0f))
                .setA(Matrix.createCoords(0f, 0f))
                .setAV(0f);

        PhysicsObject.PhysicsObjectBuilder vPlatformBuilder = (new PhysicsObject.PhysicsObjectBuilder())
                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(10f, 3000f, 600f, 300f, 0f), null))
                .setV(Matrix.createCoords(0f, 0f))
                .setA(Matrix.createCoords(0f, 0f))
                .setAV(0f);

        PhysicsObject.PhysicsObjectBuilder vPlatformBuilder2 = (new PhysicsObject.PhysicsObjectBuilder())
                .setGeometryObject(new GeometryObject(ShapeFactory.createRectangle(10f, 3000f, 20f, 300f, 0f), null))
                .setV(Matrix.createCoords(0f, 0f))
                .setA(Matrix.createCoords(0f, 0f))
                .setAV(0f);

//        PhysicsObject po1 = builder.createPhysicsObject();
//        PhysicsObject po2 = builder2.createPhysicsObject();
//        PhysicsObject po3 = builder3.createPhysicsObject();
//        PhysicsObject po4 = builder4.createPhysicsObject();
//        PhysicsObject po5 = builder5.createPhysicsObject();
        PhysicsObject gPlatform = gPlatformBuilder.createPhysicsObject();
        gPlatform.getGeometryObject().rotate(0.2f);
        PhysicsObject gPlatform2 = gPlatformBuilder2.createPhysicsObject();
        PhysicsObject vPlatform = vPlatformBuilder.createPhysicsObject();
        PhysicsObject vPlatform2 = vPlatformBuilder2.createPhysicsObject();

//        Collision collision1 = new Collision(po1.getGeometryObject(), gPlatform.getGeometryObject());
//        Collision collision2 = new Collision(po2.getGeometryObject(), vPlatform.getGeometryObject());

//        gameObjects.add(po1);
//        gameObjects.add(po2);
//        gameObjects.add(po3);
//        gameObjects.add(po4);
//        gameObjects.add(po5);
        gameObjects.add(gPlatform);
        gameObjects.add(gPlatform2);
        gameObjects.add(vPlatform);
        gameObjects.add(vPlatform2);
//        gameObjects.add(collision1);
//        gameObjects.add(collision2);

//        physicsHandler.addObject(po1);
//        physicsHandler.addObject(po2);
//        physicsHandler.addObject(po3);
//        physicsHandler.addObject(po4);
//        physicsHandler.addObject(po5);
        physicsHandler.addObject(gPlatform);
        physicsHandler.addObject(gPlatform2);
        physicsHandler.addObject(vPlatform);
        physicsHandler.addObject(vPlatform2);

        for (int i = 0; i < n; i++) {
            physicsHandler.addObject(pos[i]);
            gameObjects.add(pos[i]);
        }

        SimpleGameContextImpl contextImp = new SimpleGameContextImpl();
        GameField gameField = new GameField(contextImp);
        gameField.setObjectsToDraw(gameObjects);

        Thread renderThread = new Thread(gameField);
        renderThread.start();

        Thread physicsThread = new Thread(physicsHandler);
        physicsThread.start();

//        while(true) {
//            collision1.calculateCollision(po1.getGeometryObject().getShape(), gPlatform.getGeometryObject().getShape());
//            collision2.calculateCollision(po1.getGeometryObject().getShape(), vPlatform.getGeometryObject().getShape());
//            Thread.sleep(2);
//        }
    }
}