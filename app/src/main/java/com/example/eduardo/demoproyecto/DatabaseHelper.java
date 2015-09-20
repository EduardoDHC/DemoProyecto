package com.example.eduardo.demoproyecto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Eduardo on 20/09/2015.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String  DATABASE_NAME = "agenda_eduardo.db";
    private static final int DATABASE_VERSION = 1;

    //Objetos DAO que se utilizaran para acceder a la tabla Contacto
    private Dao<Reporte,Integer> reporteDao = null;
    private RuntimeExceptionDao<Reporte,Integer> reporteRuntimeExceptionDao = null;

    public DatabaseHelper(Context context){
        //Al finalizar el helper crea archivo de configuracion ORMLite
        super(context,DATABASE_NAME,null,DATABASE_VERSION,R.raw.ormLite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource source) {

        try {
            TableUtils.clearTable(source,Reporte.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getSimpleName(), "Imposible crear la base de datos",e);
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource source, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(source,Reporte.class,true);
            onCreate(db, source);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getSimpleName(), "Imposible eliminar la base de datos",e);
            e.printStackTrace();
        }

    }

    public Dao<Reporte, Integer> getReporteDao() throws SQLException{
        if(reporteDao == null) reporteDao = getDao(Reporte.class);
        return reporteDao;
    }

    public RuntimeExceptionDao<Reporte, Integer> getReporteRuntimeExceptionDao() {
        if(reporteRuntimeExceptionDao == null) reporteRuntimeExceptionDao = getRuntimeExceptionDao(Reporte.class);
        return reporteRuntimeExceptionDao;
    }

    @Override
    public void close() {
        super.close();
        reporteDao = null;
        reporteRuntimeExceptionDao = null;
    }
}
