package com.example.app.itservice.Baza;

import android.util.Log;

import android.util.Log;

import oracle.jdbc.dcn.DatabaseChangeListener;

    /**
     * Created by MocaPC on 4/29/2018.
     */

    public class DBListener implements DatabaseChangeListener {


        @Override
        public void onDatabaseChangeNotification(oracle.jdbc.dcn.DatabaseChangeEvent e) {
            synchronized( this) {
                try {
                    Log.e("GG","zivi");
                } catch (Exception ex) {
                    Log.e("GG",ex.toString());
                }
            }
        }
    }
