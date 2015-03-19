package com.cube.storm.ui.view.holder.grid;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cube.storm.UiSettings;
import com.cube.storm.ui.R;
import com.cube.storm.ui.model.grid.StandardGridItem;
import com.cube.storm.ui.model.property.LinkProperty;
import com.cube.storm.ui.view.holder.GridViewHolder;
import com.cube.storm.ui.view.holder.ViewHolderFactory;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * // TODO: Add class description
 *
 * @author Matt Allen
 * @project LightningUi
 */
public class StandardGridItemViewHolder extends GridViewHolder<StandardGridItem>
{
	public static class Factory extends ViewHolderFactory
	{
		@Override public StandardGridItemViewHolder createViewHolder(ViewGroup parent)
		{
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.standard_grid_cell_view, parent, false);
			return new StandardGridItemViewHolder(view);
		}
	}

	protected ImageView image;
	protected TextView title;
	protected TextView description;
	protected LinkProperty link;
	protected LinearLayout embeddedLinksContainer;

	public StandardGridItemViewHolder(View view)
	{
		super(view);

		image = (ImageView)view.findViewById(R.id.image);
		title = (TextView)view.findViewById(R.id.title);
		description = (TextView)view.findViewById(R.id.description);
		embeddedLinksContainer = (LinearLayout)view.findViewById(R.id.embedded_links_container);
	}

	@Override public void populateView(final StandardGridItem model)
	{
		link = model.getLink();
		image.setVisibility(View.GONE);

		if (model.getImage() != null)
		{
			UiSettings.getInstance().getImageLoader().displayImage(model.getImage().getSrc(), image, new SimpleImageLoadingListener()
			{
				@Override public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)
				{
					if (loadedImage != null)
					{
						image.setVisibility(View.VISIBLE);
					}
				}

				@Override public void onLoadingFailed(String imageUri, View view, FailReason failReason)
				{
					if (!imageUri.equalsIgnoreCase(model.getImage().getFallbackSrc()))
					{
						UiSettings.getInstance().getImageLoader().displayImage(model.getImage().getFallbackSrc(), image, this);
					}
				}
			});
		}

		description.setVisibility(View.GONE);
		title.setVisibility(View.GONE);

		if (model.getTitle() != null)
		{
			String content = UiSettings.getInstance().getTextProcessor().process(model.getTitle().getContent());

			if (!TextUtils.isEmpty(content))
			{
				title.setText(content);
				title.setVisibility(View.VISIBLE);
			}
		}

		if (model.getDescription() != null)
		{
			String content = UiSettings.getInstance().getTextProcessor().process(model.getDescription().getContent());

			if (!TextUtils.isEmpty(content))
			{
				description.setText(content);
				description.setVisibility(View.VISIBLE);
			}
		}
	}
}
