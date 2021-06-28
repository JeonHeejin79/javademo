package pattern.templatemethod;

public class TemplateExecute {

    public static void main(String[] args) {
        TemplateHouse h1 = new GlassHouse();

        h1.buildHouse();

        System.out.println("==================================");
        h1 = new WoodHouse();

        h1.buildHouse();
    }
}
