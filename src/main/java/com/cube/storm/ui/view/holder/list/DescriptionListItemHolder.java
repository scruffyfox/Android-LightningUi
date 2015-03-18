package com.cube.storm.ui.view.holder.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cube.storm.ui.R;
import com.cube.storm.ui.model.list.DescriptionListItem;
import com.cube.storm.ui.view.Populator;
import com.cube.storm.ui.view.TextView;
import com.cube.storm.ui.view.holder.ViewHolder;
import com.cube.storm.ui.view.holder.ViewHolderController;

/**
 * View holder for {@link com.cube.storm.ui.model.list.DescriptionListItem} in the adapter
 *
 * @author Alan Le Fournis
 * @project Storm
 */
public class DescriptionListItemHolder extends ViewHolderController
{
	@Override public ViewHolder createViewHolder(ViewGroup parent)
	{
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.description_list_item_view, parent, false);
		mViewHolder = new DescriptionListItemViewHolder(view);

		return mViewHolder;
	}

	private class DescriptionListItemViewHolder extends ViewHolder<DescriptionListItem>
	{
		protected TextView title;
		protected TextView description;
		protected LinearLayout embeddedLinksContainer;

		public DescriptionListItemViewHolder(View view)
		{
			super(view);

			title = (TextView)view.findViewById(R.id.title);
			description = (TextView)view.findViewById(R.id.description);
			embeddedLinksContainer = (LinearLayout)view.findViewById(R.id.embedded_links_container);
		}

		@Override public void populateView(DescriptionListItem model)
		{
			title.populate(model.getTitle());
			description.populate(model.getDescription());
			Populator.populate(embeddedLinksContainer, model.getEmbeddedLinks());
		}
	}
}
