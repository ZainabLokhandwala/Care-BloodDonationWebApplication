package com.med.care.domain;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message implements Comparable<Message> {

    @Id
    protected int id;
    protected String content;
    @ManyToOne
    @JoinColumn(name = "sender")
    protected User sender;
    @ManyToOne
    @JoinColumn(name = "receiver")
    protected User receiver;
    @Column(name = "date_time")
    protected long dateTime;

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public int compareTo(Message o) {

        Integer id = new Integer(getId());
        Integer otherId = new Integer(o.getId());
        return id.compareTo(otherId);
//        if (id > otherId) {
//            return -1;
//        } else if (id < otherId) {
//            return 1;
//        } else {
//
//            return 0;
//        }
    }
}
