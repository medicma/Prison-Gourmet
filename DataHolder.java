package com.wolfenterprisesllc.prisongourmet;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseInstallation;

public class DataHolder extends Application{
    String list;

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(getBaseContext())
                .applicationId("")
                .clientKey("")
                .server("https://parseapi.back4app.com")
                 .enableLocalDataStore()
                .build());
        // Parse.initialize(this, "pQ3hJlWh9LiIVJ6iETzOS6Tg6ForXuiyATQCJoNZ", "0AZ7o8sKrkRcj18z4AxWDSkWsz7qWR3hmqQJhKIa");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
