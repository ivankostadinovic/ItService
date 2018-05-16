package com.example.app.itservice.Baza;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;

public class DBCServis extends IntentService implements DatabaseChangeListener {

   public DBCServis()
    {
        super("DBCServis");

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.e("GGGG","INTENT STARTOVAN");

    }

    @Override
    public void onDatabaseChangeNotification(DatabaseChangeEvent databaseChangeEvent) {
        Log.e("GGGG","PRIHVACENO!!!!!!");
    }
}
