package com.cube.storm.ui.model;

import android.os.Parcel;

import com.cube.storm.ui.model.descriptor.PageDescriptor;

import java.util.Collection;

import lombok.Getter;

/**
 * App class is a global data set which defines the content in the module handled by StormContent.
 *
 * This class is used when loading pages or finding out what type a page is before loading it to prevent
 * having to load up a whole file to decide what to do with it. This is primarily used with {@link com.cube.storm.ui.lib.factory.IntentFactory}
 * to decide what fragment/activity to load for a page Uri or name.
 * <br />
 * This class also has a vector Uri which tells you what the first page should be when starting the app.
 * <br />
 * You must load/create this class in your application singleton to prevent it from being cleared
 * from memory whilst the app is still open.
 * <br /><br />
 * Example load
 * <pre>
 * {@code
 * String appUri = "assets://app.json"; // This can be anything, it is loaded and dealt with by the FileFactory defined in UiSettings
 * App app = UiSettings.getInstance().getViewBuilder().buildApp(Uri.parse(appUri));
 *
 * if (app != null)
 * {
 * 	UiSettings.getInstance().setApp(app);
 * }
 * }
 * </pre>
 *
 * @author Callum Taylor
 * @project StormUI
 */
public class App extends Model
{
	@Getter private String vector;
	@Getter private Collection<PageDescriptor> map;

	@Override public int describeContents()
	{
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags)
	{

	}
}