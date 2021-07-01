package com.google;

import java.util.ArrayList;
import java.util.List;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private final String name;
    private List<Video> videos;

    public VideoPlaylist(String name) {
        this.name = name;
        this.videos = new ArrayList<>();
    }
}
