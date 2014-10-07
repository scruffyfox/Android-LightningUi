package com.cube.storm.ui.view;

import com.cube.storm.ui.model.Model;
import com.cube.storm.ui.view.holder.DescriptionListItemHolder;
import com.cube.storm.ui.view.holder.Holder;
import com.cube.storm.ui.view.holder.ImageListItemHolder;
import com.cube.storm.ui.view.holder.ListFooterHolder;
import com.cube.storm.ui.view.holder.ListHeaderHolder;
import com.cube.storm.ui.view.holder.OrderedListItemHolder;
import com.cube.storm.ui.view.holder.StandardListItemHolder;
import com.cube.storm.ui.view.holder.TextListItemHolder;
import com.cube.storm.ui.view.holder.TitleListItemHolder;

/**
 * This is the enum class with the list of all supported view types, their model classes and their
 * corresponding view holder class. This list should not be modified or overridden
 *
 * @author Callum Taylor
 * @project Storm Test
 */
public enum View
{
	/**
	 * Private views - These are not driven by the CMS, these are internal classes derived from
	 * the list model.
 	 */
	_ListHeader(com.cube.storm.ui.model.list.List.ListHeader.class, ListHeaderHolder.class),
	_ListFooter(com.cube.storm.ui.model.list.List.ListFooter.class, ListFooterHolder.class),

	List(com.cube.storm.ui.model.list.List.class, null),
	TextListItem(com.cube.storm.ui.model.list.TextListItem.class, TextListItemHolder.class),
	ImageListItem(com.cube.storm.ui.model.list.ImageListItem.class, ImageListItemHolder.class),
	TitleListItem(com.cube.storm.ui.model.list.TitleListItem.class, TitleListItemHolder.class),
	DescriptionListItem(com.cube.storm.ui.model.list.DescriptionListItem.class, DescriptionListItemHolder.class),
	StandardListItem(com.cube.storm.ui.model.list.StandardListItem.class, StandardListItemHolder.class),
	OrderedListItem(com.cube.storm.ui.model.list.OrderedListItem.class, OrderedListItemHolder.class),

	ListPage(com.cube.storm.ui.model.page.ListPage.class, null),

	/**
	 * Properties
	 */
	Image(com.cube.storm.ui.model.property.BundleImageProperty.class, null);

	private Class<? extends Model> model;
	private Class<? extends Holder> holder;

	private View(Class<? extends Model> model, Class<? extends Holder> holder)
	{
		this.model = model;
		this.holder = holder;
	}

	/**
	 * @return Gets the holder class of the view
	 */
	public Class<? extends Holder> getHolderClass()
	{
		return holder;
	}

	/**
	 * @return Gets the model class of the view
	 */
	public Class<? extends Model> getModelClass()
	{
		return model;
	}
}
