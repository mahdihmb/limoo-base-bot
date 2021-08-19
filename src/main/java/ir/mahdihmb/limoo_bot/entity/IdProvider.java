package ir.mahdihmb.limoo_bot.entity;

import java.io.Serializable;

public interface IdProvider {

    Serializable getId();

    void setId(Serializable id);
}
