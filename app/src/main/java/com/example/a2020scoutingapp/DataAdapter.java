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

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout li=(LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.data_display_view_holder,parent,false);
        return new Holder(li);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        GameData g=allData.get(position);
        holder.matchNumber.setText(g.matchNumber+"");
        holder.teamNumber.setText(g.teamNumber+"");
        holder.startPosition.setText(g.startSide);
        holder.preLoadedBalls.setText(g.preloadedBalls+"");
        holder.autoCircle.setText(g.cellsShotCircleAuto+"");
        holder.autoHex.setText(g.cellsShotHexagonAuto+"");
        holder.autoRect.setText(g.cellsShotRectAuto+"");
        holder.crossedLine.setText(g.crossedLine+"");
        holder.cellsCollected.setText(g.cellsCollected+"");
        holder.hex.setText(g.cellsShotHexagon+"");
        holder.rect.setText(g.cellsShotRect+"");
        holder.circle.setText(g.cellsShotCircle+"");
        holder.missed.setText(g.cellsMissedTele+"");
        holder.rotation.setText(g.rotationControl+"");
        holder.colorControl.setText(g.colorControl+"");
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
        private TextView preLoadedBalls;
        private TextView crossedLine;
        private TextView autoHex;
        private TextView autoRect;
        private TextView autoCircle;
        private TextView cellsCollected;
        private TextView hex;
        private TextView rect;
        private TextView circle;
        private TextView missed;
        private TextView rotation;
        private CheckBox colorControl;
        private CheckBox parked;
        private CheckBox climbed;
        private CheckBox helped;
        private CheckBox balanced;
        private CheckBox defended;
        private TextView additional;

        public Holder(@NonNull View itemView) {
            super(itemView);
            matchNumber = itemView.findViewById(R.id.matchNumberView);
            teamNumber = itemView.findViewById(R.id.teamNumberView);
            startPosition = itemView.findViewById(R.id.startPositionView);
            crossedLine = itemView.findViewById(R.id.crossedLineView);
            autoHex = itemView.findViewById(R.id.autoHexView);
            autoRect = itemView.findViewById(R.id.autoRectView);
            autoCircle = itemView.findViewById(R.id.autoCircleView);
            preLoadedBalls=itemView.findViewById(R.id.preloadedBallsView);
            cellsCollected = itemView.findViewById(R.id.cellsCollectedView);
            hex = itemView.findViewById(R.id.hexView);
            rect = itemView.findViewById(R.id.rectView);
            circle = itemView.findViewById(R.id.circleView);
            missed = itemView.findViewById(R.id.missedView);
            rotation = itemView.findViewById(R.id.rotationView);
            colorControl = itemView.findViewById(R.id.chooseColorView);
            parked = itemView.findViewById(R.id.parkedView);
            climbed = itemView.findViewById(R.id.climbedView);
            helped = itemView.findViewById(R.id.helpedView);
            balanced = itemView.findViewById(R.id.balancedView);
            defended = itemView.findViewById(R.id.defendedView);
            additional = itemView.findViewById(R.id.additionalView);

        }
    }
}
