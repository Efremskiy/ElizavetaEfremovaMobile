package enums;

public enum NativeTestData {
    ADD_CONTACT_BUTTON("addContactButton"),
    TARGET_ACCOUNT("accountSpinner"),
    CONTACT_NAME("contactNameEditText"),
    CONTACT_PHONE("contactPhoneEditText"),
    CONTACT_EMAIL("contactEmailEditText"),
    SAVE_BUTTON("contactSaveButton");

    private String data;

    NativeTestData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
