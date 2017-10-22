package project.parsdata.com.V;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;


public class RegisterUserAdapter extends BaseAdapter {

    private Context context;
    private List<RegisterUser> RegisterUserList;
    private LayoutInflater inflater = null;


    private RequestQueue queue;

    public RegisterUserAdapter(Context context, List<RegisterUser> list) {

        this.context = context;
        this.RegisterUserList = list;
        inflater = LayoutInflater.from(context);
        queue = Volley.newRequestQueue(context);
    }


    public String getJson_String(int position , List<RegisterUser> list) {
        final RegisterUser registeruser = list.get(position);
        return  registeruser.getActiveCode().toString();
    }

    public class ViewHolder {

        TextView _title;
    }

    @Override
    public int getCount() {
        return RegisterUserList.size();
    }

    @Override
    public Object getItem(int position) {

        return RegisterUserList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        final RegisterUser registeruser = RegisterUserList.get(position);
        final ViewHolder holder;
        if(convertView == null) {

            convertView = inflater.inflate(R.layout.list_item_templates,null);
            holder = new ViewHolder();

            holder._title = (TextView) convertView.findViewById(R.id.tvtitle);

            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }


        holder._title.setText(registeruser.getAppID().toString());

        return convertView;
    }

}