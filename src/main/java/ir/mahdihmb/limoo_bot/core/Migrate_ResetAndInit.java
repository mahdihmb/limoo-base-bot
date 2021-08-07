package ir.mahdihmb.limoo_bot.core;

public class Migrate_ResetAndInit {

    private Migrate_ResetAndInit() {
    }

    public static void main(String[] args) {
        CoreManager.initFlywayOnly();
        FlywayManager.clean();
        FlywayManager.migrate();
    }
}
