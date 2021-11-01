package com.hutao.myappfw;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ProjectName: MyAppFw
 * @Package: com.hutao.myappfw
 * @ClassName: Studentinfo
 * @Description: 类作用描述
 * @Author: hutao
 * @CreateDate: 2021/11/1 15:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/1 15:31
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class Studentinfo implements Parcelable {
    String name;

    public Studentinfo(String name) {
        this.name = name;
    }

    protected Studentinfo(Parcel in) {
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Studentinfo> CREATOR = new Creator<Studentinfo>() {
        @Override
        public Studentinfo createFromParcel(Parcel in) {
            return new Studentinfo(in);
        }

        @Override
        public Studentinfo[] newArray(int size) {
            return new Studentinfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}