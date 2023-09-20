package edu.joao.apple.iphone.apps;

public interface Contacts {
    void openContacts();
    void closeContacts();
    void selectContact(String contactName);
    void call();
    void endCall();
}
