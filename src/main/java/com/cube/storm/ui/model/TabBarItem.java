package com.cube.storm.ui.model;

import android.os.Parcel;

import com.cube.storm.ui.model.property.ImageProperty;
import com.cube.storm.ui.model.property.TextProperty;

import lombok.Getter;

/**
 * Descriptor model used for populating tab details in {@link com.cube.storm.ui.model.descriptor.TabbedPageDescriptor}
 *
 * @author Callum Taylor
 * @project StormUI
 */
public class TabBarItem extends Model
{
	@Getter protected TextProperty title;
	@Getter protected ImageProperty image;

	@Override public int describeContents()
	{
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags)
	{

	}
}
