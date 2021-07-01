package com.google;

import java.util.*;

public class VideoPlayer {

    private final VideoLibrary videoLibrary;

    private Map<String, VideoPlaylist> playlists = new HashMap<>();
    private String vId;
    private String playingNow;
    private boolean onPause = false;
    private boolean stopped = false;

    public VideoPlayer() {
        this.videoLibrary = new VideoLibrary();
    }

    public void numberOfVideos() {
        System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
    }

    public void showAllVideos() {
        System.out.println("Here's a list of all available videos:");
        List<Video> videos = videoLibrary.getVideos();

        videos.sort(Comparator.comparing(Video::getTitle));

        for (Video video : videos) {
            System.out.print(video.getTitle() + " (" + video.getVideoId() + ") [");
            printVideo(video);
        }
    }

    public void playVideo(String videoId) {
        Video video = videoLibrary.getVideo(videoId);
        if (video == null) {
            System.out.println("Cannot play video: Video does not exist");
        } else if (playingNow == null) {
            playingNow = video.getTitle();
            vId = video.getVideoId();
            System.out.println("Playing video: " + video.getTitle());
        } else {
            stopVideo();
            playingNow = video.getTitle();
            vId = video.getVideoId();
            System.out.println("Playing video: " + playingNow);
            onPause = false;

        }
    }

    public void stopVideo() {
        if (playingNow == null) {
            System.out.println("Cannot stop video: No video is currently playing");
        } else if (!stopped) {
            System.out.println("Stopping video: " + playingNow);
            stopped = true;
            playingNow = null;
        } else System.out.println("Video already stopped: " + playingNow);
    }

    public void playRandomVideo() {
        Random random = new Random();
        int rndInt = random.nextInt(videoLibrary.getVideos().size());
        List<Video> videos = videoLibrary.getVideos();
        playVideo(videos.get(rndInt).getVideoId());
        onPause = false;
    }

    public void pauseVideo() {
        if (playingNow == null) {
            System.out.println("Cannot pause video: No video is currently playing");
        } else if (!onPause) {
            System.out.println("Pausing video: " + playingNow);
            onPause = true;
        } else System.out.println("Video already paused: " + playingNow);
    }

    public void continueVideo() {
        if (playingNow == null) {
            System.out.println("Cannot continue video: No video is currently playing");
        } else if (!onPause) {
            System.out.println("Cannot continue video: Video is not paused");
        } else System.out.println("Continuing video: " + playingNow);
    }

    public void showPlaying() {
        Video video = videoLibrary.getVideo(vId);
        if (video == null) {
            System.out.println("No video is currently playing");
        } else {
            System.out.print("Currently playing: " +
                    video.getTitle() + " (" + video.getVideoId() + ") [");
            printVideo(video);
        }
    }

    private void printVideo(Video video) {
        List<String> tags = video.getTags();
        for (int i = 0; i < tags.size(); i++) {
            System.out.print(tags.get(i));
            if ((i + 1) < tags.size()) System.out.print(" ");
        }
        System.out.print("]");
        System.out.println((onPause) ? " - PAUSED" : "");
    }

    public void createPlaylist(String playlistName) {
        String name = playlistName.toLowerCase();
        if (playlists.containsKey(name)) {
            System.out.println("Cannot create playlist: A playlist with the same name already exists");
        } else {
            playlists.put(playlistName, new VideoPlaylist(name));
            System.out.println("Successfully created new playlist: " + playlistName);
        }
    }

    public void addVideoToPlaylist(String playlistName, String videoId) {
        System.out.println("addVideoToPlaylist needs implementation");
    }

    public void showAllPlaylists() {
        System.out.println("showAllPlaylists needs implementation");
    }

    public void showPlaylist(String playlistName) {
        System.out.println("showPlaylist needs implementation");
    }

    public void removeFromPlaylist(String playlistName, String videoId) {
        System.out.println("removeFromPlaylist needs implementation");
    }

    public void clearPlaylist(String playlistName) {
        System.out.println("clearPlaylist needs implementation");
    }

    public void deletePlaylist(String playlistName) {
        System.out.println("deletePlaylist needs implementation");
    }

    public void searchVideos(String searchTerm) {
        System.out.println("searchVideos needs implementation");
    }

    public void searchVideosWithTag(String videoTag) {
        System.out.println("searchVideosWithTag needs implementation");
    }

    public void flagVideo(String videoId) {
        System.out.println("flagVideo needs implementation");
    }

    public void flagVideo(String videoId, String reason) {
        System.out.println("flagVideo needs implementation");
    }

    public void allowVideo(String videoId) {
        System.out.println("allowVideo needs implementation");
    }
}