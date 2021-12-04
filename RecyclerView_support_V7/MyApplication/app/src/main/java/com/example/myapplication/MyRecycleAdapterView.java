package com.example.myapplication;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



/**https://developer.android.com/guide/topics/ui/layout/recyclerview#implement-adapter
 * Implementing your adapter and view holder
 * Once you've determined your layout, you need to implement your Adapter and ViewHolder.
 * These two classes work together to define how your data is displayed.
 * The ViewHolder is a wrapper around a View that contains the layout for an individual item in the list.
 * The Adapter creates ViewHolder objects as needed, and also sets the data for those views.
 * The process of associating views to their data is called binding.
 *
 * When you define your adapter, you need to override three key methods:
 *
 * onCreateViewHolder(): RecyclerView calls this method whenever it needs to create a new ViewHolder.
 * The method creates and initializes the ViewHolder and its associated View, but does not fill in the view's contents—the ViewHolder has not yet been bound to specific data.
 *
 * onBindViewHolder(): RecyclerView calls this method to associate a ViewHolder with data.
 * The method fetches the appropriate data and uses the data to fill in the view holder's layout.
 * For example, if the RecyclerView displays a list of names, the method might find the appropriate name in the list and fill in the view holder's TextView widget.
 *
 * getItemCount(): RecyclerView calls this method to get the size of the data set.
 * For example, in an address book app, this might be the total number of addresses.
 * RecyclerView uses this to determine when there are no more items that can be displayed.
 * */


public class MyRecycleAdapterView extends RecyclerView.Adapter<MyRecycleAdapterView.MyViewHolder> {

    /**
     * Initialize the dataset of the Adapter.
     * dataset containing the data to populate views to be used by RecyclerView.
     */
    String[] name;
    int[] image;
    Context mContext;

    public MyRecycleAdapterView(String[] name, int[] image, Context mContext) {
        this.name = name;
        this.image = image;
        this.mContext = mContext;
    }

    /**
     * implement the method of RecycleView.Adapter abstract class is Required
     * onCreateViewHolder()
     * onBindViewHolder()
     * getItemCount()
     **/

    @NonNull
    // implement method of RecycleView.Adapter abstract class
    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.my_row, parent, false);

        // END_INCLUDE(recyclerViewOnCreateViewHolder)
        return new MyViewHolder(view);
    }

    // implement method of RecycleView.Adapter abstract class
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        holder.textViewName.setText(name[position]);
        holder.imageView_LogoImage.setImageResource(image[position]);
    }

    // implement method of RecycleView.Adapter abstract class
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return name.length;
    }

    /**
     * MyViewHolder class is required
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageView_LogoImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.myTextView_Name);
            imageView_LogoImage = itemView.findViewById(R.id.myImageView_LogoImage);
        }
    }
}
