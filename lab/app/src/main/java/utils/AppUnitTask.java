package utils;

public abstract class AppUnitTask extends Runner {
    @Override
    public String getUnit() {
        return "app";
    }

    @Override
    public int getId() {
        return 0;
    }
}
