package seminar_7.singleton;
/*порождающий паттерн*/
public class Settings {
    private static Settings instance;
    private String param1;
    private int param2;



    Settings(){

    }

    public String getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }
}
