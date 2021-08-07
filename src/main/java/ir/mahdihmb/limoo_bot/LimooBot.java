package ir.mahdihmb.limoo_bot;

import ir.limoo.driver.LimooDriver;
import ir.limoo.driver.entity.Conversation;
import ir.limoo.driver.entity.Message;
import ir.limoo.driver.event.AddToConversationEventListener;
import ir.limoo.driver.event.MessageCreatedEventListener;
import ir.limoo.driver.exception.LimooException;
import ir.mahdihmb.limoo_bot.core.HibernateSessionManager;
import ir.mahdihmb.limoo_bot.core.MessageService;
import ir.mahdihmb.limoo_bot.dao.TestDAO;
import ir.mahdihmb.limoo_bot.entity.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LimooBot {

    private static final transient Logger logger = LoggerFactory.getLogger(LimooBot.class);

    private final LimooDriver limooDriver;

    public LimooBot(String limooUrl, String botUsername, String botPassword) throws LimooException {
        limooDriver = new LimooDriver(limooUrl, botUsername, botPassword);
    }

    public void run() {
        limooDriver.addEventListener(new MessageCreatedEventListener() {
            @Override
            public void onNewMessage(Message message, Conversation conversation) {
                HibernateSessionManager.openSession();
                try {
                    if (message.getThreadRootId() == null) {
                        List<Test> tests = TestDAO.getInstance().list();
                        if (tests == null || tests.isEmpty()) {
                            String text = MessageService.get("testMsg");
                            Test test = new Test(text, 10);
                            TestDAO.getInstance().add(test);
                            message.sendInThread(text);
                        } else {
                            Test test = tests.get(0);
                            message.sendInThread(test.getStrField());
                        }
                    }
                } catch (LimooException e) {
                    logger.error("", e);
                } finally {
                    HibernateSessionManager.closeCurrentSession();
                    conversation.viewLog();
                }
            }
        });

        limooDriver.addEventListener(new AddToConversationEventListener() {
            @Override
            public void onAddToConversation(Conversation conversation) {
                // do something
            }
        });
    }

}
