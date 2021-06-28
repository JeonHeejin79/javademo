package pattern.templatemethod;

public class WoodHouse extends TemplateHouse {

    @Override
    public void buildWindows() {
        System.out.println("build wood house window");
    }

    @Override
    public void buildDoors() {
        System.out.println("build wood house doors");
    }
}
