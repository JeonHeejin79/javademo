package pattern.templatemethod;

public class GlassHouse extends TemplateHouse{
    @Override
    public void buildWindows() {
        System.out.println("build glass house windows");
    }

    @Override
    public void buildDoors() {
        System.out.println("build glass house doors");
    }
}
