package com.codepath.instagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("w1FNrnh3Appzj9BUObugSqs0aZc0bvbSqqLcUt7i")
                .clientKey("uS9uwZt8K0mfqMi3FbDVmRWQz3rjd3sq54dmTgnC")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
