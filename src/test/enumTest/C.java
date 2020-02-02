package test.enumTest;

public enum C {
    INSTANCE_1(1);

    private int code;

    C(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
