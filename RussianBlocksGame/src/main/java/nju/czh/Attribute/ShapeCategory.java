package nju.czh.Attribute;

public enum ShapeCategory {
    L(ShapePositions.positionsL),
    J(ShapePositions.positionsJ),
    I(ShapePositions.positionsI),
    SQUARE(ShapePositions.positionsSquare),
    STRANGE(ShapePositions.positionsStrange),
    Z(ShapePositions.positionsZ),
    REVERSE_Z(ShapePositions.positionsRZ);
    final private Position[][] positions;

    ShapeCategory(Position[][] positions) {
        this.positions = positions;
    }

    public Position[] getPositions(int index) {
        return positions[index];
    }

}

class ShapePositions {
    final static Position[][] positionsL = {
            {new Position(0, 0), new Position(1, 0), new Position(2, 0), new Position(2, 1)},
            {new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(1, 0)},
            {new Position(0, 0), new Position(0, 1), new Position(1, 1), new Position(2, 1)},
            {new Position(0, 2), new Position(1, 0), new Position(1, 1), new Position(1, 2)}};

    final static Position[][] positionsJ = {
            {new Position(0, 1), new Position(1, 1), new Position(2, 1), new Position(2, 0)},
            {new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(1, 2)},
            {new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(2, 0)},
            {new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(1, 2)}};

    final static Position[][] positionsI = {
            {new Position(0, 0), new Position(1, 0), new Position(2, 0), new Position(3, 0)},
            {new Position(0, -2), new Position(0, -1), new Position(0, 0), new Position(0, 1)},
            {new Position(0, 0), new Position(1, 0), new Position(2, 0), new Position(3, 0)},
            {new Position(0, -1), new Position(0, 0), new Position(0, 1), new Position(0, 2)}};

    final static Position[][] positionsSquare = {
            {new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1)},
            {new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1)},
            {new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1)},
            {new Position(0, 0), new Position(0, 1), new Position(1, 0), new Position(1, 1)}};

    final static Position[][] positionsStrange = {
            {new Position(0, 0), new Position(1, 0), new Position(1, 1), new Position(2, 0)},
            {new Position(0, 0), new Position(0, 1), new Position(0, 2), new Position(1, 1)},
            {new Position(0, 1), new Position(1, 1), new Position(2, 1), new Position(1, 0)},
            {new Position(0, 1), new Position(1, 0), new Position(1, 1), new Position(1, 2)}};

    final static Position[][] positionsZ = {
            {new Position(0,0),new Position(0,1),new Position(1,1),new Position(1,2)},
            {new Position(0,1),new Position(1,0),new Position(1,1),new Position(2,0)},
            {new Position(0,0),new Position(0,1),new Position(1,1),new Position(1,2)},
            {new Position(0,1),new Position(1,0),new Position(1,1),new Position(2,0)}};

    final static Position[][] positionsRZ = {
            {new Position(0,1),new Position(0,2),new Position(1,0),new Position(1,1)},
            {new Position(0,0),new Position(1,0),new Position(1,1),new Position(2,1)},
            {new Position(0,1),new Position(0,2),new Position(1,0),new Position(1,1)},
            {new Position(0,0),new Position(1,0),new Position(1,1),new Position(2,1)}};
}


