package raienryu97.librarycatalog;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
    public static String[] names;
    public static String[] authors;
    public static String[] categories;
    public static String[] ids;
    public static String[] availabilities;
    private Activity context;

    public CustomList(Activity context, String[] names, String[] authors,
                      String[] categories,String[] ids, String[] availabilities) {
        super(context, R.layout.list_view_layout, ids);
        this.context = context;
        CustomList.names = names;
        CustomList.authors = authors;
        CustomList.categories = categories;
        CustomList.ids = ids;
        CustomList.availabilities = availabilities;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_view_layout, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewAuthor = (TextView) listViewItem.findViewById(R.id.textViewAuthor);
        TextView textViewCategory = (TextView) listViewItem.findViewById(R.id.textViewCategory);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        TextView textViewAvailability = (TextView) listViewItem.findViewById(R.id.textViewAvailability);

        textViewName.setText("Title: " + names[position]);
        textViewAuthor.setText("Author: " + authors[position]);
        textViewCategory.setText("Subject: " + categories[position]);
        textViewId.setText("Book ID: " + ids[position]);
        textViewAvailability.setText(availabilities[position]);
        if(availabilities[position].equals("Not Available"))
            textViewAvailability.setTextColor(Color.RED);
        else
            textViewAvailability.setTextColor(Color.parseColor("#00C853"));

        return listViewItem;
    }
}