package com.example.gpsdemo;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

public class MainActivity extends Activity implements
		GooglePlayServicesClient.ConnectionCallbacks,
		GooglePlayServicesClient.OnConnectionFailedListener, LocationListener {

	LocationClient mLocationClient;
	Location mCurrentLocation;
	LocationRequest mLocationRequest;

	TextView latView;
	TextView longView;
	TextView otherView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mLocationClient = new LocationClient(this, this, this);

		latView = (TextView) findViewById(R.id.latView);
		longView = (TextView) findViewById(R.id.longView);
		otherView = (TextView) findViewById(R.id.otherView);

		// getting updates for location
		mLocationRequest = LocationRequest.create();

		mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
		// Set the update interval to 5 seconds
		mLocationRequest.setInterval(5000);

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		mLocationClient.connect();

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		mLocationClient.disconnect();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		int resultCode = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(this);
		// If Google Play services is available
		if (ConnectionResult.SUCCESS == resultCode) {
			Toast.makeText(this, "Has Google Services", Toast.LENGTH_SHORT)
					.show();
		} else {
			Toast.makeText(this, "No Google Services", Toast.LENGTH_SHORT)
					.show();
		}

	}

	public void onLocationChanged(Location location) {
		// Report to the UI that the location was updated
		latView.setText("lattitude: " + String.valueOf(location.getLatitude()));
		longView.setText("longitude: "
				+ String.valueOf(location.getLongitude()));
		otherView
				.setText("provider: " + String.valueOf(location.getProvider()));
		Toast.makeText(this, "location changed", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onConnected(Bundle connectionHint) {
		Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();

		mCurrentLocation = mLocationClient.getLastLocation();
		mLocationClient.requestLocationUpdates(mLocationRequest, this);

		latView.setText(String.valueOf(mCurrentLocation.getLatitude()));
		longView.setText(String.valueOf(mCurrentLocation.getLongitude()));
		otherView.setText(String.valueOf(mCurrentLocation.getProvider()));

	}

	@Override
	public void onDisconnected() {
		Toast.makeText(this, "Disconnected. Please re-connect.",
				Toast.LENGTH_SHORT).show();

	}

}
