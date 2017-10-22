package project.parsdata.com.V;

public class SmsEvent {
    private final String number;
    private final String code;

    public SmsEvent(String number, String code) {
        this.number = number;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }
}
