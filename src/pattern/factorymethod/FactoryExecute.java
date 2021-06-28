package pattern.factorymethod;

public class FactoryExecute {
    public static void main(String[] args) {

        FactoryShape factoryShape = new FactoryShape();

        Shape a = factoryShape.getShapeByType(ShapeTypeEnum.Circle);

        a.draw();

        Shape b = factoryShape.getShapeByType(ShapeTypeEnum.Squre);

        b.draw();
    }
}
