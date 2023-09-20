package edu.joao.apple.iphone.apps;

public interface iPod {
    void openIpod();
    void closeIpod();
    void selectArtist(String artistName);
    void selectAlbum(String albumName);
    void selectMusic(String musicName);
    void deselectMusic();
    void playMusic();
    void pauseMusic();
}
