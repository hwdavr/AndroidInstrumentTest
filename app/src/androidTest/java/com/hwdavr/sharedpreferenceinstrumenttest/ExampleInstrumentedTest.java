package com.hwdavr.sharedpreferenceinstrumenttest;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final String MY_ID = "MY_ID";
    private static final String TEST_DATA = "Test";

    @Test
    public void sharedPreferenceTest() {
        Context context = InstrumentationRegistry.getContext();
        // Set ID
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(MY_ID, TEST_DATA);
        editor.apply();

        System.loadLibrary("jnidispatch"); // load native libary

        // Get ID
        SharedPreferences sharedPref1 = PreferenceManager.getDefaultSharedPreferences(context);
        String data = sharedPref1.getString(MY_ID, null);
        Assert.assertEquals(data, TEST_DATA);
    }
}
