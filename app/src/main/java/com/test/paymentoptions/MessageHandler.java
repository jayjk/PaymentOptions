package com.test.paymentoptions;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;

public class MessageHandler extends Handler {
	private Activity mactivity;

	public MessageHandler(Activity mactivity) {
		this.mactivity = mactivity;
	}

	@Override
	public void handleMessage(Message msg) {

		super.handleMessage(msg);
		switch (msg.what) {
			case 400:
				showAlert("Bad Request.", "Error");
				break;
			case 401:
				showAlert("Unauthorized. Please Enter Correct User Details.", "Error");
				break;
			case 403:
				showAlert("Request Failed. Please Try Again / Contact Support.", "Error");
				break;
			case 404:
				showAlert("Requested Resource Not Found. Please Try Again / Contact Support.", "Error");
				break;
			case 405:
				showAlert("Request Type Not Allowed.", "Error");
				break;
			case 408:
				showAlert("Request Timeout. Please Try Again.", "Error");
				break;
			case 500:
				showAlert("Internal Server Error.", "Error");
				break;
			case 501:
				showAlert("Request Method Not Implemented.", "Error");
				break;
			case 503:
				showAlert("Service Unavailable.", "Error");
				break;
			case 504:
				showAlert("Gateway Timeout. Please Try Again.", "Error");
				break;

			default:
				showAlert("Request Failed. Please Try Again.", "Error");
				break;
		}
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public void showAlert(String msg, String string) {
		final AlertDialog alertDialog = new AlertDialog.Builder(this.mactivity)
				.create();
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.setTitle(string);

		alertDialog.setMessage(msg);

		alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						alertDialog.dismiss();
					}
				});

		alertDialog.show();

	}
}
