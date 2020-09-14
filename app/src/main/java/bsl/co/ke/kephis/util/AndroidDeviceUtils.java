package bsl.co.ke.kephis.util;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;

import bsl.co.ke.kephis.R;
// reviewed
public class AndroidDeviceUtils {

	public static boolean isGpsEnabled(Context context) {
		LocationManager manager = (LocationManager) context
				.getSystemService(Context.LOCATION_SERVICE);
		return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	}

	public static void showGpsOptions(Context context) {
		context.startActivity(new Intent(
				android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
	}

	public static void showGpsDisabledAlert(final Context context) {
		AlertDialog dialog = WidgetUtils.createYesNoAlertDialog(context,
				R.drawable.common_google_signin_btn_icon_dark, R.string.library_crossfadedrawerlayout_licenseId,
				context.getString(R.string.library_crossfadedrawerlayout_licenseId),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						showGpsOptions(context);
					}
				});
		dialog.show();
	}

	public static boolean isNetworkConnectedElseAlert(Context context,
			Class<?> callingClass) {
		boolean isOnline = isNetworkConnected(context);
		if (!isOnline) {
			ErrorHandler.logAndAlert(context, callingClass,
					context.getString(R.string.library_crossfadedrawerlayout_licenseId));
		}
		return isOnline;
	}

	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		return manager.getActiveNetworkInfo().isConnected();
	}

	@SuppressLint("MissingPermission")
    public static String getPhoneNumber(Context context) {
		TelephonyManager manager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return manager.getLine1Number();
	}
}
