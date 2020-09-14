package bsl.co.ke.kephis.util;

import android.content.Context;
import android.util.Log;

import bsl.co.ke.kephis.R;
// reviewed
public class ErrorHandler {

	public static void log(Class<?> callingClass, Throwable t) {
		Log.e(callingClass.getSimpleName(), t.toString(), t);
	}

	public static void logAndThrow(Class<?> callingClass, Throwable t) {
		log(callingClass, t);
		throw new RuntimeException(t);
	}

	public static void logAndAlert(Context context, Class<?> callingClass,
			String message, Throwable t) {
		if (t != null) {
			Log.e(callingClass.getSimpleName(), message, t);
		} else {
			Log.e(callingClass.getSimpleName(), message);
		}

		WidgetUtils.createOkAlertDialog(context, R.drawable.common_google_signin_btn_icon_dark,
				R.string.library_crossfadedrawerlayout_licenseId, message).show();
	}

	public static void logAndAlert(Context context, Class<?> callingClass,
			String message) {
		logAndAlert(context, callingClass, message, null);
	}
}
