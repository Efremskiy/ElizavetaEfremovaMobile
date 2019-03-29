package enums;

/**
 * This enum contains data which is common for all test cases.
 */
public enum CommonTestData {
    PROPERTIES_PATH(System.getProperty("user.dir") + "/src/main/resources/");

    private String data;

    CommonTestData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
