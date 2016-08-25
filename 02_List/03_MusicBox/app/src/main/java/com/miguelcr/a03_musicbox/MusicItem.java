package com.miguelcr.a03_musicbox;

/**
 * Created by miguelcampos on 25/8/16.
 */
public class MusicItem {
    private int icon;
    private String name;
    private int sound;

    public MusicItem(int icon, String name, int sound) {
        this.icon = icon;
        this.name = name;
        this.sound = sound;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
