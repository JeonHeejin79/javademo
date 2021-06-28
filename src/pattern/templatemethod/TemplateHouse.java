package pattern.templatemethod;

public abstract class TemplateHouse {

    public final void buildHouse() {

        // 기능
        buildFoundation();
        buildWalls();
        buildWindows();
        buildDoors();
    }

    // 필수 기능1 : 기초공사
    private void buildFoundation() {
        System.out.println("build house foundation");
    }

    // 필수 기능2 : 벽공사
    private void buildWalls() {
        System.out.println("build house walls");
    }
    

    // 각자알아서 해야되는 기능 > 서브클래스가 알아서구현
    protected abstract void buildWindows();

    protected abstract void buildDoors();

}
