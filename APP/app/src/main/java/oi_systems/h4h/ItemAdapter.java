package oi_systems.h4h;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Šarūnas on 2018-06-03.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    String[] items;

    public ItemAdapter(Context c,String[] i){
        items = i;
        layoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = layoutInflater.inflate(R.layout.my_profile_listview_detail, null);
        TextView listTextView = (TextView) v.findViewById(R.id.listTextView);

        String name = items[i];

        listTextView.setText(name);

        return v;
    }
}
