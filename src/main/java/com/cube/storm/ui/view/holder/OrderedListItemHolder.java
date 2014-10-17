package com.cube.storm.ui.view.holder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cube.storm.UiSettings;
import com.cube.storm.ui.R;
import com.cube.storm.ui.model.list.OrderedListItem;

/**
 * View holder for {@link com.cube.storm.ui.model.list.OrderedListItem} in the adapter
 *
 * @author Alan Le Fournis
 * @project Storm
 */
public class OrderedListItemHolder extends Holder<OrderedListItem>
{
	protected TextView annotation;
	protected TextView title;
	protected TextView description;

	@Override public View createView(ViewGroup parent)
	{
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ordered_list_item_view, parent, false);
		annotation = (TextView)view.findViewById(R.id.annotation);
		title = (TextView)view.findViewById(R.id.title);
		description = (TextView)view.findViewById(R.id.description);

		return view;
	}

	@Override public void populateView(OrderedListItem model)
	{
		if (model.getAnnotation() != null)
		{
			annotation.setText(model.getAnnotation());
		}

		if (model.getTitle() != null)
		{
			title.setText(UiSettings.getInstance().getTextProcessor().process(model.getTitle().getContent()));
		}

		if (model.getDescription() != null && !TextUtils.isEmpty(model.getDescription().getContent()))
		{
			description.setText(UiSettings.getInstance().getTextProcessor().process(model.getDescription().getContent()));
			description.setVisibility(View.VISIBLE);
		}
		else
		{
			description.setVisibility(View.GONE);
		}
	}
}
