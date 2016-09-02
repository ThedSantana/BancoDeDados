package com.github.lucas_mendes.bancodedados;

import android.app.backup.FileBackupHelper;
import android.content.Context;

/**
 * Created by lucas on 01/09/16.
 */
public class DbBackupHelper extends FileBackupHelper {

    public DbBackupHelper(Context ctx, String dbName) {
        super(ctx, ctx.getDatabasePath(dbName).getAbsolutePath());
    }
}
