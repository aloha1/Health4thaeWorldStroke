package com.rachelgrau.rachel.health4theworldstroke.Database;

import android.provider.BaseColumns;

/**
 * Created by Anjali on 29-Mar-17.
 */

public class passwordDB {

    private passwordDB() {};

    public static class passwordentry implements BaseColumns {
        public static final String password = "password";
    }
}
