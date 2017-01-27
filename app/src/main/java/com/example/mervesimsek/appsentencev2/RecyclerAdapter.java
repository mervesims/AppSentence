package com.example.mervesimsek.appsentencev2;

/**
 * Created by Merve Şimşek on 27.1.2017.
 */
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"Greetings",
                    "Introductions",
                    "Travel" ,
                    "Accommodation" ,
                    "Shopping" ,
                    "On The Telephone" ,
                    "Making Friends" ,
                    "Health" ,
                    "Business" ,
                    "Money" ,
                    "Education"};

    private String[] details = {"Hello,How are you?, What's happening?,I'm cool!",
            "It's a great pleasure to meet you, Nice to meet you!, Let me introduce you myself",
            "What is the fare?, Do I have to change planes?, Can you tell me where to get off?",
            "I have a reservation, Would you prefer a non-smoking room?, Do you have any singles? ",
            "When are you open?, Can you measure me?, Thank you, I'm just looking",
            "Who do you want to speak with?, Mary speaking, Mary, may I help you?, The number can't be reached at the moment.",
            "She's my best friend, What a character!, May I join you?, Is this seat taken?",
            "She looks like a million bucks, You look like a hell, Do you feel all right?, I can't breathe.",
            "What is the salary?, Is it part time or full time?, It is not in my job description, I know the work from A to Z.",
            "Where is teh automatic teller machine?, I'd like to make withdrawal, I'd like to buy some foreign currency.",
            "I don't understand your English, What text are required?, What's on the test?"};

    private int[] images = { R.drawable.home,
            R.drawable.plus,
            R.drawable.search,
            R.drawable.plus,
            R.drawable.home,
            R.drawable.appsimsweb,
            R.drawable.home,
            R.drawable.search,
            R.drawable.appsimsweb,
            R.drawable.home,
            R.drawable.search };

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}