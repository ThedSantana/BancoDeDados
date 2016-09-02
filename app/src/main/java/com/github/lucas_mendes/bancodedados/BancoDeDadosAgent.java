package com.github.lucas_mendes.bancodedados;

import android.app.backup.BackupAgentHelper;
import android.app.backup.BackupManager;
import android.app.backup.FileBackupHelper;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;

import java.io.File;

/**
 * Created by lucas on 01/09/16.
 */
public class BancoDeDadosAgent extends BackupAgentHelper {
    private static final String DB_NAME = "banco.db";
    private Context ctx;

    @Override
    public void onCreate(){
        FileBackupHelper dbs = new FileBackupHelper(this, DB_NAME);
        addHelper("dbs", dbs);
    }

    @Override
    public File getFilesDir(){
        File path = getDatabasePath(DB_NAME);
        return path.getParentFile();
    }
}
