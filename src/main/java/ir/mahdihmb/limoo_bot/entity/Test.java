package ir.mahdihmb.limoo_bot.entity;

public class Test {

    private long id;
    private String strField;
    private Integer intField;

    public Test() {
        // an empty constructor is needed for hibernate
    }

    public Test(String strField, Integer intField) {
        this.strField = strField;
        this.intField = intField;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStrField() {
        return strField;
    }

    public void setStrField(String strField) {
        this.strField = strField;
    }

    public Integer getIntField() {
        return intField;
    }

    public void setIntField(Integer intField) {
        this.intField = intField;
    }
}
