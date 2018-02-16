package tw.edu.yuntech.yunnet.utils;

public enum EnumLoginMode {

    LibServer("LibServer"), ActiveDirectory("ActiveDirectory");

    private String value;

    EnumLoginMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
