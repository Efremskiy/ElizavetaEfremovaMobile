package enums;

public enum WebTestData {
    TEST_PAGE_TITLE("Internet Assigned Numbers Authority");

    private String data;

    WebTestData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
