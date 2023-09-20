package edu.joao.apple.iphone.user;

import edu.joao.apple.iphone.device.iPhone;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static void main(String[] args) {
        List<String> contactList = new ArrayList<>();

        contactList.add("Joao");
        contactList.add("Mica");
        contactList.add("Matheus");
        contactList.add("Andrew");
        contactList.add("Finn");
        contactList.add("Jimmy");

        iPhone myIphone = new iPhone();

        // device
        myIphone.unlock();
        myIphone.turnOn();
        myIphone.unlock();
        System.out.println("\n");

        // safari browser
        myIphone.openSafariTab();
        myIphone.openSafari();
        myIphone.openSafariTab();
        myIphone.closeSafariTab();
        myIphone.internetSearch("java 8 documentation");
        myIphone.openSafariTab();
        myIphone.internetSearch("java 8 documentation");
        myIphone.closeSafari();
        System.out.println("\n");

        // ipod music
        myIphone.openIpod();
        myIphone.selectArtist("tyler the creator");
        myIphone.selectAlbum("call me if you get lost");
        myIphone.playMusic();
        myIphone.selectMusic("lumberjack");
        myIphone.playMusic();
        myIphone.pauseMusic();
        myIphone.deselectMusic();
        myIphone.playMusic();
        System.out.println("\n");

        // contacts
        myIphone.call();
        myIphone.openContacts();
        myIphone.endCall();

        for (String contact: contactList){
            myIphone.selectContact(contact);
            myIphone.call();
            myIphone.endCall();
        }
        myIphone.closeContacts();

        myIphone.addVoiceMailToList(1, "joao");
        myIphone.addVoiceMailToList(2, "mica");
        myIphone.addVoiceMailToList(3, "matheus");
        myIphone.addVoiceMailToList(4, "vitor");
        myIphone.getVoiceMailList();
        myIphone.listenToVoiceMail(2);
        myIphone.listenToVoiceMail(3);
        myIphone.getVoiceMailList();

        System.out.println("\n");

        myIphone.turnOff();
        myIphone.closeIpod();
        myIphone.turnOff();
        myIphone.unlock();
    }
}
