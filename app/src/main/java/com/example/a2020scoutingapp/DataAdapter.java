package com.example.a2020scoutingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends
        RecyclerView.Adapter<DataAdapter.Holder> {
    List<GameData> allData;

    public DataAdapter(List<GameData> allData){
        this.allData=allData;

    }

    public void updateData(List<GameData> allData){
        this.allData=allData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout li=(LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.data_display_view_holder,parent,false);
        return new Holder(li);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        if(position!=0){
            holder.collumnNames.setVisibility(View.INVISIBLE);
        }
        GameData g=allData.get(position);
        holder.matchNumber.setText(g.matchNumber+"");
        holder.teamNumber.setText(g.teamNumber+"");
        holder.startPosition.setText(g.startSide);
        holder.preLoadedBalls.setChecked(g.preloadedBalls);
        holder.autoHex.setText(g.cellsShotHexagonAuto+"");
        holder.autoRect.setText(g.cellsShotRectAuto+"");
        holder.crossedLine.setChecked(g.crossedLine);
        holder.cellsCollected.setText(g.cellsCollected+"");
        holder.hex.setText(g.cellsShotHexagon+"");
        holder.rect.setText(g.cellsShotRect+"");
        holder.missed.setText(g.cellsMissedTele+"");
        holder.rotation.setText(g.rotationControl+"");
        holder.colorControl.setChecked(g.colorControl);
        holder.balanced.setChecked(g.isBalance);
        holder.balanced.setClickable(false);
        holder.parked.setChecked(g.isParked);
        holder.parked.setClickable(false);
        holder.climbed.setChecked(g.isClimbed);
        holder.climbed.setClickable(false);
        holder.helped.setChecked(g.isHelperClimbed);
        holder.helped.setClickable(false);
        holder.defended.setChecked(g.isDefended);
        holder.defended.setClickable(false);
        holder.additional.setText(g.additionalComments);
    }

    @Override
    public int getItemCount() {
        return allData.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView matchNumber;
        private TextView teamNumber;
        private TextView startPosition;
        private CheckBox preLoadedBalls;
        private CheckBox crossedLine;
        private TextView autoHex;
        private TextView autoRect;

        private TextView cellsCollected;
        private TextView hex;
        private TextView rect;

        private TextView missed;
        private TextView rotation;
        private CheckBox colorControl;
        private CheckBox parked;
        private CheckBox climbed;
        private CheckBox helped;
        private CheckBox balanced;
        private CheckBox defended;
        private TextView additional;
        private LinearLayout collumnNames;
        private TextView matchNumberq;
        private TextView teamNumberq;
        private TextView startPositionq;
        private TextView preLoadedBallsq;
        private TextView crossedLineq;
        private TextView autoHexq;
        private TextView autoRectq;

        private TextView cellsCollectedq;
        private TextView hexq;
        private TextView rectq;

        private TextView missedq;
        private TextView rotationq;
        private TextView colorControlq;
        private TextView parkedq;
        private TextView climbedq;
        private TextView helpedq;
        private TextView balancedq;
        private TextView defendedq;
        private TextView additionalq;

        public Holder(@NonNull View itemView) {
            super(itemView);
            collumnNames=itemView.findViewById(R.id.CollumNames);
            matchNumber = itemView.findViewById(R.id.matchNumberView);
            teamNumber = itemView.findViewById(R.id.teamNumberView);
            startPosition = itemView.findViewById(R.id.startPositionView);
            crossedLine = itemView.findViewById(R.id.crossedLineView);
            autoHex = itemView.findViewById(R.id.autoHexView);
            autoRect = itemView.findViewById(R.id.autoRectView);

            preLoadedBalls=itemView.findViewById(R.id.preloadedBallsView);
            cellsCollected = itemView.findViewById(R.id.cellsCollectedView);
            hex = itemView.findViewById(R.id.hexView);
            rect = itemView.findViewById(R.id.rectView);

            missed = itemView.findViewById(R.id.missedView);
            rotation = itemView.findViewById(R.id.rotationView);
            colorControl = itemView.findViewById(R.id.chooseColorView);
            parked = itemView.findViewById(R.id.parkedView);
            climbed = itemView.findViewById(R.id.climbedView);
            helped = itemView.findViewById(R.id.helpedView);
            balanced = itemView.findViewById(R.id.balancedView);
            defended = itemView.findViewById(R.id.defendedView);
            additional = itemView.findViewById(R.id.additionalView);
            /// all additional
            matchNumberq = itemView.findViewById(R.id.matchNumberViewq);
            teamNumberq = itemView.findViewById(R.id.teamNumberViewq);
            startPositionq = itemView.findViewById(R.id.startPositionViewq);
            crossedLineq = itemView.findViewById(R.id.crossedLineViewq);
            autoHexq = itemView.findViewById(R.id.autoHexViewq);
            autoRectq = itemView.findViewById(R.id.autoRectViewq);

            preLoadedBallsq=itemView.findViewById(R.id.preloadedBallsViewq);
            cellsCollectedq = itemView.findViewById(R.id.cellsCollectedViewq);
            hexq = itemView.findViewById(R.id.hexViewq);
            rectq = itemView.findViewById(R.id.rectViewq);

            missedq = itemView.findViewById(R.id.missedViewq);
            rotationq = itemView.findViewById(R.id.rotationViewq);
            colorControlq = itemView.findViewById(R.id.chooseColorViewq);
            parkedq = itemView.findViewById(R.id.parkedViewq);
            climbedq = itemView.findViewById(R.id.climbedViewq);
            helpedq = itemView.findViewById(R.id.helpedViewq);
            balancedq = itemView.findViewById(R.id.balancedViewq);
            defendedq = itemView.findViewById(R.id.defendedViewq);
            additionalq = itemView.findViewById(R.id.additionalViewq);

            //setting widths to each other
            matchNumber.setWidth(matchNumberq.getWidth());
            teamNumber.setWidth(teamNumberq.getWidth());
            startPosition.setWidth(startPositionq.getWidth());
            crossedLine.setWidth(crossedLineq.getWidth());
            autoHex .setWidth(autoHexq.getWidth());
            autoRect.setWidth(autoRectq.getWidth());

            preLoadedBalls.setWidth(preLoadedBallsq.getWidth());
            cellsCollected.setWidth(cellsCollectedq.getWidth());
            hex .setWidth(hexq.getWidth());
            rect.setWidth(rectq.getWidth());

            missed.setWidth(missedq.getWidth());
            rotation.setWidth(rotationq.getWidth());
            colorControl.setWidth(colorControlq.getWidth());
            parked.setWidth(parkedq.getWidth());
            climbed.setWidth(climbedq.getWidth());
            helped .setWidth(helpedq.getWidth());
            balanced.setWidth(balancedq.getWidth());
            defended.setWidth(defendedq.getWidth());
            additional.setWidth(additionalq.getWidth());






        }

    }
}
