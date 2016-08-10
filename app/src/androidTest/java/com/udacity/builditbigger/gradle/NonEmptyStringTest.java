package com.udacity.builditbigger.gradle;

import android.test.AndroidTestCase;
import android.util.Log;

import com.udacity.gradle.EndpointsAsyncTask;

/**
 * Created by carolinestewart on 8/1/16.
 */

public class NonEmptyStringTest extends AndroidTestCase {
        private static final String LOG_TAG = "non-empty string stest";

        @SuppressWarnings("unchecked")
        public void test() {


            Log.v("non-empty string test", "running non-empty string test");
            String result = null;
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext());
            endpointsAsyncTask.execute();
            try {
                result = endpointsAsyncTask.get();
                Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertNotNull(result);
        }


    }
