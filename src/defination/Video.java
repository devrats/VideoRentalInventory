/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma
 *   Date: 17-08-2020
 *   Time: 16:26
 *   File: Video.java
 */

package defination;

import java.util.Objects;

public class Video {
    private static final int DEFAULT_RATING = 0;
    private static final boolean DEFAULT_CHECKOUT = false;
    private String videoName;
    private boolean checkOut;
    private int rating;

    public Video() {
        videoName = "NOT AVAILABLE";
        rating = DEFAULT_RATING;
        checkOut = DEFAULT_CHECKOUT;
    }

    public Video(String videoName, int rating, boolean checkOut) {
        this.videoName = videoName;
        this.rating = rating;
        this.checkOut = checkOut;
    }

    public void doCheckOut() {
        if (!checkOut) { // if video is not checked out (available to rent)
            setCheckOut(true);
        }
    }

    public void doReturn() {
        if (checkOut) {
            setCheckOut(false);
        }
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    // 4. The toString() method
    public String toString() {
        return String.format(
                "Video Name: %s, Video Rating: %d, Is Video Available: %b",
                getVideoName(), getRating(), !isCheckOut()
        );
    }

    // video.equals(video2)

    // The Object class is the parent class of all the other reference types in Java.
    // i.e
    // When we create any class in Java, it automatically inherits from the Object class.

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Video video = (Video) o;
        return this.isCheckOut() == video.isCheckOut() &&
                this.getRating() == video.getRating() &&
                Objects.equals(this.getVideoName(), video.getVideoName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVideoName(), isCheckOut(), getRating());
    }
}
