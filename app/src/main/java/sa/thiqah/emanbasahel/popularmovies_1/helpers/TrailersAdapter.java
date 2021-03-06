package sa.thiqah.emanbasahel.popularmovies_1.helpers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sa.thiqah.emanbasahel.popularmovies_1.R;
import sa.thiqah.emanbasahel.popularmovies_1.data.model.TrailersResult;

/**
 * Created by emanbasahel on 03/01/2018 AD.
 */

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailersHolder> {

    //region click listener interface
    public interface OnItemClickListener {

        void onItemClick(TrailersResult itemResult);
    }
    //endregion


    private final TrailersAdapter.OnItemClickListener listener;
    private List<TrailersResult> trailersResponse;


    //region constructor
    public TrailersAdapter(List<TrailersResult> movieTrailersList, OnItemClickListener _listener) {
        trailersResponse = movieTrailersList;
        listener = _listener;
    }
    //endregion

    //region ViewHolder class
    class TrailersHolder extends RecyclerView.ViewHolder {
        private TextView txtTrailersName;

        TrailersHolder(View itemView) {
            super(itemView);
            txtTrailersName = itemView.findViewById(R.id.txt_trailer_name);
        }

        //region bind views and add action listeners to them
        void bind(final TrailersResult trailerResponseItem, final OnItemClickListener mListener) {

            txtTrailersName.setText(trailerResponseItem.getName());
            txtTrailersName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClick(trailerResponseItem);
                }
            });
        }
        //endregion
    }
    //endregion

    @Override
    public TrailersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View trailerHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_trailers, parent, false);
        return new TrailersHolder(trailerHolder);
    }

    @Override
    public void onBindViewHolder(final TrailersHolder holder, int position) {
        holder.bind(trailersResponse.get(position), listener);

    }

    @Override
    public int getItemCount() {
        return trailersResponse.size();
    }


}

