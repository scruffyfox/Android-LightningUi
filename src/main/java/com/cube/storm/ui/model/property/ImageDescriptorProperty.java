package com.cube.storm.ui.model.property;

import android.os.Parcel;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

public class ImageDescriptorProperty extends Property
{
	@SerializedName("x0.75") @Getter protected String x075;
	@SerializedName("x1") @Getter protected String x1;
	@SerializedName("x1.5") @Getter protected String x15;
	@SerializedName("x2") @Getter protected String x2;

	@Override public int describeContents()
	{
		return 0;
	}

	@Override public void writeToParcel(Parcel parcel, int i)
	{

	}
}