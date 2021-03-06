package ir.mahdihmb.limoo_bot.core;

public class CoreManager {

    public static void initApp() {
        try {
            ConfigService.init();
            MessageService.init();
            DataSourceManager.init();
            FlywayManager.init();
            FlywayManager.migrate();
            HibernateSessionManager.init();
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }

    public static void initFlywayOnly() {
        try {
            ConfigService.init();
            DataSourceManager.init();
            FlywayManager.init();
        } catch (Throwable throwable) {
            throw new ExceptionInInitializerError(throwable);
        }
    }

}
