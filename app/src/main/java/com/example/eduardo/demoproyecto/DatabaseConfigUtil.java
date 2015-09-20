package com.example.eduardo.demoproyecto;

import android.database.sqlite.SQLiteException;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Eduardo on 20/09/2015.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {
    public static void main(String[] args ) throws IOException, SQLException {
        writeConfigFile("ormLite_config.txt");
    }
}
