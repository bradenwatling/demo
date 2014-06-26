//package bcwatling.demo;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
//public final class NodeAdapter extends BaseAdapter {
//
//    private final Context mContext;
//    private List mObjects;
//    private int mResourceID;
//
//    public NodeAdapter(Context context, int resourceID, List objects) {
//        mContext = context;
//        mResourceID = resourceID;
//        mObjects = objects;
//    }
//
//    @Override
//    public int getCount() {
//        return mObjects.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return mObjects.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(mContext).inflate(mResourceID, parent, false);
//        }
//
//        Object element = getItem(position);
//
//        if (element instanceof Input) {
//            ImageView portView = (ImageView) convertView.findViewById(R.id.io_port);
//            TextView nameView = (TextView) convertView.findViewById(R.id.io_name);
//
//            Input input = (Input) element;
//            nameView.setText(input.getName());
//        } else if (element instanceof Output) {
//            ImageView portView = (ImageView) convertView.findViewById(R.id.io_port);
//            TextView nameView = (TextView) convertView.findViewById(R.id.io_name);
//
//            Output output = (Output) element;
//            nameView.setText(output.getName());
//        } else if (element instanceof Constant) {
//            TextView nameView = (TextView) convertView.findViewById(R.id.constant_name);
//            final EditText value = (EditText) convertView.findViewById(R.id.constant_value);
//
//            Constant constant = (Constant) element;
//            nameView.setText(constant.getName());
//        }
//
//        return convertView;
//    }
//}
//
