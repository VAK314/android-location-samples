package com.google.android.gms.location.sample.locationupdatesforegroundservicekotlin

internal object Utils {
    const val KEY_REQUESTING_LOCATION_UPDATES = "requesting_location_updates"

    /**
     * Returns true if requesting location updates, otherwise returns false.
     *
     * @param context The [Context].
     */
    fun requestingLocationUpdates(context: android.content.Context?): Boolean {
        return android.preference.PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(KEY_REQUESTING_LOCATION_UPDATES, false)
    }

    /**
     * Stores the location updates state in SharedPreferences.
     * @param requestingLocationUpdates The location updates state.
     */
    fun setRequestingLocationUpdates(context: android.content.Context?, requestingLocationUpdates: Boolean) {
        android.preference.PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(KEY_REQUESTING_LOCATION_UPDATES, requestingLocationUpdates)
                .apply()
    }

    /**
     * Returns the `location` object as a human readable string.
     * @param location  The [Location].
     */
    fun getLocationText(location: android.location.Location?): String {
        return if (location == null) "Unknown location" else "(" + location.getLatitude() + ", " + location.getLongitude() + ")"
    }

    fun getLocationTitle(context: android.content.Context): String {
        return context.getString(R.string.location_updated,
                java.text.DateFormat.getDateTimeInstance().format(java.util.Date()))
    }
}
