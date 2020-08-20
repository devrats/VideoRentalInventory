/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma
 *   Date: 20-08-2020
 *   Time: 19:03
 *   File: VideoStore.java
 */

package defination;

import java.util.Arrays;

public class VideoStore {
    private static int numberOfVideoPresentInStore = 0;
    private Video[] store;

    public VideoStore() {
        this.store = new Video[10];
        for (int index = 0; index < store.length; index++) {
            store[index] = new Video();
        }
    }

    public VideoStore(Video[] store) {
        this.store = store;
    }

    public Video[] getStore() {
        return store.clone();
    }

    public void setStore(Video[] store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VideoStore that = (VideoStore) o;
        return Arrays.equals(getStore(), that.getStore());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getStore());
    }

    @Override
    public String toString() {
        return Arrays.toString(store);
    }

    /**
     * This method adds a Video to the VideoStore Inventory.
     *
     * @param name The name of the video to be added.
     */
    public void addVideo(String name) {
        store[numberOfVideoPresentInStore] = new Video();
        store[numberOfVideoPresentInStore].setVideoName(name);
        numberOfVideoPresentInStore++;
        System.out.println(name + " was added to the inventory.");
    }

    /**
     * This method helps us to rent a video.
     *
     * @param name The name of the video you want to rent.
     */
    public void doCheckout(String name) {
        int numberOfVideo = 0;
        for (int index = 0; index < store.length; index++) {
            numberOfVideo++;
            if (store[index].getVideoName().equalsIgnoreCase(name) && !store[index].isCheckOut()) {
                store[index].doCheckOut();
                System.out.println("Thank you for renting, " + name + ".");
                break;
            }
        }
        if (numberOfVideo == store.length) {
            System.out.println("SORRY NO SUCH VIDEO AVAILABLE");
        }
    }

    /**
     * This method returns a video back to the video rental store.
     *
     * @param name The name of the video you want to return.
     */
    public void doReturn(String name) {
        int numberOfVideo = 0;
        for (int index = 0; index < store.length; index++) {
            numberOfVideo++;
            if (store[index].getVideoName().equalsIgnoreCase(name) && store[index].isCheckOut()) {
                store[index].doReturn();
                System.out.println("Thank you for returning, " + name + ". Hope you liked it!");
                break;
            }
        }
        if (numberOfVideo == store.length) {
            System.out.println("SORRY NO SUCH VIDEO AVAILABLE");
        }
    }

    /**
     * This method sets a new rating for a video.
     *
     * @param name   The name of the video whose rating you want to set.
     * @param rating The new rating that you want to set.
     */
    public void receiveRating(String name, int rating) {
        for (Video video : store) {
            if (video.getVideoName().equalsIgnoreCase(name)) {
                video.setRating(rating);
                System.out.println("The rating of " + name + " has been set to " + rating);
            } else {
                System.out.println("Please enter Valid name 'NO SUCH VIDEO EXIST'");

            }
        }
    }

    /**
     * This method shows a list of all the videos in our inventory.
     */
    public void listInventory() {
        for (Video video : store) {
            System.out.println(video);
        }
    }
}


