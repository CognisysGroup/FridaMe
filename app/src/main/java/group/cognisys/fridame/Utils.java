package group.cognisys.fridame;

import android.content.Context;

import com.scottyab.rootbeer.RootBeer;

public class Utils {
    public static String isDeviceRooted(Context context) {
        RootBeer rootBeer = new RootBeer(context);
        boolean isRooted = rootBeer.isRooted();
        if (isRooted) {
            return "Device is Rooted!";
        }
        else {
            return "Device is safe.";
        }
    }
}
