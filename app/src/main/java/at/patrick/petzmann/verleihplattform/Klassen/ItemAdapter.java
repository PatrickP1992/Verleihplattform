package at.patrick.petzmann.verleihplattform.Klassen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import at.patrick.petzmann.verleihplattform.R;

public class ItemAdapter extends ArrayAdapter<String> {

    int[] ids;
    String[] names;
    int [] resPictures;
    Context myContext;

    public ItemAdapter(@NonNull Context context,int[] ids,  String[] itemNames, int[] rePictures) {
        super(context, R.layout.listview_item);
        this.ids = ids;
        this.names = itemNames;
        this.resPictures = rePictures;
        this.myContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder myViewHolder = new ViewHolder();

        if (convertView==null){
            LayoutInflater myInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = myInflater.inflate(R.layout.listview_item,parent,false);

            myViewHolder.myResPicture =  (ImageView)convertView.findViewById(R.id.imageView);
            myViewHolder.myName = (TextView)convertView.findViewById(R.id.textView);
            convertView.setTag(myViewHolder);
        }
        else
        {
            myViewHolder = (ViewHolder) convertView.getTag();
        }

        myViewHolder.myResPicture.setImageResource(resPictures[position]);
        myViewHolder.myName.setText(names[position]);

        return convertView;
    }

    static class ViewHolder
    {
        ImageView myResPicture;
        TextView myName;
    }

}
