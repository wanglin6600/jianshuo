package org.gdgny.androidfan.coollook;

/**
 * Created by wangshangkun on 2015/8/13.
 */
public class Photo {
    private String mName;
    private int mThumbnail;
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        this.mName = name;
    }
    //book picture
    public int getThumbnail() {
        return mThumbnail;
    }
    public void setThumbnail(int thumbnail) {
        this.mThumbnail = thumbnail;
    }
}