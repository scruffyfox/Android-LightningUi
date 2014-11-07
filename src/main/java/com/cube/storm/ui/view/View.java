package com.cube.storm.ui.view;

import com.cube.storm.ui.model.Model;

import com.cube.storm.ui.view.holder.AnimatedImageListItemHolder;
import com.cube.storm.ui.view.holder.AppCollectionItemHolder;
import com.cube.storm.ui.view.holder.ButtonListItemHolder;
import com.cube.storm.ui.view.holder.CheckableListItemHolder;
import com.cube.storm.ui.view.holder.CollectionListItemHolder;
import com.cube.storm.ui.view.holder.DescriptionListItemHolder;
import com.cube.storm.ui.view.holder.DividerHolder;
import com.cube.storm.ui.view.holder.HeaderListItemHolder;
import com.cube.storm.ui.view.holder.Holder;
import com.cube.storm.ui.view.holder.ImageListItemHolder;
import com.cube.storm.ui.view.holder.ListFooterHolder;
import com.cube.storm.ui.view.holder.ListHeaderHolder;
import com.cube.storm.ui.view.holder.LogoListItemHolder;
import com.cube.storm.ui.view.holder.OrderedListItemHolder;
import com.cube.storm.ui.view.holder.SpotlightImageListItemHolder;
import com.cube.storm.ui.view.holder.StandardListItemHolder;
import com.cube.storm.ui.view.holder.TextListItemHolder;
import com.cube.storm.ui.view.holder.TitleListItemHolder;
import com.cube.storm.ui.view.holder.ToggleableListItemHolder;
import com.cube.storm.ui.view.holder.UnorderedListItemHolder;
import com.cube.storm.ui.view.holder.VideoListItemHolder;

/**
 * This is the enum class with the list of all supported view types, their model classes and their
 * corresponding view holder class. This list should not be modified or overridden
 *
 * @author Callum Taylor
 * @project LightningUi
 */
public enum View
{
	/**
	 * Private views - These are not driven by the CMS, these are internal classes derived from
	 * the list model.
 	 */
	_ListHeader(com.cube.storm.ui.model.list.List.ListHeader.class, ListHeaderHolder.class),
	_ListFooter(com.cube.storm.ui.model.list.List.ListFooter.class, ListFooterHolder.class),
	_Divider(com.cube.storm.ui.model.list.Divider.class, DividerHolder.class),

	/**
	 * List items
	 */
	List(com.cube.storm.ui.model.list.List.class, null),
	TextListItem(com.cube.storm.ui.model.list.TextListItem.class, TextListItemHolder.class),
	ImageListItem(com.cube.storm.ui.model.list.ImageListItem.class, ImageListItemHolder.class),
	TitleListItem(com.cube.storm.ui.model.list.TitleListItem.class, TitleListItemHolder.class),
	DescriptionListItem(com.cube.storm.ui.model.list.DescriptionListItem.class, DescriptionListItemHolder.class),
	StandardListItem(com.cube.storm.ui.model.list.StandardListItem.class, StandardListItemHolder.class),
	OrderedListItem(com.cube.storm.ui.model.list.OrderedListItem.class, OrderedListItemHolder.class),
	UnorderedListItem(com.cube.storm.ui.model.list.UnorderedListItem.class, UnorderedListItemHolder.class),
	CheckableListItem(com.cube.storm.ui.model.list.CheckableListItem.class, CheckableListItemHolder.class),
	ButtonListItem(com.cube.storm.ui.model.list.ButtonListItem.class, ButtonListItemHolder.class),
	ToggleableListItem(com.cube.storm.ui.model.list.ToggleableListItem.class, ToggleableListItemHolder.class),
	LogoListItem(com.cube.storm.ui.model.list.LogoListItem.class, LogoListItemHolder.class),
	VideoListItem(com.cube.storm.ui.model.list.VideoListItem.class, VideoListItemHolder.class),
	SpotlightImageListItem(com.cube.storm.ui.model.list.SpotlightImageListItem.class, SpotlightImageListItemHolder.class),
	AnimatedImageListItem(com.cube.storm.ui.model.list.AnimatedImageListItem.class, AnimatedImageListItemHolder.class),
	HeaderListItem(com.cube.storm.ui.model.list.HeaderListItem.class, HeaderListItemHolder.class),

	/**
	 * Collection cells
	 */
	CollectionListItem(com.cube.storm.ui.model.list.collection.CollectionListItem.class, CollectionListItemHolder.class),
	AppCollectionItem(com.cube.storm.ui.model.list.collection.AppCollectionItem.class, AppCollectionItemHolder.class),

	/**
	 * Pages
	 */
	ListPage(com.cube.storm.ui.model.page.ListPage.class, null),
	TabbedPageCollection(com.cube.storm.ui.model.page.TabbedPageCollection.class, null),

	/**
	 * Descriptors
	 */
	PageDescriptor(com.cube.storm.ui.model.descriptor.PageDescriptor.class, null),
	TabbedPageDescriptor(com.cube.storm.ui.model.descriptor.TabbedPageDescriptor.class, null),

	/**
	 * Properties
	 */
	Image(com.cube.storm.ui.model.property.BundleImageProperty.class, null),
	Icon(com.cube.storm.ui.model.property.BundleImageProperty.class, null),
	AnimationImage(com.cube.storm.ui.model.property.AnimationImageProperty.class, null),
	SpotlightImage(com.cube.storm.ui.model.property.SpotlightImageProperty.class, null),
	DestinationLink(com.cube.storm.ui.model.property.DestinationLinkProperty.class, null),
	InternalLink(com.cube.storm.ui.model.property.InternalLinkProperty.class, null),
	ExternalLink(com.cube.storm.ui.model.property.ExternalLinkProperty.class, null),
	UriLink(com.cube.storm.ui.model.property.UriLinkProperty.class, null);

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