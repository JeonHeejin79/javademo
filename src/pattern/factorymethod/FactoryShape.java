package pattern.factorymethod;

public class FactoryShape {
    public Shape getShapeByType(ShapeTypeEnum shapeTypeEnum) {

        if (shapeTypeEnum == null) {
            return null;
        }

        if (shapeTypeEnum == ShapeTypeEnum.Circle) {
            return new ShapeCircle();
        } else if (shapeTypeEnum == ShapeTypeEnum.Squre) {
            return new ShapeSqure();
        }

        return null;
    }
}
