package com.example.a2020scoutingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.Holder> {

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout li=(LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.data_display_view_holder,parent,false);
        return new Holder(li);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
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
        private TextView cellsColected;
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
            preLoadedBalls = itemView.findViewById(R.id.preloadedBallsView);
            crossedLine = itemView.findViewById(R.id.crossedLineView);
            autoHex = itemView.findViewById(R.id.autoHexView);
            autoRect = itemView.findViewById(R.id.autoRectView);
            autoCircle = itemView.findViewById(R.id.autoCircleView);
            cellsColected = itemView.findViewById(R.id.cellsCollectedView);
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
