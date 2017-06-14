package com.example.kmj.decisionthisorder;

import android.os.Parcel;
import android.os.Parcelable;

import static java.io.FileDescriptor.in;


/**
 * Created by KMJ on 2017-06-12.
 */

public class Data implements Parcelable {
    public String Name;
    public String Major;
    public String Description;
    public int Imgno;
    public Data(String Name, String Major, String Description, int Imgno) {
        this.Name = Name;
        this.Major = Major;
        this.Description = Description;
        this.Imgno=Imgno;
    }

    protected Data(Parcel in){
        Name = in.readString();
        Major= in.readString();
        Description = in.readString();
        Imgno = in.readInt();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Major);
        dest.writeString(Description);
        dest.writeInt(Imgno);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImgno() {
        return Imgno;
    }

    public void setImgno(int imgno) {
        Imgno = imgno;
    }

    public String toString() {
        return Name;
    }
}
