package game.engine.physics;


import game.engine.myutils.Matrix;


public class ContactConstraint extends AbstractConstraint {
    private CollisionInfo c;
    private float dt;

    public ContactConstraint(IPhysicsObject po1, IPhysicsObject po2, CollisionInfo c, float dt) {
        super(po1, po2);
        this.c = c;
        this.dt = dt;
        totalImpulse = new Matrix(1/*c.getCollisionType().getIndex() + 1*/, 1);
    }

    @Override
    protected Matrix createJacobian() {
//        return PhysicsMatrixUtils.createCollisionJacobian(c);
        return PhysicsMatrixUtils.createSimpleJacobian(c.getNormal(), c.getContactVector(0), c.getContactVector(1));
    }

    private Matrix calculateAdjustment() {
        int rowCount = 1;//c.getCollisionType().getIndex() + 1;

        Matrix answ = new Matrix(rowCount, 1);

        Matrix d1 = po2.getV().minusEq(po1.getV());
        Matrix av1 = new Matrix(1, 3);
        av1.set(2, po1.getAV());
        Matrix av2 = new Matrix(1, 3);
        av2.set(2, po2.getAV());

        for (int i = 0; i < rowCount; i++) {
            Matrix d2 = Matrix.getCrossProduct(av2, Matrix.convert(c.getContactVector(i * 2 + 1))).minusEq(Matrix.getCrossProduct(av1, Matrix.convert(c.getContactVector(i * 2))));

            float v = Matrix.getScalarProduct(Matrix.convert(d1).plusEq(d2), Matrix.convert(c.getNormal()));
            answ.set(i, v * 0.8f);
        }

        return answ;
    }

    @Override
    protected Matrix createB() {
        int rowCount = 1;//c.getCollisionType().getIndex() + 1;
        Matrix b = new Matrix(rowCount, 1);
        for (int i = 0; i < rowCount; i++) {
            b.set(i, -Math.max(c.getPenetrationDepth() - 0.5f, 0) * (1f / dt) * 0.1f);
        }
        b.plus(calculateAdjustment());
        return b;
    }

    @Override
    protected float clamp(float lyambda) {
        return lyambda < 0 ? 0 : lyambda;
    }

    @Override
    protected Matrix clamp(Matrix lyambda) {
        for (int i = 0; i < lyambda.maxOfSizes(); i++) {
            if (lyambda.get(i) < 0f) {
//                lyambda.set(i, 0f);
                return new Matrix(lyambda.rowCount(), lyambda.columnCount());
            }
        }
        return lyambda;
    }

    public static class CollisionInfo {
        private Matrix[] contactVectors = new Matrix[2];
        private Matrix normal;
        private float penetrationDepth;

        public CollisionInfo(Matrix n, Matrix r1, Matrix r2, float penetrationDepth) {
            contactVectors[0] = r1;
            contactVectors[1] = r2;
            normal = n;
            this.penetrationDepth = penetrationDepth;
        }

        public Matrix getContactVector(int i) {
            return contactVectors[i];
        }

        public Matrix getNormal() {
            return normal;
        }

        public float getPenetrationDepth() {
            return penetrationDepth;
        }
    }
}
