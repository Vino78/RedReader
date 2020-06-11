package org.quantumbadger.redreader.reddit.prepared.html;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import org.quantumbadger.redreader.reddit.prepared.bodytext.BodyElement;
import org.quantumbadger.redreader.reddit.prepared.bodytext.BodyElementTableCell;

import java.util.ArrayList;

public class HtmlRawElementTableCell extends HtmlRawElement {

	@NonNull private final HtmlRawElementBlock mChild;

	public HtmlRawElementTableCell(@NonNull final HtmlRawElementBlock child) {
		mChild = child;
	}

	@Override
	public void reduce(
			@NonNull final HtmlTextAttributes activeAttributes,
			@NonNull final AppCompatActivity activity,
			@NonNull final ArrayList<HtmlRawElement> destination) {

		destination.add(new HtmlRawElementTableCell(mChild.reduce(activeAttributes, activity)));
	}

	@Override
	public void generate(
			@NonNull final AppCompatActivity activity,
			@Nullable final Integer textColor,
			@Nullable final Float textSize,
			@NonNull final ArrayList<BodyElement> destination) {

		final ArrayList<BodyElement> elements = new ArrayList<>();
		mChild.generate(activity, textColor, textSize, elements);

		destination.add(new BodyElementTableCell(elements));
	}
}