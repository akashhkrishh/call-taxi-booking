package com.taxi.model;

import com.taxi.constants.TaxiConstants;

public enum Location {
    A, B, C, D, E, F;

    public int getDistance(Location other) {
        return Math.abs(this.ordinal() - other.ordinal()) * TaxiConstants.DISTANCE_BETWEEN_POINTS;
    }

    public int getNearByDistance(Location other) {
        return Math.abs(this.ordinal() - other.ordinal());
    }
}
