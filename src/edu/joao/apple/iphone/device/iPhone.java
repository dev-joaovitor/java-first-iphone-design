package edu.joao.apple.iphone.device;

import edu.joao.apple.iphone.apps.Contacts;
import edu.joao.apple.iphone.apps.SafariBrowser;
import edu.joao.apple.iphone.apps.iPod;

import java.util.*;

public class iPhone extends SmartPhone implements iPod, SafariBrowser, Contacts {

    // device
    private boolean isUnlocked = false;
    private boolean isOn = false;

    // safari
    private boolean isSafariOpen = false;
    private int safariTabs = 0;

    // ipod
    private boolean isIpodOpen = false;
    private String selectedMusic;
    private boolean isMusicPlaying = false;

    // contacts
    private boolean isContactsOpen = false;
    private boolean isOnCall = false;
    private String selectedContact;
    final private Map<Integer, String> voiceMailList = new HashMap<>();

    private boolean isContactsOpen() {
        return isContactsOpen;
    }

    private void setContactsOpen(boolean contactsOpen) {
        isContactsOpen = contactsOpen;
    }

    private boolean isOnCall() {
        return isOnCall;
    }

    private void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }

    private String getSelectedContact() {
        return selectedContact;
    }

    private void setSelectedContact(String selectedContact) {
        this.selectedContact = selectedContact;
    }

    public void removeVoiceMail(Integer id){
        voiceMailList.remove(id);
    }

    public int getSafariTabs() {
        return safariTabs;
    }

    private boolean isIpodOpen() {
        return isIpodOpen;
    }

    private void setIpodOpen(boolean ipodOpen) {
        isIpodOpen = ipodOpen;
    }

    private String getSelectedMusic() {
        return selectedMusic;
    }

    private void setThereMusicSelected(String musicName) {
        this.selectedMusic = musicName;
    }

    private boolean isMusicPlaying() {
        return isMusicPlaying;
    }

    private void setMusicPlaying(boolean musicPlaying) {
        isMusicPlaying = musicPlaying;
    }


    private boolean isUnlocked() {
        return isUnlocked;
    }

    private void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }

    private boolean isOn() {
        return isOn;
    }

    private void setOn(boolean on) {
        isOn = on;
    }

    private boolean isSafariOpen() {
        return isSafariOpen;
    }

    private void setSafariOpen(boolean safariOpen) {
        isSafariOpen = safariOpen;
    }

    private void setSafariTabs(int safariTabs) {
        this.safariTabs = safariTabs;
    }

    // smartphone
    @Override
    public void turnOn() {
        setOn(true);
        System.out.println("the iphone got turned on");
    }

    @Override
    public void turnOff() {
        if (isContactsOpen() || isSafariOpen() || isIpodOpen()) {
            System.out.println("close all apps before turn off the phone");
            return;
        }
        setOn(false);
        setUnlocked(false);
        System.out.println("the iphone got turned off");
    }

    @Override
    public void unlock() {
        if (isOn()) {
            setUnlocked(true);
            System.out.println("the iphone got unlocked");
            return;
        }
        System.out.println("turn the phone on first");
    }

    //
    // safari
    @Override
    public void openSafari() {
        if (isSafariOpen()) {
            System.out.println("the app is already open");
            return;
        }

        if (isUnlocked()) {
            setSafariOpen(true);
            System.out.println("safari got opened");
        } else {
            System.out.println("the phone is locked");
        }
    }

    @Override
    public void closeSafari() {
        if (isSafariOpen()) {
            System.out.println("safari got closed");
            setSafariOpen(false);
            return;
        }
        System.out.println("safari isn't open to close");
    }

    @Override
    public void openSafariTab() {
        if (isSafariOpen()) {
            setSafariTabs(safariTabs + 1);
            System.out.println("1 more tab opened on safari, tabs opened: " + safariTabs);
            return;
        }
        System.out.println("the app isn't running");
    }

    @Override
    public void closeSafariTab() {
        if (isSafariOpen()) {
            if (getSafariTabs() > 0) {
                setSafariTabs(safariTabs - 1);
                System.out.println("1 safari tab closed, tabs currently opened: " + safariTabs);
            } else {
                System.out.println("there's no tab open");
            }
            return;
        }
        System.out.println("the app isn't running");
    }

    @Override
    public void internetSearch(String searchParams) {
        if (isSafariOpen()) {
            if (getSafariTabs() == 0){
                System.out.println("open at least 1 tab before search");
                return;
            }
            System.out.println("you searched for: " + searchParams);
            return;
        }
        System.out.println("the app isn't running");
    }

    //
    // ipod
    @Override
    public void openIpod() {
        if (isOn() && isUnlocked()) {
            setIpodOpen(true);
            System.out.println("opened ipod app");
            return;
        }
        System.out.println("you need to turn the phone on and unlock it");
    }

    @Override
    public void closeIpod() {
        if (isOn()) {
            setIpodOpen(false);
            System.out.println("closed ipod app");
            return;
        }
        System.out.println("turn the phone on");
    }

    @Override
    public void selectArtist(String artistName) {
        System.out.println("artist selected: " + artistName);
    }

    @Override
    public void selectAlbum(String albumName) {
        System.out.println("album selected: " + albumName);
    }

    @Override
    public void selectMusic(String musicName) {
        System.out.println("music selected: " + musicName);
        setThereMusicSelected(musicName);
    }

    public void deselectMusic() {
        System.out.println("deselecting music");
        setThereMusicSelected(null);
    }

    @Override
    public void playMusic() {
        if (getSelectedMusic() != null) {
            System.out.println("playing music: " + getSelectedMusic());
            setMusicPlaying(true);
            return;
        }
        System.out.println("there's no music selected");
    }

    @Override
    public void pauseMusic() {
        if (getSelectedMusic() != null && isMusicPlaying()) {
            System.out.println("pausing music: " + getSelectedMusic());
            setMusicPlaying(false);
            return;
        }
        System.out.println("there's no music selected");
    }

    //
    // contacts
    @Override
    public void openContacts() {
        if (isOn() && !isContactsOpen() && isUnlocked()) {
            System.out.println("contacts app opened");
            setContactsOpen(true);
            return;
        }
        System.out.println("you need to turn the phone on and unlock it");
    }

    @Override
    public void closeContacts() {
        if (isContactsOpen()) {
            System.out.println("contacts closed");
            setContactsOpen(false);
            return;
        }
        System.out.println("contacts isn't open");
    }

    @Override
    public void selectContact(String contactName) {
        if (isContactsOpen()) {
            System.out.println("contact: " + contactName + " selected");
            setSelectedContact(contactName);
            return;
        }
        System.out.println("open the contacts app first");
    }

    @Override
    public void call() {
        if (isContactsOpen() && getSelectedContact().length() > 0) {
            System.out.println("calling to: " + getSelectedContact());
            setOnCall(true);
            System.out.println("connected");
            return;
        }
        System.out.println("you must open contacts app and select a contact first");
    }

    @Override
    public void endCall() {
        if (isOnCall()) {
            System.out.println("call is ended");
            setSelectedContact(null);
            return;
        }
        System.out.println("there's no call going on");
    }

    @Override
    public void getVoiceMailList() {
        System.out.println(voiceMailList);
    }

    @Override
    public void listenToVoiceMail(Integer id) {
        String contact = voiceMailList.get(id);

        if (contact.length() > 0){
            System.out.println("listening to voicemail by: " + voiceMailList.get(id));
            removeVoiceMail(id);
            return;
        }
        System.out.println("there's no voicemail with this id");
    }

    public void addVoiceMailToList(Integer id, String contactName) {
        voiceMailList.put(id, contactName);
    }
}
