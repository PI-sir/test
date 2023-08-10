package db;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import dao.UserDao;
import entity.User;

@Database(entities = { User.class }, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

