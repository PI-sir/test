package entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid; //用户id
    @ColumnInfo(name = "phone")
    public String phone; //用户手机号
    @ColumnInfo(name = "password")
    public String password; //用户密码
}