package com.rzproject.assosiate.projectsatu1.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class InstingItemModel implements Parcelable {
    public String id;
    public String judul;
    public String materi;
    public String url_video;

    protected InstingItemModel(Parcel in) {
        id = in.readString();
        judul = in.readString();
        materi = in.readString();
        url_video = in.readString();
    }

    public static final Creator<InstingItemModel> CREATOR = new Creator<InstingItemModel>() {
        @Override
        public InstingItemModel createFromParcel(Parcel in) {
            return new InstingItemModel(in);
        }

        @Override
        public InstingItemModel[] newArray(int size) {
            return new InstingItemModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getMateri() {
        return materi;
    }

    public void setMateri(String materi) {
        this.materi = materi;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(judul);
        dest.writeString(materi);
        dest.writeString(url_video);
    }
}
