package amirjaber.rogmax.katlist;

import android.os.Parcel;
import android.os.Parcelable;

public class GoodsModel implements Parcelable {

    private int id;
    private String name;
    private boolean check;

    GoodsModel(int id, String name, boolean check) {
        this.id = id;
        this.name = name;
        this.check = check;
    }

    private GoodsModel(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
        check = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    public static final Parcelable.Creator<GoodsModel> CREATOR = new Parcelable.Creator<GoodsModel>() {

        @Override
        public GoodsModel createFromParcel(Parcel source) {
            return new GoodsModel(source);
        }

        @Override
        public GoodsModel[] newArray(int size) {
            return new GoodsModel[size];
        }
    };
}
