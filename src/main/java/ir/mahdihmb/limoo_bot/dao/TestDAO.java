package ir.mahdihmb.limoo_bot.dao;

import ir.mahdihmb.limoo_bot.entity.Test;

public class TestDAO extends BaseDAO<Test> {

    private static final Class<Test> persistentClass = Test.class;
    private static TestDAO instance;

    private TestDAO() {
        super(persistentClass);
    }

    public static TestDAO getInstance() {
        if (instance == null)
            instance = new TestDAO();
        return instance;
    }

    // other custom methods here
}
