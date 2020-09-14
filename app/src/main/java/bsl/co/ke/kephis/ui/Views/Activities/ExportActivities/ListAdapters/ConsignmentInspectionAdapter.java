package bsl.co.ke.kephis.ui.Views.Activities.ExportActivities.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bsl.co.ke.kephis.Pojo.ConsignmentIspectionDetails;
import bsl.co.ke.kephis.R;

public class ConsignmentInspectionAdapter extends BaseAdapter {
    Activity context;
    private ArrayList<ConsignmentIspectionDetails> consignmentIspectionDetailslist;
    private LayoutInflater inflater = null;

    public ConsignmentInspectionAdapter(Context context, ArrayList<ConsignmentIspectionDetails> consignmentIspectionDetailslist) {
        this.consignmentIspectionDetailslist = consignmentIspectionDetailslist;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return consignmentIspectionDetailslist.size();
    }


    @Override
    public Object getItem(int position) {
        return consignmentIspectionDetailslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View contentview, ViewGroup parent) {
        View itemview = contentview;

        itemview = (itemview == null) ? inflater.inflate(R.layout.farm_inspection_list, null) : itemview;
        TextView textviewdocument_no = (TextView) itemview.findViewById(R.id.textviewdocument_no);
        TextView textviewdocument_date = (TextView) itemview.findViewById(R.id.textviewdocumentdate);
        TextView textviewlicence_number = (TextView) itemview.findViewById(R.id.textviewlicenceNo);
        TextView textviewapplicant_name = (TextView) itemview.findViewById(R.id.textviewNameOfApplicant);

        ConsignmentIspectionDetails selecteditem = consignmentIspectionDetailslist.get(position);
        textviewdocument_no.setText("Document Number: " + selecteditem.getDocumentNumber());
        textviewdocument_date.setText("Document Date: " + selecteditem.getDocumentDate());
        textviewlicence_number.setText("Licence No " + selecteditem.getLicenceNumber());
        textviewapplicant_name.setText("Applicant Name " + selecteditem.getNameOfApplicant());

        return itemview;

    }
}
