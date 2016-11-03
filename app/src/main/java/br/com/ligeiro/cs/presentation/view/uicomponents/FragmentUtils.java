package br.com.ligeiro.cs.presentation.view.uicomponents;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;


public class FragmentUtils {


    private static final String TAG = FragmentUtils.class.getSimpleName();

    /**
     *
     * @param activity
     * @param tag
     * @param instance
     * @param layout
     * @param <T>
     * @return
     */

    public static <T extends Fragment> T getOrCreate(FragmentActivity activity, String tag, T instance, int layout) {

        T result = null;
        boolean shouldAdd = false;

        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Fragment fragment = fm.findFragmentByTag(tag);

        if (fragment == null) {
            shouldAdd = true;
        } else {

            Log.d(TAG, "Found fragment instance: " + tag);
            result = (T) fragment;
        }

        if (shouldAdd) {
            Log.d(TAG, "Adding new Fragment: " + tag);

            // Use empty instance
            result = instance;
            ft.addToBackStack(tag).replace(layout, result, tag).commit();
        }

        return result;
    }

}
